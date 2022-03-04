const App = function() {
    const App = document.createElement('h1');
    App.textContent = 'Hello World';

    return App;
}

document.getElementById('root').appendChild(App());