import React, { useState } from "react";

import styles from "./assets/css/TaskList.css";

const TaskList = ({ tasks }) => {
  const [checked, setChecked] = useState(tasks.done);
  const onChangeCheckBox = (e) => {
    setChecked(e.target.checked);
  };

  return (
    <li className={styles.TaskList__Task}>
      <input type="checkbox" checked={checked} onChange={onChangeCheckBox} />
      {" " + tasks.name + " "}
      {/* <a href="#" className={styles["TaskList__Task--remove"]}></a> */}
      <a href="#" className={styles["TaskList__Task__remove"]}></a>
    </li>
  );
};

export default TaskList;
