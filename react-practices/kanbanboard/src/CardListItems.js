import React, { useState } from "react";
import TaskList from "./TaskList";

import styles from "./assets/css/Card.css";

const CardListItems = ({ card }) => {
  const [isOpend, setIsOpened] = useState(true);

  const openClose = (e) => {
    setIsOpened(!isOpend);
  };

  const openDiv = (
    <div className={styles.Card__Details}>
      {card.description}

      <div className="TaskList">
        <ul>
          {card.tasks.map((task) => (
            <TaskList key={task.no} tasks={task} />
          ))}
        </ul>
      </div>
    </div>
  );

  return (
    <div className={styles.Card}>
      <div
        className={isOpend ? styles.Card__Title : styles.Card__Title__open}
        onClick={openClose}
      >
        {card.title}
      </div>
      {isOpend ? openDiv : null}
    </div>
  );
};

export default CardListItems;
