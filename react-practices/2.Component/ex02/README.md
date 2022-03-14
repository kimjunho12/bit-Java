___
## ex02 : Component Styling (Working with UI)

### 01. Inline Styling
### 02. Normal CSS (css loader options : {module: false})
### 03. Normal CSS (css loader options : {module: true})
### 04. CSS Module (css loader options : {module: true})
### 05. SACC & SCSS
### 06. 
### 07. 
### 08. 

___

1. 설치
    ```shell
    $ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader node-sass sass-loader babel-loader @babel/core @babel/cli @babel/preset-env @babel/preset-react
    $ npm i react react-dom
    ```

2. 설정
   - babel.config.json
   - webpack.config.js
        ```js
          const path = require("path");

          module.exports = function (env) {
            return {
              entry: path.resolve("src/${env.src}/index.js"),

              ...

            };
          };
        ```

3. npm 스크립팅
   ```jsonc
    "scripts": {
        "debug": "npx webpack serve --progress --mode development --env",
        "build": "npx webpack"
    }
   ```

4. 실행  
   `$ npm run debug src=00`