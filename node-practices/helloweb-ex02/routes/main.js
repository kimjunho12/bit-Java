const express = require('express');

const router = express.Router();


module.exports = router;

router.route('').get(function(req, res) {
    res.render("main/index");
});