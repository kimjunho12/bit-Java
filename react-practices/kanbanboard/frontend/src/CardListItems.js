import React, { useEffect, useState } from "react";
import TaskList from "./TaskList";
import { PropTypes } from "prop-types";

import styles from "./assets/css/Card.css";

const CardListItems = ({ card }) => {
  const [isOpend, setIsOpened] = useState(false);
  const [tasks, setTasks] = useState([]);

  /** Card Open 시 Task 로딩 */
  useEffect(
    () =>
      isOpend
        ? null
        : myFetch(`/api/task?cardNo=${card.no}`, "get", null, setTasks),
    [isOpend]
  );

  const openClose = (e) => {
    setIsOpened(!isOpend);
  };

  /** Task 추가 */
  const notifyAddTask = (event) => {
    if (event.key === "Enter") {
      const newTask = {
        name: event.target.value,
        done: "N",
        cardNo: card.no,
      };
      event.target.value = null;
      myFetch("/api/task/add", "post", JSON.stringify(newTask));
    }
  };

  const openDiv = (
    <div className={styles.Card__Details}>
      {card.description}

      <div className="TaskList">
        <ul>
          {tasks?.map((task) => (
            <TaskList key={task.no} task={task} />
          ))}
          <input
            type="text"
            className={styles.TaskList__add_task}
            placeholder={"Task 추가"}
            onKeyPress={notifyAddTask}
          />
        </ul>
      </div>
    </div>
  );

  /** 통신용 함수 */
  const myFetch = async (url, method, body = null, setState = () => {}) => {
    try {
      const response = await fetch(`${url}`, {
        method: `${method}`,
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: body,
      });

      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }

      const json = await response.json();

      if (json.result !== "success") {
        throw new Error(`${json.result} ${json.message}`);
      }

      setState(json.data);
    } catch (err) {
      console.error(err.message);
    }
  };

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
