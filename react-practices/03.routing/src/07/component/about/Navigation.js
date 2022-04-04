import React from "react";
import { NavLink } from "react-router-dom";

import styles2 from "../../assets/scss/component/about/Navigation.scss";

const Navigation = () => {
  return (
    <nav className={styles2.Navigation}>
      <NavLink to={"/about/me"}>Me</NavLink>
      <span />
      <NavLink to={"/about/location"}>location</NavLink>
    </nav>
  );
};

export default Navigation;
