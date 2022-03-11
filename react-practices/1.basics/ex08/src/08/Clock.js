import React from "react";

const Clock = () => {
  const date = new Date();
  const hours = date.getHours();
  const minutes = date.getMinutes();
  const seconds = date.getSeconds();

  return (
    /*
      comment01 : 컴포넌트 안이기 때문에 자바스크립트 구분이 가능하다.
    */
    <div
      /*
        comment02: 여기서도 다중행 주석이 가능하다, 비추!
      */
      className="clock"
      title="시계"
    >
      {("0" + (hours > 12 ? hours - 12 : hours)).slice(-2)}
      {" : "}
      {("0" + minutes).slice(-2)}
      {/* comment03: 이런방식으로 표현식이 실행되는 블록안에 주석을 달아야 한다. */}
      {" : "}
      {/* JSX는 HTML이 아니다!!! <!-- --> 주석은 사용할 수 없다 */}
      {("0" + seconds).slice(-2)} {hours > 12 ? "PM" : "AM"}
      // 방법은 그냥 출력됨
    </div>
  );
};

export default Clock;
