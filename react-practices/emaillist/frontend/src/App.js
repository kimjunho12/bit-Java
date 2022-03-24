import React, { useEffect, useState } from "react";
import Emaillist from "./Emaillist";
import RegisterForm from "./RegisterForm";
import SearchBar from "./SearchBar";

import "./assets/scss/App.scss";

import data from "./assets/json/data.json";

const App = () => {
  const [emails, setEmails] = useState(data);

  useEffect(async () => {
    const response = await fetch("/api", {
      method: "get",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: null,
    });
    if (!response.ok) {
      console.log("error:", response.status, response.statusText);
      return;
    }

    const json = await response.json();

    if (json.result !== "success") {
      console.log("error:", json.message);
      return;
    }

    setEmails(json.data);
  }, []);

  const notifyKeywordChange = (keyword) => {
    setEmails(
      data.filter(
        (email) =>
          email.firstName.indexOf(keyword) !== -1 ||
          email.lastName.indexOf(keyword) !== -1 ||
          email.email.indexOf(keyword) !== -1
      )
    );
  };

  return (
    <div className={"App"}>
      <RegisterForm />
      <SearchBar callback={notifyKeywordChange} />
      <Emaillist emails={emails} />
    </div>
  );
};

export default App;
