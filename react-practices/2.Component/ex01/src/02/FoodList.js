import React, { Component } from "react";
import FoodListItems from "./FoodListItems";

export default class FoodList extends Component {
  render() {
    // const components = [];
    // this.props.foods.forEach((food) => {
    //   components.push(
    //     <FoodListItems name={food.name} quantity={food.quantity} />
    //   );
    // });

    // const components = this.props.foods.map((food) => {
    //   return (
    //     <FoodListItems key={food.no} name={food.name} quantity={food.quantity} />
    //   );
    // });
    return (
      <ul>
        {this.props.foods.map((food) => (
          <FoodListItems
            key={food.no}
            name={food.name}
            quantity={food.quantity}
          />
        ))}
      </ul>
    );
  }
}
