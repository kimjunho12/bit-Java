import React, { Component } from "react";

export default class FoodListItems extends Component {
  render() {
    return (
      <li>
        {this.props.name} : {this.props.quantity}
      </li>
    );
  }
}
