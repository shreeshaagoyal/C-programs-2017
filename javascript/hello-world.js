function factorial (num) {
    if (num == 1) {
        return 1;
    }
    return num * factorial(num - 1);
}

function getArray(num) {
    var arr = [];
    for (var i = 0; i < num; i++) {
        arr[i] = i;
    }
    return arr;
}

function main() {
    var arr = getArray(10);
    var foo = arr;
    foo[2] = 100;
    console.log(arr);
}

main();