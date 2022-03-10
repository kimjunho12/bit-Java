import React, { Fragment } from "react";

import Header from "./Header";
import Content from "./Content";

const App = function () {
  return (
    <Fragment>
      {/*<div id="App">*/}
      <Header />
      <Content />
      {/*</div>*/}
    </Fragment>
  );
};

export default App;
