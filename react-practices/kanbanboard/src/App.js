import React from "react";
import CardList from "./CardList";

import "../public/styles.css";

const App = () => {
  const data = require("../public/data.json");

  return (
    <div className="KanbanBoard">
      <CardList cards={__getListFilter(data, "ToDo")} status="To Do" />
      <CardList cards={__getListFilter(data, "Doing")} status="In Progress" />
      <CardList cards={__getListFilter(data, "Done")} status="Done" />
    </div>
  );
};

const __getListFilter = (data, key) => {
  return data.filter((card) => {
    return card["status"] === key;
  });
};

export default App;
