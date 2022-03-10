import React, { Fragment } from "react";
import Clock from "./Clock";

const content = () => {
  return (
    <Fragment>
      <p>{`Dynamic HTML Rendering`}</p>
      <Clock />
    </Fragment>
  );
};

export default content;
