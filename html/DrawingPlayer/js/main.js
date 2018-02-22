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
    var coordinatesArr = [];

    var audioCtx = new (window.AudioContext || window.webkitAudioContext)();

    var lower = 300, upper = 1000;
    var increment;

    var coordinatesMap = [];

    var soundLength = 1000;

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
            coordinatesArr.push({x:currX, y:currY});
        }
        if (s == "mousemove") {
            if (mouseClicked) {
                prevX = currX;
                prevY = currY;
                currX = event.clientX - canvasLeft;
                currY = event.clientY - canvasTop;
                // drawSquare();
                draw();
                pointsArr.push(currX, currY);
                coordinatesArr.push({x:currX, y:currY});
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
    }

    function drawSquare() {
        ctx.beginPath();
        ctx.fillStyle = drawingColor;
        ctx.fillRect(currX-thickness/2, currY-thickness/2, thickness, thickness);
    }

    function organizeCoordinates(coordinatesArr) {
        if (coordinatesArr.length == 0) {
            return coordinatesArr;
        }

        coordinatesMap = [];

        var currX = coordinatesArr[0].x;
        var currYArr = [];
        for (i = 0; i < coordinatesArr.length; i++) {

            if (coordinatesArr[i].x == currX) {
                currYArr.push(coordinatesArr[i].y);
            } else {
                coordinatesMap.push({x: currX, y: currYArr});
                currX = coordinatesArr[i].x;
                currYArr = [];
                // currYArr.length = 0;
                i--;
            }

        }
        coordinatesMap.push({x: currX, y: currYArr});
        return coordinatesMap;
    }

    function includesX(coordinates, x) {
        for (i = 0; i < coordinates.length; i++) {
            if (coordinates[i].x == x) {
                return true;
            }
        }
        return false;
    }

    function playMusic() {

        for (i = 0; i < canvas.width; i++) {
            if (!includesX(coordinatesMap, i)) {
                playNullNote();
            } else {
                playAllNotes(coordinatesMap[i].y);
            }
        }
    }

    function playNullNote() {
        // play nothing for soundLength milliseconds
    }

    function playAllNotes(notes) {
        for (i = 0; i < notes.length; i++) {
            var frequency = lower + increment*(canvas.height - 1 - notes[i]);
            playNote(frequency, soundLength);
        }
    }

    function sortCoordinates(coordinatesArr) {
        coordinatesArr.sort(function(a, b) {
            return a.x - b.x;
        });
        return coordinatesArr;
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

    function playMusic2() {
        /*
        for (i = 0; i < 4; i++) {
            var frequency = lower + increment*(canvas.height - 1 - (100*i));
            playNote(frequency, soundLength);
        }
        */
    }

    var playButton = document.getElementById("playButton");
    playButton.onclick = function() {
        coordinatesArr = sortCoordinates(coordinatesArr);
        coordinatesMap = organizeCoordinates(coordinatesArr);
        console.log(JSON.stringify(coordinatesMap));
        playMusic2();
    }

    var clearButton = document.getElementById("clearButton");
    clearButton.onclick = function() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        pointsArr.length = 0;
        coordinatesArr.length = 0;
    }

    var printButton = document.getElementById("printButton");
    printButton.onclick = function() {
        coordinatesArr = sortCoordinates(coordinatesArr);
        coordinatesMap = organizeCoordinates(coordinatesArr);
    }
}