var arr = [3, 4, 6, 1, 2];
var small = Infinity;
for(var i = 0; i < arr.length; i++) {
    if(arr[i] < small) {
        small = arr[i];
    }
}
console.log(small);