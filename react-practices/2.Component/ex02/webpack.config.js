const path = require("path");

module.exports = function (env) {
  return {
    entry: path.resolve(`src/${env.src}/index.js`),
    output: {
      path: path.resolve("public"),
      filename: "main.js",
      assetModuleFilename: "assets/imgaes/[hash][ext]",
    },
    module: {
      rules: [
        {
          test: /\.js$/i,
          exclude: /node_modules/,
          use: ["babel-loader"],
        },
        {
          test: /\.(sa|sc|c)ss$/i,
          use: ["style-loader", "css-loader", "sass-loader"],
        },
        {
          test: /\.(png|gif|jpe?g|svg|ico|tiff?|bmp)$/i,
          type: "asset/resource",
        },
      ],
    },
    devServer: {
      host: "0.0.0.0",
      port: 9090,
      liveReload: true,
      hot: false,
      compress: true,
      historyApiFallback: true,
    },
  };
};
