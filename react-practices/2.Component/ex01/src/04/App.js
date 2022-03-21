import React from "react";
import MyComponent from "./MyComponent";

const App = () => {
  return (
    <div id="App">
      <MyComponent
        props01={"Hello World!"}
        props02={2}
        props03={true}
        props04={{ no: 1 }}
        props05={[1, 2, 4, 5]}
        props06={() => "함수"}
        props07={1234}
        props08={[false, true, false]}
        props09={{ no: "tt", name: "test", email: "test@email.com" }}
      />
    </div>
  );
};

export default App;
