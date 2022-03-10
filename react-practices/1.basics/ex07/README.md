___
## ex07
_ex00.cra Reconfiguration (직접 설정)_

1. 설치  
   `$ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader node-sass sass-loader babel-loader`  
   `$ npm i -D @babel/core @babel/cli @babel/preset-env @babel/preset-react`  
   `$ npm i react react-dom`


2. babel.config.json 설정
   ```jsonc
   {
    "presets": [
        ["@babel/preset-env", {
            "targets": {
                "ie" : "11",
                "edge" : "89",
                "firefox": "90",
                "chrome": "90",
                "opera": "76",
                "safari": "15"
            }
        }],
        "@babel/react"        // ["@babel/react", {}]
    ],
    "plugins": [

    ]
   }
   ```
3. webpack.config.js 설정
   ```js
   const path = require("path");

   module.exports = {
       mode: 'development',
       entry: path.resolve("src/index.js"),
       output: {
           path: path.resolve('public'),
           filename: 'main.js',
           assetModuleFilename: 'assets/imgaes/[hash][ext]'
       },
       module: {
           rules: [{
               test: /\.js$/i,
               exclude: /node_modules/,
               use: ['babel-loader']
           }, {
               test: /\.(sa|sc|c)ss$/i,
               use: ['style-loader', 'css-loader', 'sass-loader']
           }, {
               test: /\.(png|gif|jpe?g|svg|ico|tiff?|bmp)$/i,
               type: 'asset/resource'
           }]
       },
       devServer: {
           host: '0.0.0.0',
           port: 9090,
           liveReload: true,
           hot: false,
           compress: true,
           historyApiFallback: true
       }
   }
   ```
4. npm 스크립팅
   ```jsonc
    "scripts": {
        "start": "npx webpack serve --progress",
        "build": "npx webpack"
    }
   ```
5. 코드 리팩토링