import React from "react";
import TaskList from "./TaskList";

const CardListItems = ({ card }) => {
  return (
    <div className="Card">
      <div className="Card__Title">{card.title}</div>
      <div className="Card__Details">
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
