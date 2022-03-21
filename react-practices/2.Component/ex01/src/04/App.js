import React from "react";
import MyComponent from "./MyComponent";

const App = () => {
  return (
    <div id="App">
      <MyComponent props01={"Hello World!"} props02={2} props03={true} />
    </div>
  );
};

export default App;
