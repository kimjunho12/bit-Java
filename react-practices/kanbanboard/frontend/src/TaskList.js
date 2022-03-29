import React, { useState } from "react";
import { PropTypes } from "prop-types";

import styles from "./assets/css/TaskList.css";

const TaskList = ({ tasks }) => {
  const [checked, setChecked] = useState(tasks.done === "Y");
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

TaskList.propTypes = {
  tasks: PropTypes.shape({
    no: PropTypes.number.isRequired,
    name: PropTypes.string.isRequired,
    done: PropTypes.string.isRequired,
  }),
};

export default TaskList;
