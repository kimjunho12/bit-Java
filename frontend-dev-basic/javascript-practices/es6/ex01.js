/**
 *  let: block scope의 변수
 */

try {
  if (true) {
    var i = 10;
    let j = 20;
  }
  console.log(i, j);
} catch (e) {
  console.error("error : " + e);
}

// cf. var 함수 범위
try {
  let f = function () {
    var m = 20;
  };
  f();

  console.log(m);
} catch (error) {
  console.error(`error : ${error}`);
}
