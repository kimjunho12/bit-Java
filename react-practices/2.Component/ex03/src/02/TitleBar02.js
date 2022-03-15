import React from "react";

const TitleBar02 = () => {
  const onClickHandler = (e) => {
    console.log("TitleBar02 Clicked: " + e);
  };

  return (
    <h1 style={{ cursor: "pointer" }} onClick={onClickHandler}>
      ex03: Functional Event Handler (Functional Component)
    </h1>
  );
};

export default TitleBar02;
