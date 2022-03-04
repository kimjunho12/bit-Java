import './assets/css/App.css';

const App = function() {
    const App = document.createElement('h1');
    App.className = 'Header';
    App.textContent = 'Hello World ex04';

    return App;
}

export { App }