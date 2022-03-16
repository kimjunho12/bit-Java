import React from "react";

import styles from "./assets/css/TaskList.css";

const TaskList = ({ tasks }) => {
  return (
    <li className={styles.TaskList__Task}>
      <input type="checkbox" defaultChecked={tasks.done} />
      {" " + tasks.name + " "}
      <a href="#" className={styles["TaskList__Task--remove"]}></a>
    </li>
  );
};

export default TaskList;
