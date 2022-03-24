import React from "react";
import { PropTypes } from "prop-types";

import styles from "./assets/scss/SearchBar.scss";

export default function SearchBar({ callback }) {
  return (
    <div className={styles.SearchBar}>
      <input
        type="text"
        placeholder="찾기"
        onChange={(e) => callback(e.target.value)}
      />
    </div>
  );
}

SearchBar.propTypes = { callback: PropTypes.func.isRequired };
