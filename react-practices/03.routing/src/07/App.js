import React from "react";
import { BrowserRouter as Router } from "react-router-dom";
import { Routes, Route } from "react-router";

import Main from "./component/Main";
import Gallery from "./component/Gallery";
import Guestbook from "./component/Guestbook";
import About from "./component/about/About";
import Me from "./component/about/Me";
import Login from "./component/user/Login";
import Settings from "./component/user/Settings";
import Join from "./component/user/Join";

import Error404 from "./component/error/Error404";

import "./assets/scss/App.scss";

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="gallery" element={<Gallery />} />
        <Route path="guestbook" element={<Guestbook />} />
        <Route element={<About />}>
          <Route path="about/me" element={<Me />} />
        </Route>
        <Route path="user/login" element={<Login />} />
        <Route path="user/settings" element={<Settings />} />
        <Route path="user/join" element={<Join />} />
        <Route path="*" element={<Error404 />} />
      </Routes>
    </Router>
  );
}
