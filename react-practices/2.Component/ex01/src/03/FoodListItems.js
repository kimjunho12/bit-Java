import React from "react";

const FoodListItems = ({ name, quantity }) => {
  return (
    <li>
      {name} : {quantity}
    </li>
  );
};

export default FoodListItems;
