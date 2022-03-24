const fetch = require("./ex02");

const ex03 = async (param) => {
  try {
    const res = await fetch(param);
    console.log(res);
  } catch (e) {
    console.error(e);
  }
};

ex03("param-data");
ex03("param-error");
console.log("wait....");
