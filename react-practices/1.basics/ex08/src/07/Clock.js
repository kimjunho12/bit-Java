import React from "react";

const Clock = () => {
  const date = new Date();
  const hours = date.getHours();
  const minutes = date.getMinutes();
  const seconds = date.getSeconds();

  const html =
    "<span>" +
    ("0" + (hours > 12 ? hours - 12 : hours)).slice(-2) +
    " : " +
    ("0" + minutes).slice(-2) +
    " : " +
    ("0" + seconds).slice(-2) +
    " " +
    (hours > 12 ? "PM" : "AM") +
    "</span>";

  return (
    //
    //
    // HTML 태그를 동적으로 생성하여 JSX element 의 특정 속성(dangerouslySetInnerHTML)
    // 으로 렌더링하는 작업은 금지하고 있지만,
    // XSS(Cross-Site Scripting) 보호기능을 끄고 사용할 수 있다.
    //
    <div dangerouslySetInnerHTML={{ __html: html }} />
  );
};

export default Clock;
