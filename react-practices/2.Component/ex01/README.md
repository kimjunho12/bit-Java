___
## ex01 : Property

### 01. props(property)
- 컴포넌트의 데이터
- 부모에서 자식으로 전달
  - Component Communication(컴포넌터간의 통신), Data Flow
  - Top -> Down
- 자식 컴포넌트에서 변경 불가
- 부모가 소유

### 02. FoodList src/01 : 클래스 컴포넌트

### 03. FoodList src/02 : Data Flow : 클래스 컴포넌트

### 04. FoodList src/03 : Data Flow : 함수 컴포넌트

### 05. FoodList src/04 : Validation

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