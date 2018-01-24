var arr = [3, 20, 2, 24, 1, 18, 4, 50];
sortArrayByX(arr);

function sortArrayByX(arr) {
    // base case
    if (arr.length == 2) {
        return arr;
    }

    var arrA = [];
    var arrB = [];

    for (i = 0; i < arr.length/2; i++) {
        arrA.push(arr[i]);
    }
    for (i = arr.length/2; i < arr.length; i++) {
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