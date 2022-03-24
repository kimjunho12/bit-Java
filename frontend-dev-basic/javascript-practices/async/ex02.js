const fetch = (param) => {
  return new Promise((resolve, reject) => {
    // 비동기 코드 : 파일 시스템 접근, 통신, SQL to DB
    setTimeout(() => {
      param === "param-data" ? resolve("ok") : reject(new Error("fail"));
    }, 2000);
  });
};

if (require.main === module) {
  // test01 : success
  fetch("param-data").then((res) => {
    console.log(res);
  });

  // test02 : fail
  fetch("param-error").catch((err) => {
    console.error(err);
  });

  // 일반적으로
  // fetch("param...")
  //   .then((res) => {})
  //   .catch((err) => {});

  console.log("wait....");
} else {
  module.exports = fetch;
}
