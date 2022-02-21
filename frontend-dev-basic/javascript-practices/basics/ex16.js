/*
    function 타입의 객체 (함수)
*/

// 함수를 생성하는 방법 1 : 함수 리터럴
function f1(a, b) {
    return a + b;
}

console.log(typeof(f1), f1(10, 20));

// 함수를 생성하는 방법 2 : 함수 리터럴 (추천)
var f2 = function(a, b) {
    return a + b;
}
console.log(typeof(f2), f2(10, 20));

// 함수를 생성하는 방법 3 : new 연산자와 함께 Function() 생성자 함수를 사용하는 방법
var f3 = new Function("a", "b", "return a + b");
console.log(typeof(f3), f3(10, 20));

// 함수를 생성하는 방법 4 : 익명(Anonymouse) 함수
// callback
setTimeout(function() {
    console.log("time out!!!");
}, 1000);

// 즉시 실행하는 함수
var s = (function(a, b) {
    var m = 10;
    return a / 10 + b / 10;
})(10, 20);
console.log(s);

// 가변 파라미터 함수
var sum = function() {
    console.log(arguments instanceof Array, arguments.length); // Array가 아니다! 유사 배열

    var sum = 0;
    // for (var i = 0; i < arguments.length; i++) {
    //     sum += arguments[i];
    // }

    // Error : arguments의 __proto__는 Object의 prototype에 chain이 되어있기 때문
    // arguments.forEach(e => {
    //     sum += e;
    // });

    Array.prototype.forEach.call(arguments, function(e) {
        sum += e;
    });

    return sum;
}



console.log(sum(10));
console.log(sum(10, 20));
console.log(sum(10, 20, 30));
console.log(sum(10, 20, 30, 40, 50));