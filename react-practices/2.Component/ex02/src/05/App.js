import React from "react";
import styles from "./assets/scss/App.scss";

const App = () => {
  return (
    <div className={styles.App}>
      <h1
        className={styles.Header}
      >{`SASS & SCSS (css loader options : {module: true})`}</h1>
    </div>
  );
};

export default App;
