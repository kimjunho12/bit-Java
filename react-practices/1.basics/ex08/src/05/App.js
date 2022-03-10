import React, { Component, Fragment } from "react";

import Header from "./Header";
import Content from "./Content";

class App extends Component {
  render() {
    return (
      <Fragment>
        <Header />
        <Content />
      </Fragment>
    );
  }
}

export default App;
