import React from "react";
import styles from "./assets/css/App.css";
import Banner01 from "./Bnnaer01";
import Banner02 from "./Bnnaer02";

const App = () => {
  return (
    <div>
      <h1
        className={styles.Header}
      >{`CSS Module (css loader options : {module: true})`}</h1>
      <Banner01 />
      <Banner02 />
    </div>
  );
};

export default App;
