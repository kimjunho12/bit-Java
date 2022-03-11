___
## ex08
_JSX Tutorial_

> [01](./src/01/). 특징 1: HTML과 차이점  
> [02](./src/02/). 특징 2: Single Root node   
> [03](./src/03/). 함수 컴포넌트 만들기  
> [04](./src/04/). Pure React(React API)로 컴포넌트 작성  
> [05](./src/05/). 클래스 컴포넌트 만들기  
> [06](./src/06/). 특징 3: JSX 표현식 표기법({js expression})과 문제점  
> [07](./src/07/). Dynamic HTML Rendering 
> [08](./src/08/). Comment 

1. 설치  
   `$ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader node-sass sass-loader babel-loader`  
   `$ npm i -D @babel/core @babel/cli @babel/preset-env @babel/preset-react`  
   `$ npm i react react-dom`

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