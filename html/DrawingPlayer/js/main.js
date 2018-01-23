window.onload = function() {

    var canvas;
    var ctx;

    var canvasLeft;
    var canvasRight;

    var prevX = 0, currX = 0;
    var prevY = 0; currY = 0;

    var thickness = 5;

    var drawingColor = "black";

    var mouseClicked = false;

    var pointsArr = [];

    var audioCtx = new (window.AudioContext || window.webkitAudioContext)();

    var lower = 300, upper = 1000;
    var increment;

    init();

    function init() {
        canvas = document.getElementById("myCanvas");
        ctx = canvas.getContext("2d");

        increment = (upper - lower) / canvas.height;

        canvasLeft = canvas.offsetLeft;
        canvasTop = canvas.offsetTop;

        canvas.addEventListener("mousedown", function(event) {
            findxy("mousedown", event);
        });

        canvas.addEventListener("mousemove", function(event) {
            findxy("mousemove", event);
        });

        canvas.addEventListener("mouseup", function(event) {
            findxy("mouseup", event);
        });
    }

    function findxy(s, event) {
        if (s == "mousedown") {
            prevX = currX;
            prevY = currY;
            currX = event.clientX - canvasLeft;
            currY = event.clientY - canvasTop;
            mouseClicked = true;
            drawSquare();
            pointsArr.push(currX, currY);
            
            /**
            var yArr;
            if (xyMap.containsKey(currX)) {
                // !!! could be made more efficient?
                yArr = xyMap.get(currX);
                yArr.push(currY);
            } else {
                yArr = [currY];
            }
            xyMap.put(currX, yArr);
            */
        }
        if (s == "mousemove") {
            if (mouseClicked) {
                prevX = currX;
                prevY = currY;
                currX = event.clientX - canvasLeft;
                currY = event.clientY - canvasTop;
                drawSquare();
                pointsArr.push(currX, currY);
            }
        }
        if (s == "mouseup") {
            mouseClicked = false;
        }
    }

    function draw() {
        ctx.beginPath();
        ctx.moveTo(prevX, prevY);
        ctx.lineTo(currX, currY);
        ctx.strokeStyle = drawingColor;
        ctx.lineWidth = thickness;
        ctx.stroke();
        // ctx.closePath();
    }

    function drawSquare() {
        ctx.beginPath();
        ctx.fillStyle = drawingColor;
        ctx.fillRect(currX-thickness/2, currY-thickness/2, thickness, thickness);
        dot_flag = false;
    }

    var playButton = document.getElementById("playButton");
    playButton.onclick = function() {
        console.log(pointsArr);
        playMusic();
    }

    function playMusic() {
        pointsArr = sortArrayByX(pointsArr);
        for (i = 0; i < pointsArr.length/2; i++) {
            var y = pointsArr[2*i + 1];
            var frequency = lower + increment*(canvas.height - 1 - y);
            playNote(frequency, 1000);
        }
    }

    function sortArrayByX() {
        // !!! implement
        return pointsArr;
    }

    function playNote(frequency, duration) {
        // create Oscillator node
        var oscillator = audioCtx.createOscillator();

        oscillator.type = 'square';
        oscillator.frequency.value = frequency; // value in hertz
        oscillator.connect(audioCtx.destination);
        oscillator.start();

        setTimeout(function(){
            oscillator.stop();
        }, duration);
    }

    var clearButton = document.getElementById("clearButton");
    clearButton.onclick = function() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        pointsArr.clear();
    }
}