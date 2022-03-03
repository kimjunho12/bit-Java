const http = require("http");
const fs = require("fs");

const port = 9090;
const server = http.createServer(function(req, resp) {
    console.log(req.url);

    if (req.url === '/') { // welcome file setting
        req.url = '/index.html';
    }

    // data = fs.readFileSync(staticFilePath); // 동기

    fs.readFile(__dirname + '/public' + req.url, function(error, data) { // 비동기
        resp.writeHead(200, {
            'Content-Type': 'text/html; charset="utf-8"'
        });

        resp.end(data);
    });
});

server.listen(port, function() {
    console.log("===== HTTP Server is Running on " + port + " =====");
});