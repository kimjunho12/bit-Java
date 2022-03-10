import React from "react";

const Clock01 = () => {
  var date = new Date();
  var nDate = date
    .toLocaleTimeString()
    .replace("오전", "AM")
    .replace("오후", "PM");
  return <div>{nDate}</div>;
};

export default Clock01;
