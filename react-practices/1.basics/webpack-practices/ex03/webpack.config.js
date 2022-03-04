const path = require("path");

module.exports = {
    mode: 'development',
    entry: path.resolve("src/index.js"),
    output: {
        path: path.resolve('public'),
        filename: 'bundle.js'
    },
    devServer: {
        host: '0.0.0.0',
        port: 9090,
        liveReload: true,
        hot: false,
        compress: true
    }
}