import React, { Fragment } from "react";
import Incrementor01 from "./Incrementor01";
import Incrementor02 from "./Incrementor02";

const App = () => {
  return (
    <Fragment>
      <h2>01. 기본 개념</h2>
      <Incrementor01 begin={1} step={1} />
      <Incrementor02 begin={1} step={1} />
    </Fragment>
  );
};

export default App;
