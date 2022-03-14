import React from "react";

const TaskList = ({ tasks }) => {
  return (
    <li className="TaskList__Task">
      <input type="checkbox" defaultChecked={tasks.done} />
      {" " + tasks.name + " "}
      <a href="#" className="TaskList__Task--remove"></a>
    </li>
  );
};

export default TaskList;
