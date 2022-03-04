import "./assets/scss/App.scss";
import logo from './assets/images/logo.svg';

const App = function() {
    const app = document.createElement('div');
    app.className = 'App';
    app.innerHTML =
        `
    <header class="App-header">
        <img src="${logo }" class="App-logo" alt="logo" />
        <p>Hello World ex06</p>
    </header>
    `;

    return app;
}

export { App }