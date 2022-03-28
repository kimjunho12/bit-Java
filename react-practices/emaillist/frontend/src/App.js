import React, { useEffect, useState } from "react";
import Emaillist from "./Emaillist";
import RegisterForm from "./RegisterForm";
import SearchBar from "./SearchBar";

import "./assets/scss/App.scss";

const App = () => {
  const [emails, setEmails] = useState([]);

  useEffect(async () => {
    try {
      const response = await fetch("/api", {
        method: "get",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: null,
      });
      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }

      const json = await response.json();

      if (json.result !== "success") {
        throw new Error(`${json.result} ${json.message}`);
      }

      setEmails(json.data);
    } catch (err) {
      console.error(err.message);
    }
  }, []);

  const notifyKeywordChange = async (keyword) => {
    console.log("api?kw=" + keyword);
    try {
      const response = await fetch(`/api?kw=${keyword}`, {
        method: "get",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: null,
      });
      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }

      const json = await response.json();

      if (json.result !== "success") {
        throw new Error(`${json.result} ${json.message}`);
      }

      setEmails(json.data);
    } catch (err) {
      console.error(err.message);
    }
  };

  const notifyEmailAdd = async (email) => {
    try {
      const response = await fetch(`/api`, {
        method: "put",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: JSON.stringify(email),
      });
      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }

      const json = await response.json();

      if (json.result !== "success") {
        throw new Error(`${json.result} ${json.message}`);
      }
      console.log(response);
      console.log(json.data);
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div className={"App"}>
      <RegisterForm callback={notifyEmailAdd} />
      <SearchBar callback={notifyKeywordChange} />
      <Emaillist emails={emails} />
    </div>
  );
};

export default App;
