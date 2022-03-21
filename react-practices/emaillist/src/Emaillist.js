import React from "react";
import Email from "./Email";
import { PropTypes } from "prop-types";

import styles from "./assets/scss/Emaillist.scss";

export default function Emaillist({ emails }) {
  return (
    <ul className={styles.Emaillist}>
      {emails.map((email) => (
        <Email key={email.no} emailitem={email} />
      ))}
    </ul>
  );
}

Emaillist.propTypes = {
  emails: PropTypes.arrayOf(PropTypes.shape(Email.propTypes)).isRequired,
};
