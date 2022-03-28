import React from "react";
import CardList from "./CardList";

import styles from "./assets/css/KanbanBoard.css";

import data from "../public/data.json";

const KanbanBoard = () => {
  // const data = require("../public/data.json");

  return (
    <div className={styles.KanbanBoard}>
      <CardList cards={__getListFilter(data, "ToDo")} status="To Do" />
      <CardList cards={__getListFilter(data, "Doing")} status="In Progress" />
      <CardList cards={__getListFilter(data, "Done")} status="Done" />
    </div>
  );
};

const __getListFilter = (data, key) => {
  return data.filter((card) => card["status"] === key);
};

export default KanbanBoard;
