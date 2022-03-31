import React from "react";
import styles from "../assets/scss/component/Main.scss";
import SiteLayout from "../layout/SiteLayout";

export default function Main() {
  return (
    <SiteLayout>
      <div className={styles.Main}>
        <h2>Main</h2>
      </div>
    </SiteLayout>
  );
}
