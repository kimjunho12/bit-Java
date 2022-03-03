const http = require("http");
const path = require("path");
const express = require("express");

const helloRouter = require("./routes/hello");

const port = 9090;

// Application Setup
const application = express()
    // 1. static resources
    .use(express.static(path.join(__dirname, "assets")))
    // 2. request body pareser
    .use(express.urlencoded({ extended: true })) // application/x-www-form-urlencoded
    .use(express.json()) // application/json
    // 3. view engine
    // 4. request router
    .all('*', function(req, res, next) { // default servlet 같은거 ????
        res.locals.req = req;
        res.locals.res = res;

        next();
    })
    .use("/hello", helloRouter);

// Server Setup
http
    .createServer(application)
    .on("listening", function() {
        console.log("===== HTTP Server is Running on " + port + " =====");
    })
    .on("error", function(error) {
        console.error(error.message);
    })
    .listen(port);