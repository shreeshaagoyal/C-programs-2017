window.onload = function() {

    var canvas;
    var ctx;

    var canvasLeft;
    var canvasRight;

    var prevX = 0, currX = 0;
    var prevY = 0; currY = 0;

    var thickness = 5;

    var drawingColor = "black";

    var flag = false;
    var dotFlag = false;

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
    }

    function findxy(s, event) {
        if (s == "mousedown") {
            prevX = currX;
            prevY = currY;
            currX = event.clientX - canvasLeft;
            currY = event.clientY - canvasTop;
            flag = true;
            dot_flag = true;
            if (dot_flag) {
                drawRect();
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
                pointsArr.push(currX, currY);
            }
        } else if (s == "mousemove") {
            if (flag) {
                prevX = currX;
                prevY = currY;
                currX = event.clientX - canvasLeft;
                currY = event.clientY - canvasTop;
                drawDot();
            }
        }
    }

    function drawDot() {
        ctx.beginPath();
        ctx.moveTo(currX, currY);
        ctx.lineTo(currX, currY);
        ctx.strokeStyle = drawingColor;
        ctx.lineWidth = thickness;
        ctx.stroke();
        ctx.closePath();
    }

    function drawRect() {
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
}