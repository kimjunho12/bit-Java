import React, { Component } from "react";
import FoodListItems from "./FoodListItems";

export default class FoodList extends Component {
  render() {
    return (
      <ul>
        <FoodListItems name="Egg" quantity="20" />
        <FoodListItems name="Bread" quantity="10" />
        <FoodListItems name="Milk" quantity="5" />
      </ul>
    );
  }
}
