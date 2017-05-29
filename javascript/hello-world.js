var foo = function() {
    var a = 10;
    var b = function(c, d) {
        var sum = a + c + d;
        console.log('The sum is:' + sum);
        a++;
    };
    return b;
};

var bar = foo();
bar(12, 13);
bar(12, 13);

foo();
bar(12, 13);