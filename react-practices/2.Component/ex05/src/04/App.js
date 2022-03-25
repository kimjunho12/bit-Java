import React, { useState, useEffect, Fragment } from "react";
import "./assets/scss/App.scss";
import Clock from "./Clock";

export default function App() {
  const [time, setTime] = useState(getCurrentClockTime);
  const [ticks, setTicks] = useState(0);

  useEffect(() => {
    console.log("Clock Mounted");
    return function () {
      console.log("Clock Unmounted");
    };
  }, []);

  useEffect(() => {
    setTimeout(() => {
      setTime(getCurrentClockTime());
      setTicks(ticks + 1);
    }, 1000);
  }, [time]);

  const getCurrentClockTime = () => {
    const [sessions, hours, minutes, seconds] = new Date()
      .toLocaleTimeString()
      .replace("오전", "am")
      .replace("오후", "pm")
      .split(/[ :]/);

    return {
      hours: hours,
      minutes: minutes,
      seconds: seconds,
      sessions: sessions,
    };
  };

  return (
    <Fragment>
      {console.log(ticks)}
      {ticks % 10 === 0 ? null : (
        <Clock
          message={"ex05: useEffect Hook example"}
          hours={time.hours}
          minutes={time.minutes}
          seconds={time.seconds}
          session={time.sessions}
        />
      )}
    </Fragment>
  );
}
