// 블록 스코프 변수 (ex6)

const users = [{
    no: 1,
    name: '마이콜',
    email: 'michol@gmail.com'
}, {
    no: 2,
    name: '둘리',
    email: 'dooly@gmail.com'
}];

// 객체 분해 (es6)
function print({ no, name, email }) {
    console.log(no + ", " + name + ", " + email);

    // 탬플릿 문자열(es6)
    console.log(`${no}, ${name}, ${email}`);
}

// for..of (es6)
for (let user of users) {
    print(user);
}