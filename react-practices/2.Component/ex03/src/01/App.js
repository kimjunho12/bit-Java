import React from "react";

const App = () => {
  return (
    <div>
      <h1 onClick={(e) => console.log("click!")} style={{ cursor: "pointer" }}>
        ex03 : Inline Handler
      </h1>
    </div>
  );
};

export default App;
