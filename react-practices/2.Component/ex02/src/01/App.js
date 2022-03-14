import React from "react";

const App = () => {
  const h1Style = {
    width: 280,
    height: 50,
    padding: 5,
    color: "#111",
    backgroundColor: "#eeff99",
  };
  return (
    <div id="App">
      <h1 style={h1Style /* 객체로 전달 해야함 */}>Inline Styling</h1>
    </div>
  );
};

export default App;
