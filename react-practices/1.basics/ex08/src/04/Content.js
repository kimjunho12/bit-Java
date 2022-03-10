import React from "react";

const content = () => {
  // return <p>Pure React(React API)로 컴포넌트 작성</p>;

  return React.createElement(
    "p",
    null,
    "JSX Tutorials - Pure React(React API)로 컴포넌트 작성"
  );
};

export default content;
