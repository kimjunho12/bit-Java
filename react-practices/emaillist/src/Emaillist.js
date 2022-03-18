import React from "react";
import Email from "./Email";

import styles from "./assets/scss/Emaillist.scss";

const Emaillist = ({ emails }) => {
  return (
    <ul className={styles.Emaillist}>
      {emails.map((email) => (
        <Email key={email.no} email={email} />
      ))}
    </ul>
  );
};

export default Emaillist;
