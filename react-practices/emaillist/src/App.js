import React from "react";
import Emaillist from "./Emaillist";
import RegisterForm from "./RegisterForm";
import SearchBar from "./SearchBar";

import "./assets/scss/App.scss";

import data from "./assets/json/data.json";

const App = () => {
  return (
    <div className={"App"}>
      <RegisterForm />
      <SearchBar />
      <Emaillist emails={data} />
    </div>
  );
};

export default App;
