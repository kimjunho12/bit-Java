import React from "react";
import CardListItems from "./CardListItems";
import { PropTypes } from "prop-types";

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

CardList.propTypes = {
  cards: PropTypes.arrayOf(PropTypes.shape(CardListItems.propTypes)).isRequired,
  status: PropTypes.string.isRequired,
};

export default CardList;
