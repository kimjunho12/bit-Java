import React from "react";
import { PropTypes } from "prop-types";

import styles from "./assets/css/TaskList.css";

const TaskList = ({ task, callback, deleteCallback }) => {
  return (
    <li className={styles.TaskList__Task}>
      <input
        type="checkbox"
        checked={task.done === "Y"}
        onChange={(e) => callback(task, e.target.checked)}
      />
      {" " + task.name + " "}
      {/* <a href="#" className={styles["TaskList__Task--remove"]}></a> */}
      <a
        href="#"
        onClick={() => deleteCallback(task)}
        className={styles["TaskList__Task__remove"]}
      ></a>
    </li>
  );
};

TaskList.propTypes = {
  task: PropTypes.shape({
    no: PropTypes.number.isRequired,
    name: PropTypes.string.isRequired,
    done: PropTypes.string.isRequired,
  }),
};

export default TaskList;
