import React, { useEffect, useState } from "react";
import { PropTypes } from "prop-types";

import styles from "./assets/css/TaskList.css";

const TaskList = ({ task }) => {
  const [checked, setChecked] = useState(task.done === "Y");
  const onChangeCheckBox = (e) => {
    setChecked(e.target.checked);
  };

  useEffect(async () => {
    try {
      const response = await fetch(
        `/api/task/${task.no}?done=${checked ? "Y" : "N"}`,
        {
          method: "post",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
          },
          body: null,
        }
      );

      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }

      const json = await response.json();

      if (json.result !== "success") {
        throw new Error(`${json.result} ${json.message}`);
      }
    } catch (err) {
      console.error(err.message);
    }
  }, [checked]);

  return (
    <li className={styles.TaskList__Task}>
      <input type="checkbox" checked={checked} onChange={onChangeCheckBox} />
      {" " + task.name + " "}
      {/* <a href="#" className={styles["TaskList__Task--remove"]}></a> */}
      <a href="#" className={styles["TaskList__Task__remove"]}></a>
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
