import React, { useEffect, useState } from "react";
import TaskList from "./TaskList";
import { PropTypes } from "prop-types";

import styles from "./assets/css/Card.css";

const CardListItems = ({ card }) => {
  const [isOpend, setIsOpened] = useState(false);
  const [tasks, setTasks] = useState([]);

  useEffect(async () => {
    try {
      const response = await fetch("/api/task?cardNo=" + card.no, {
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

      setTasks(json.data);
    } catch (err) {
      console.error(err.message);
    }
  }, [isOpend]);

  const openClose = (e) => {
    setIsOpened(!isOpend);
  };

  const openDiv = (
    <div className={styles.Card__Details}>
      {card.description}

      <div className="TaskList">
        <ul>
          {tasks?.map((task) => (
            <TaskList key={task.no} task={task} />
          ))}
        </ul>
      </div>
    </div>
  );

  return (
    <div className={styles.Card}>
      <div
        className={isOpend ? styles.Card__Title__open : styles.Card__Title}
        onClick={openClose}
      >
        {card.title}
      </div>
      {isOpend ? openDiv : null}
    </div>
  );
};

CardListItems.propTypes = {
  card: PropTypes.shape({
    no: PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    tasks: PropTypes.arrayOf(PropTypes.shape(TaskList.propTypes)),
  }),
};

export default CardListItems;
