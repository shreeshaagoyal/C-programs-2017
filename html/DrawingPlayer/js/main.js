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
                // drawSquare();
                draw();
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

    foo = [{x:355, y:302}, {x:299, y:113}, {x:829, y:200}, {x:300, y:200}];

    foo.sort(function(a,b){
        return a.x - b.x;
    });

    var arr = [1, 2, 3, 4, 5, 6, 7, 8]
    var coordinates = [];
    for (i = 0; i < arr.length-1; i+=2) {
        coordinates.push({
            x:arr[i],
            y:arr[i+1]
        });
    }

    function sortArrayByX(arr) {

        // base case
        if (arr.length <= 2) {
            return arr;
        }

        var arrA = [];
        var arrB = [];

        var a = Math.floor(arr.length/2);
        var b = Math.floor(a/2);
        var c = Math.floor(b*2);

        for (i = 0; i < c; i++) {
            arrA.push(arr[i]);
        }
        for (i = c; i < arr.length; i++) {
            arrB.push(arr[i]);
        }

        var list1 = sortArrayByX(arrA);
        var list2 = sortArrayByX(arrB);

        return mergeArrayByX(list1, list2);
    }

    function mergeArrayByX(list1, list2) {
        
        var resultArr = [];
        var cursor1 = 0, cursor2 = 0;

        while((cursor1 < list1.length) || (cursor2 < list2.length)) {
            if (getVal(list1, cursor1) < getVal(list2, cursor2)) {
                resultArr.push(getVal(list1, cursor1));
                resultArr.push(getVal(list1, cursor1+1));
                cursor1+=2;
            } else {
                resultArr.push(getVal(list2, cursor2));
                resultArr.push(getVal(list2, cursor2+1));
                cursor2+=2;
            }
        }

        return resultArr;
    }

    function getVal(list, cursor) {
        if (cursor >= list.length) {
            return Infinity;
        } else {
            return list[cursor];
        }
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
    }

    var printButton = document.getElementById("printButton");
    printButton.onclick = function() {
        console.log(pointsArr);
        console.log("Sorted array: " + sortArrayByX(pointsArr));
    }
}