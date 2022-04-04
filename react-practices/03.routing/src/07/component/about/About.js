import React from "react";
import { Outlet } from "react-router";

import SiteLayout from "../../layout/SiteLayout";
import Navigation from "./Navigation";

import styles from "../../assets/scss/component/About.scss";

export default function About() {
  return (
    <SiteLayout>
      <div className={styles.About}>
        <Navigation />
        <Outlet />
      </div>
    </SiteLayout>
  );
}
