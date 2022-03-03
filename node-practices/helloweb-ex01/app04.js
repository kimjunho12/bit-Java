const connect = require("connect");
const serveStatic = require("serve-static");
const connectRoute = require("connect-route");

const port = 9090;
const app = connect();

app.use(connectRoute(function(router) {
    router.get("/", function(req, resp) {
        resp.writeHead(200, {
            'Content-Type': 'text/html; charset="utf-8"'
        });

        resp.end("<h1>Main</h1>");
    });
    router.get("/user", function(req, resp) {
        resp.writeHead(200, {
            'Content-Type': 'text/html; charset="utf-8"'
        });

        resp.end("<h1>User</h1>");
    });
}))
app.use(serveStatic(__dirname + "/public")); // 정적 자원 위치 지정 (serve-static : 정적자원 관리 미들웨어)
app.listen(9090, function() {
    console.log("===== HTTP Server is Running on " + port + " =====");
})