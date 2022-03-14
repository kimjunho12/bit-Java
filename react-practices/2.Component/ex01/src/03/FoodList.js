import React from "react";
import FoodListItems from "./FoodListItems";

const FoodList = ({ foods }) => {
  return (
    <ul>
      {foods.map((food) => (
        <FoodListItems
          key={food.no}
          name={food.name}
          quantity={food.quantity}
        />
      ))}
    </ul>
  );
};

export default FoodList;
