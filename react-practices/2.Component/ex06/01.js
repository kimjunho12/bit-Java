import fs from "fs";

let state = {
  order: JSON.parse(fs.readFileSync("./json/data.json").toString()),
};

const updateProducts1 = state.order.products;

updateProducts1.push({
  no: "c002-003",
  name: "블루양말",
  price: 2000,
  amount: 1,
});

console.log(
  state.products,
  updateProducts1,
  state.order.products === updateProducts1
);
console.log("===============================");

const updateProducts2 = state.order.products.concat({
  no: "c002-003",
  name: "블루양말",
  price: 2000,
  amount: 1,
});

console.log(
  state.order.products,
  updateProducts2,
  state.order.products === updateProducts2
);
console.log("===============================");

const updateProducts3 = [
  ...state.order.products,
  {
    no: "c002-003",
    name: "블루양말",
    price: 2000,
    amount: 1,
  },
];

console.log(
  state.order.products,
  updateProducts3,
  state.order.products === updateProducts3
);
