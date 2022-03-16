import React from "react";
import CardListItems from "./CardListItems";

import styles from "./assets/css/CardList.css";

const CardList = ({ cards, status }) => {
  return (
    <div className={styles.CardList}>
      <h1>{status}</h1>
      {cards.map((card) => (
        <CardListItems key={card.no} card={card} />
      ))}
    </div>
  );
};

export default CardList;
