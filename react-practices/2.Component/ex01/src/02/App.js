import React, { Component } from "react";
import FoodList from "./FoodList";

export default class App extends Component {
  constructor() {
    super();

    this.food = [
      // 통신의 결과라 가정
      { no: 1, name: "Bread", quantity: 40 },
      { no: 2, name: "Egg", quantity: 80 },
      { no: 3, name: "Milk", quantity: 50 },
    ];
  }

  render() {
    return (
      <div id="App">
        <FoodList foods={this.food} />
      </div>
    );
  }
}
