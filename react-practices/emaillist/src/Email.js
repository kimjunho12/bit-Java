import React from "react";
import { PropTypes } from "prop-types";

import styles from "./assets/scss/Email.scss";

export default function Email({ emailitem }) {
  return (
    <li className={styles.Email}>
      <h4>{emailitem.firstName + emailitem.lastName}</h4>
      <br />
      <span>{emailitem.email}</span>
    </li>
  );
}

Email.propTypes = {
  emailitem: PropTypes.shape({
    firstName: PropTypes.string.isRequired,
    lastName: PropTypes.string.isRequired,
    email: PropTypes.string.isRequired,
  }),
};
