const express = require('express');

const router = express.Router();


module.exports = router;

router.route('/01').get(function(req, res) {
    res.render("hello/01");
});

router.route('/02').get(function(req, res) {
    const data = {
        no: req.query.no || '',
        email: req.query.email || ''
    };

    res.render("hello/02", data);
})