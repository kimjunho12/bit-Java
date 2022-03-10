import React from "react";

const Clock02 = () => {
  const date = new Date();
  const hours = date.getHours();
  const minutes = date.getMinutes();
  const seconds = date.getSeconds();

  return (
    <div>
      {("0" + (hours > 12 ? hours - 12 : hours)).slice(-2)}
      {" : "}
      {("0" + minutes).slice(-2)}
      {" : "}
      {("0" + seconds).slice(-2)} {hours > 12 ? "PM" : "AM"}
    </div>
  );
};

export default Clock02;
