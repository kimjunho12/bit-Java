import React from "react";

const App = function() {
    // const App = document.createElement('h1');
    // App.textContent = 'Hello World ex05';

    const App = React.createElement('h1', null, "Hello World ex06 - React");

    return App;
}

export { App }