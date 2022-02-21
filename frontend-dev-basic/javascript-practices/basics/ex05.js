/*
    구문(statement)
    1. 자바의 실행 단위
    2. 구문의 구성 요소
        - 값, 연산자 : 표현식
        - 주석 : 구문을 구성해도 실행 되지 않는다.
        - 예악어 : if, const, for, ...
    3. 구문의 예
        - 주석 구문
        - if(condition) {...}
        - if ~ else
        - switch
        - for, while, do ~ while, for ~ in
    4. 공백 : 토큰 분리
    5. 세미콜론 ;
        - 원칙적으로 구문을 분리
        - 표현식을 표현식구문으로 만들어서 표현식을 실행하게 한다.
    6. 개행
*/

i = 10;
j = 10;
i;

// 개행의 역할 1 : ;를 대체
// 개행의 역할 2 : 토큰을 분리
// 어쩔때 1 or 2 : 자바스크립트 엔진이 에러없는 실행을 우선 원칙으로 1번과 2번을 판단

// 1) 예
var s = "hello world";
console.log(s);

// 2) 예
a = 2 + 2;

// cf
// con
// sole.log(a)

i = 10;
console.log(i);

o = {};

f = function() {};

if (i == 10) {}