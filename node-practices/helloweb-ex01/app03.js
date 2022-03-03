const connect = require("connect");
const serveStatic = require("serve-static");

const port = 9090;
const app = connect();

app.use(serveStatic(__dirname + "/public")); // 정적 자원 위치 지정 (serve-static : 정적자원 관리 미들웨어)
app.listen(9090, function() {
    console.log("===== HTTP Server is Running on " + port + " =====");
})