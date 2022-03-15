___
## ex03
_Component - React Event_

### 01 : Inline Handler
### 02 : Function Handler
### 03 : Synthetic Event (이벤트 합성)
### 04 : Event Handler 예제
### 05 : Event Handler에서 'ref' 사용 : Functional Component
### 06 : Event Handler에서 'ref' 사용 : Class Component


___

1. 설치
    ```shell
    $ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader node-sass sass-loader babel-loader @babel/core @babel/cli @babel/preset-env @babel/preset-react
    $ npm i react react-dom
    ```

2. 설정
   - config/babel.config.json
   - config/webpack.config.js
        ```js
          const path = require("path");

          module.exports = function (env) {
            return {
              entry: path.resolve("src/${env.src}/index.js"),

              ...

            },
            module: {
                rules: [
                  {
                    loader: "babel-loader",
                    options: {
                      configFile: path.resolve("config/babel.config.json"),
                    },
                  },
                  
                  ...
            }
          };
        ```

3. npm 스크립팅
   ```jsonc
    "scripts": {
        "debug": "npx webpack serve --progress --config config/webpack.config.js --mode development --env",
        "build": "npx webpack"
    }
   ```

4. 실행  
   `$ npm run debug src={01|02|03|...}` 