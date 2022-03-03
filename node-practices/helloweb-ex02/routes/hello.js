const express = require('express');

const router = express.Router();


module.exports = router;

router.route('/01').get(function(res, resp) {
    resp.writeHead(200, {
        'Content-Type': 'text/html; charset="utf-8"'
    });

    resp.end("<h1>/Hello/01</h1>");
})