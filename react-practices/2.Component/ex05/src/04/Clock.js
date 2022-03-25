import React, { useEffect } from "react";
import SevenSegmentLED from "./SevenSegmentLED";
import SessionAmPm from "./SessionAmPm";
import "./assets/scss/Clock.scss";

export default function Clock({ message, hours, minutes, seconds, session }) {
  return (
    <div className={"clock-display"}>
      <h2>{message}</h2>
      <div className={"Clock"}>
        <SevenSegmentLED number={hours} colon={true} />
        <SevenSegmentLED number={minutes} colon={true} />
        <SevenSegmentLED number={seconds} colon={false} />
        <SessionAmPm session={session} />
      </div>
    </div>
  );
}
