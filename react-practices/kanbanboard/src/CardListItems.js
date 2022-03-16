import React from "react";
import TaskList from "./TaskList";

import styles from "./assets/css/Card.css";

const CardListItems = ({ card }) => {
  return (
    <div className={styles.Card}>
      <div className={styles.Card__Title}>{card.title}</div>
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
    </div>
  );
};

export default CardListItems;
