function arrayNumber(arr, num) {
    for(var i = 0; i < arr.length; i++) {
        if(arr[i] == num) {
            return i;
        }
    }
}

var index = arrayNumber([3, 4, 6, 1, 2], 2);
console.log(index);