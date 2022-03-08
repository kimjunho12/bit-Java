// 블록 스코프 변수 (ex6)
var users = [{
  no: 1,
  name: '마이콜',
  email: 'michol@gmail.com'
}, {
  no: 2,
  name: '둘리',
  email: 'dooly@gmail.com'
}]; // 객체 분해 (es6)

function print(_ref) {
  var {
    no,
    name,
    email
  } = _ref;
  console.log(no + ", " + name + ", " + email); // 탬플릿 문자열(es6)

  console.log("".concat(no, ", ").concat(name, ", ").concat(email));
} // for..of (es6)


for (var _i = 0, _users = users; _i < _users.length; _i++) {
  var user = _users[_i];
  print(user);
}
