import fs from "fs";

//  this.state -> 콘솔용으로 만들거임
let state = {
  order: JSON.parse(fs.readFileSync("./json/data.json").toString()), //  readfile : 비동기 | readFileSync : 동기
};
let updateOrder1 = state.order;
updateOrder1.receive = "부산시 해운대구 우동...";

console.log(state.order, updateOrder1, state.order === updateOrder1); //  옛날거 까지 다 바꿈

console.log("\n======================================");
state = {
  order: JSON.parse(fs.readFileSync("./json/data.json").toString()), //  readfile : 비동기 | readFileSync : 동기
};
let updateOrder2 = Object.assign({}, state.order, {
  receive: "부산시 해운대구 우동...",
});

console.log(state.order, updateOrder2, state.order === updateOrder2); //  기존건 그대로, 한개 더 생김
