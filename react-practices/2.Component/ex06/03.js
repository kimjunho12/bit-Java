import fs from "fs";

//  this.state -> 콘솔용으로 만들거임
let state = {
  order: JSON.parse(fs.readFileSync("./json/data.json").toString()), //  readfile : 비동기 | readFileSync : 동기
};

let updateOrder = Object.assign({}, state.order, {
  receive: "부산시 해운대구 우동....",
});

updateOrder.payment.method = "Mobile";

console.log(
  state.order,
  updateOrder,
  state.order === updateOrder,
  state.order.receive === updateOrder.receive,
  state.order.payment === updateOrder.payment
);
