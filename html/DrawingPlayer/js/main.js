window.onload = function() {
    drawSquare();

    function drawSquare() {
        var canvas = document.getElementById("myCanvas");
        var ctx = canvas.getContext("2d");

        var centerX = canvas.width / 2;
        var centerY = canvas.height / 2;
        var side = 20;
        var thickness = 2;

        var canvasLeft = canvas.offsetLeft;
        var canvasTop = canvas.offsetTop;

        ctx.beginPath();
        ctx.rect(centerX, centerY, side, side);
        ctx.fillStyle = "#cecece";
        ctx.fill();
        ctx.lineWidth = thickness;
        ctx.strokeStyle = "#444444";
        ctx.stroke();

        canvas.addEventListener('click', function(event) {
            console.log(event.clientX - canvasLeft);
            console.log(event.clientY - canvasTop);
            console.log("Hello world!");
        });
    }

    var canvas;
    var ctx;

    var canvasLeft;
    var canvasRight;

    var prevX = 0, currX = 0;
    var prevY = 0; currY = 0;

    var thickness = 2;

    function init() {
        canvas = document.getElementById("myCanvas");
        ctx = canvas.getContext("2d");

        canvasLeft = canvas.offsetLeft;
        canvasTop = canvas.offsetTop;

        canvas.addEventListener("mousedown", function(event) {
            findxy("mousedown", event);
        });

        canvas.addEventListener("mouseover", function(event) {
            findxy("mouseover", event);
        });
    }

    function findxy(s, event) {
        if (s == "mousedown") {
            prevX = currX;
            prevY = currY;
            currX = event.clientX - canvasLeft;
            currY = event.clientY - canvasTop;
            drawDot();
        } else if (s == "mouseover") {
            prevX = currX;
            prevY = currY;
            currX = event.clientX - canvasLeft;
            currY = event.clientY - canvasTop;
        }
    }

    function drawDot() {
        ctx.beginPath();
        ctx.moveTo(currX, currY);
        ctx.lineTo(currX, currY);
        ctx.strokeStyle = "black";
        ctx.lineWidth = thickness;
        ctx.stroke();
        // ctx.closePath();
    }


}