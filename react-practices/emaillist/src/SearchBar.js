import React from "react";
import styles from "./assets/scss/SearchBar.scss";

const SearchBar = () => {
  return (
    <div className={styles.SearchBar}>
      찾기 : <input type="text" placeholder="찾기" />
    </div>
  );
};

export default SearchBar;
