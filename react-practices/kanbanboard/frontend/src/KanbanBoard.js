import React, { useEffect, useState } from "react";
import CardList from "./CardList";

import styles from "./assets/css/KanbanBoard.css";

const KanbanBoard = () => {
  const [cards, setCards] = useState([]);

  useEffect(async () => {
    try {
      const response = await fetch("/api/card", {
        method: "get",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: null,
      });

      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }

      const json = await response.json();

      if (json.result !== "success") {
        throw new Error(`${json.result} ${json.message}`);
      }

      setCards(json.data);
    } catch (err) {
      console.error(err.message);
    }
  }, []);

  return (
    <div className={styles.KanbanBoard}>
      <CardList cards={__getListFilter(cards, "ToDo")} status="To Do" />
      <CardList cards={__getListFilter(cards, "Doing")} status="In Progress" />
      <CardList cards={__getListFilter(cards, "Done")} status="Done" />
    </div>
  );
};

const __getListFilter = (cards, key) => {
  return cards.filter((card) => card["status"] === key);
};

export default KanbanBoard;
