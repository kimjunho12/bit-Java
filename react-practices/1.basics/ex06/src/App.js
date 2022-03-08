import React from "react";

const App = function() {
    // const App = React.createElement('h1', null, "Hello World ex06 - React");
    // return App;

    const message = "Hello World ex06 - babel";
    return (
        <div>
        <h1> {message } </h1>
        </div>
    );

}

export { App }