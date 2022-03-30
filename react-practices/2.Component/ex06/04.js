import fs from "fs";
import update from "react-addons-update";

let state = {
  order: JSON.parse(fs.readFileSync("./json/data.json").toString()), //  readfile : 비동기 | readFileSync : 동기
};

// let updateOrder = Object.assign({}, state.order, {
//   receive: "부산시 해운대구 우동....",
// });

let updateOrder = update(state.order, {
  // 해당 패스의 값 변경 1
  receive: {
    $set: "부산시 해운대구 우동",
  },
  // 해당 패스의 값 변경 2
  payment: {
    method: {
      $set: "Mobile",
    },
  },
  products: {
    // 배열 요소 변경 (인덱스로 찾아사)
    0: {
      amount: {
        $set: 5,
      },
    },
    // 배열 요소 추가
    $push: [
      {
        no: "c005-005",
        name: "고무장갑",
        price: 3000,
        amount: 1,
      },
    ],
  },
});

updateOrder.payment.method = "Mobile";

console.log(
  state.order,
  updateOrder
  // state.order === updateOrder,
  // state.order.receive === updateOrder.receive,
  // state.order.payment === updateOrder.payment
);
