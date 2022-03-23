import React, { Component } from "react";
import "./assets/scss/App.scss";
import Clock from "./Clock";

export default class App extends Component {
  constructor() {
    super(...arguments);

    this.state = this.getCurrentClockTime();
  }

  getCurrentClockTime() {
    const date = new Date();

    const [sessions, hours, minutes, seconds] = date
      .toLocaleTimeString()
      .replace("오전", "am")
      .replace("오후", "pm")
      .split(/[ :]/);

    return {
      hours: hours,
      minutes: minutes,
      seconds: seconds,
      sessions: sessions,
      ticks: this.state ? this.state.ticks + 1 : 0,
    };
  }

  render() {
    return (
      <div className="clock-display">
        <h2>ex05 - Component LifeCycle Practice</h2>
        {this.state.ticks % 10 === 0 ? null : (
          <Clock
            hours={this.state.hours}
            minutes={this.state.minutes}
            seconds={this.state.seconds}
            session={this.state.sessions}
          />
        )}
      </div>
    );
  }

  componentDidMount() {
    this.inverval = setInterval(() => {
      this.setState(this.getCurrentClockTime());
    }, 1000);
  }

  componentWillUnmount() {
    console.log("App", "Clock", "componentWillUnmount");
    clearInterval(this.inverval);
  }
}
