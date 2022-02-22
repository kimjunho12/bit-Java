console.log("=== Global Object ===");

global.name = '둘리';
var name = 22;
console.log(name, global.name);

// cf
email = 'dooly@gmail.com';
console.log(email, global.email);

console.log("=== function의 객체 메소드 apply ===");
var f1 = function() {
    console.log(this);
}
f1();

// this 바꾸기
var o = {
    name: '마이콜'
}
f1.apply(o);

console.log("=== function의 객체 메소드 call ===");
var f2 = function(s1, s2) {
    console.log(s1 + " " + s2 + " " + this.name);
}
f2('hi', 'bye');

f2.call(o, 'Hello', 'World');
f2.apply(o, ['Hello', 'World']);