import React from "react";
import CardListItems from "./CardListItems";

const CardList = ({ cards, status }) => {
  return (
    <div className="CardList">
      <h1>{status}</h1>
      {cards.map((card) => (
        <CardListItems key={card.no} card={card} />
      ))}
    </div>
  );
};

export default CardList;
