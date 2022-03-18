import React from "react";
import styles from "./assets/scss/Email.scss";

const Email = ({ email }) => {
  return (
    <li className={styles.Email}>
      <h4>{email.firstName + email.lastName}</h4>
      <br />
      <span>{email.email}</span>
    </li>
  );
};

export default Email;
