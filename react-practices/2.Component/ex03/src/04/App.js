import React, { Fragment, useRef } from "react";
import logo from "../assets/images/react-logo.png";

export default function App() {
  const imgRef = useRef(null);

  const onKeyPressInput = (e) => {
    if (e.key === "Enter") {
      console.log(e.target.value);
    }
  };
  const onFocusInput = (e) => console.log("Focused");
  const onBlurInput = (e) => console.log("Blurred");

  const onMouseOverImage = (e) =>
    console.log("MouseOver", `x=${e.clientX} y=${e.clientY}`);
  const onMouseOutImage = (e) =>
    console.log("MouseOut", `x=${e.clientX} y=${e.clientY}`);
  const onMouseMoveImage = (e) => {
    const offsetTop = imgRef.current.offsetTop;
    const offsetLeft = imgRef.current.offsetLeft;
    console.log(
      "MouseMove",
      `x=${e.clientX - offsetLeft} y=${e.clientY - offsetTop}`
    );
  };
  const onMouseDownImage = (e) =>
    console.log("MouseDown", `x=${e.clientX} y=${e.clientY}`);
  const onMouseUpImage = (e) =>
    console.log("MouseUp", `x=${e.clientX} y=${e.clientY}`);

  const onClickImage = (e) =>
    console.log("Click", `x=${e.clientX} y=${e.clientY}`);
  const onDoubleClickImage = (e) =>
    console.log("DoubleClick", `x=${e.clientX} y=${e.clientY}`);

  return (
    <Fragment>
      <h2>ex03 - Some Examples of Event Handler</h2>
      <input
        type="text"
        placeholder="메세지를 입력 하세요"
        onKeyPress={onKeyPressInput}
        onFocus={onFocusInput}
        onBlur={onBlurInput}
      />
      <br />
      <br />
      <img
        ref={imgRef}
        style={{
          cursor: "pointer",
          width: 190,
          border: "1px solid #ccc",
        }}
        src={logo}
        onMouseOver={onMouseOverImage}
        onMouseOut={onMouseOutImage}
        onMouseMove={onMouseMoveImage}
        onMouseDown={onMouseDownImage}
        onMouseUp={onMouseUpImage}
        onClick={onClickImage}
        onDoubleClick={onDoubleClickImage}
      />
    </Fragment>
  );
}
