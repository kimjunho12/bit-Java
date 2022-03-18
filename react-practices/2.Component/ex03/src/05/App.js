import React, { useRef } from "react";
import "./assets/scss/App.scss";

export default function App() {
  const outterRef = useRef(null);
  const innerRef = useRef(null);

  return (
    <div
      className={"App"}
      ref={outterRef}
      onScroll={(e) =>
        console.log(
          outterRef.current.clientHeight,
          outterRef.current.scrollTop,
          innerRef.current.clientHeight
        )
      }
    >
      <div ref={innerRef}>
        <ul>
          {Array.from({ length: 100 }, (_, i) => i + 1).map((i) => (
            <li key={i}>{`아이템 ${i} 입니다.`}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}
