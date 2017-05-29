var demoFunction = function () {
    console.log('this is a demo function.');
};

demoFunction();

var intHandler = setInterval(demoFunction, 1000);

var endTimer = function () {
    clearInterval(intHandler);
}

setInterval(endTimer, 5000);



///clearInterval(intHandler);