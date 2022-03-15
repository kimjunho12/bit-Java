import React, { Component } from "react";

class TitleBar01 extends Component {
  constructor() {
    super(...arguments);
    // this.no VS. this.state.no
    // this.no = 0;
    this.state = {
      no: 0,
    };
  }

  onClickHandler = () => {
    this.setState({
      no: this.state.no + 1,
    });
    console.log(this);
    console.log("TitleBar01 Clicked!", this.state.no);
  };

  render() {
    return (
      <h1 style={{ cursor: "pointer" }} onClick={this.onClickHandler}>
        ex03: Functional Event Handler (Class Component)
        {this.state.no}
      </h1>
    );
  }
}

export default TitleBar01;
