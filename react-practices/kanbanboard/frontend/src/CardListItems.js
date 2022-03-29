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
        no: tasks.length + 1,
        name: event.target.value,
        done: "N",
        cardNo: card.no,
      };
      setTasks([newTask, ...tasks]);
      event.target.value = null;
      myFetch("/api/task/add", "post", JSON.stringify(newTask));
    }
  };

  /** Task 상태(Done) 변화 */
  const notifyTaskStatusChange = (task, checked) => {
    const newTasks = tasks.map((t) => {
      if (t.no === task.no) {
        t.done = checked ? "Y" : "N";
      }
      return t;
    });
    setTasks(newTasks);
    myFetch(`/api/task/${task.no}?done=${checked ? "Y" : "N"}`, "put");
  };

  /** Task 삭제 알림(callback) */
  const notifyTaskDelete = (task) => {
    const remainTasks = tasks.filter((t) => t.no !== task.no);
    setTasks(remainTasks);
    myFetch(`/api/task/${task.no}`, "delete");
  };

  /** 열렸을 때의 View (Card detail) */
  const openDiv = (
    <div className={styles.Card__Details}>
      {card.description}

      <div className="TaskList">
        <ul>
          {tasks?.map((task) => (
            <TaskList
              key={task.no}
              task={task}
              callback={notifyTaskStatusChange}
              deleteCallback={notifyTaskDelete}
            />
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
