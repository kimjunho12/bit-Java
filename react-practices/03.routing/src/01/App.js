import React, { useState, useEffect } from "react";
import Main from "./component/Main";
import Gallery from "./component/Gallery";
import Guestbook from "./component/Guestbook";

export default function App() {
  const [route, setRoute] = useState("");
  const handleHashChange = () => {
    const route = window.location.hash.substring(1);
    console.log(route);
    setRoute(route);
  };
  useEffect(() => {
    window.addEventListener("hashchange", handleHashChange);

    return () => {
      window.removeEventListener("hashchange", handleHashChange);
    };
  }, []);

  return (() => {
    // return에 if문을 쓸 수 없어서 함수를 만들어서 그안에서 분기 후 리턴
    switch (route) {
      case "/":
        return <Main />;
        break;
      case "/main":
        return <Main />;
        break;
      case "/guestbook":
        return <Guestbook />;
        break;
      case "/gallery":
        return <Gallery />;
      default:
        return null;
        break;
    }
  })();
}
