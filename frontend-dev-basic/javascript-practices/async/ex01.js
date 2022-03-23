const ex01 = (param, callback) => {
  //
  // 비동기 코드 : 파일 시스템 접근, 통신, SQL to DB
  setTimeout(() => {
    param === "param-data"
      ? callback(null, "ok")
      : callback(new Error("fail"), "");
  }, 2000);
  //
};

// test01 : success
ex01("param-data", (error, result) => {
  error ? console.error(error) : console.log(result);
});

// test02 : fail
ex01("param", (error, result) => {
  error ? console.error(error) : console.log(result);
});

console.log("wait....");
