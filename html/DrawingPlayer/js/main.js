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

    var playButton = document.getElementById("playButton");
    playButton.onclick = function() {
        organizeCoordinates();
        console.log(coordinatesMap);
        // playMusic();
    }

    function organizeCoordinates() {
        coordinatesMap = []; // "HashMap"
        for (i = 0; i < pointsArr.length-1; i+=2) {
            for (j = 0; j < coordinatesMap.length; j++) { // !!! check inequality conditional
                if (coordinatesMap[j].y == []) {
                    coordinatesMap.push({
                        x:pointsArr[i],
                        y:[pointsArr[i+1]]
                    });
                } else if (coordinatesMap[j].x == pointsArr[i]) {
                    coordinatesMap[j].y.push(pointsArr[i+1]);
                }
            }
        }
    }

    function organizeCoordinates2(coordinatesArr) {
        if (coordinatesArr.length == 0) {
            return coordinatesArr;
        }

        var newCoordinatesMap = [];

        var currX = coordinatesArr[0].x;
        var currYArr = [];
        for (i = 0; i < coordinatesArr.length; i++) {

            if (coordinatesArr[i].x == currX) {
                console.log('hold onnnn......... lets see what currYArr is .... hmmmmmmm');
                console.log('currYArr: ' + currYArr);
                currYArr.push(coordinatesArr[i].y);
            } else {
                console.log('this should only get printed once...');
                console.log('currX: ' + currX);
                console.log('currYArr: ' + currYArr);
                newCoordinatesMap.push({x: currX, y: currYArr});
                console.log(JSON.stringify(newCoordinatesMap));
                currX = coordinatesArr[i].x;
                currYArr = [];
                // currYArr.length = 0;
                i--;
            }

            console.log('outside of the if else block:');
            console.log(JSON.stringify(newCoordinatesMap));

        }
        console.log('new newCoordinatesMap:');
        console.log(JSON.stringify(newCoordinatesMap));
        newCoordinatesMap.push({x: currX, y: currYArr});
        console.log(JSON.stringify(newCoordinatesMap));
    }

    function includesX(coordinates, x) {
        for (i = 0; i < coordinates.length; i++) {
            if (coordinates[i].x == x) {
                return true;
            }
        }
        return false;
    }

    function getY(coordinates, x) {
        // return all y values for the given x value in the coordinates array
    }


    function playMusic() {
        for (i = 0; i < pointsArr.length/2; i++) {
            var y = pointsArr[2*i + 1];
            var frequency = lower + increment*(canvas.height - 1 - y);
            playNote(frequency, 1000);
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

    var clearButton = document.getElementById("clearButton");
    clearButton.onclick = function() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        pointsArr.length = 0;
        coordinatesArr.length = 0;
    }

    var printButton = document.getElementById("printButton");
    printButton.onclick = function() {
        // console.log(pointsArr);
        // coordinatesArr = sortCoordinates(coordinatesArr);
        // organizeCoordinates2(coordinatesArr);



/*
        console.log('***** STARTING TEST *****');
        var newCoordinatesMap2 = [];
        console.log('newCoordinatesMap2');
        console.log(JSON.stringify(newCoordinatesMap2));
        var currX = 8;
        var currYArr = [10, 7];
        console.log('currX: ' + currX);
        console.log('currYArr: ' + currYArr);
        console.log('newCoordinatesMap2');
        console.log(JSON.stringify(newCoordinatesMap2));
        

        console.log('***** PUSHING CURRX AND CURRYARR TO NEWCOORDINATESMAP2 *****');
        newCoordinatesMap2.push({x: currX, y: currYArr});
        console.log('currX: ' + currX);
        console.log('currYArr: ' + currYArr);
        console.log('newCoordinatesMap2');
        console.log(JSON.stringify(newCoordinatesMap2));

        console.log('***** CHANGING CURRX AND CURRYARR *****');
        currX = 0;
        currYArr = [];
        currYArr.push(9);
        console.log('currX: ' + currX);
        console.log('currYArr: ' + currYArr);
        console.log('newCoordinatesMap2');
        console.log(JSON.stringify(newCoordinatesMap2));

        console.log('***** PUSHIGN NEW CURRX AND CURRYARR TO NEWCOORDINATESMAP2 *****');
        newCoordinatesMap2.push({x: currX, y: currYArr});
        console.log('newCoordinatesMap2 2nd time');
        console.log(JSON.stringify(newCoordinatesMap2));
*/




        coordinates = [{x: 0, y: 9}, {x: 8, y: 10}, {x: 8, y: 7}];

        coordinates = sortCoordinates(coordinates);
        organizeCoordinates2(coordinates);
    }
}