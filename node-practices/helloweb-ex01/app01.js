const http = require("http");

const port = 9090;
const server = http.createServer(function(req, resp) {
    resp.writeHead(200, {
        'Content-Type': 'text/html; charset="utf-8"'
    });

    resp.end('<h1>Hello World!</h1>');
});

server.listen(port, function() {
    console.log("===== HTTP Server is Running on " + port + " =====");
});