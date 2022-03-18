___
## ex04
_Component - State_

### 01 : 기본 개념
  1. state
     - 컴포넌트 내부의 현재 상태를 나타내는 쓰기 가능한 데이터
     - 컴포넌트는 this.state 안에 에러 데이터(상태) 가질 수 있다.
     - this.state은 특정 컴포넌트 전용이며 변경을 위해서 setState 함수를 사용 (class Component)
     - 상태가 업데이트 되면 컴포넌트의 반응형 (Reactive) Rendering이 트리거되고  
     컴포넌트와 자식 컴포넌트가 다시 렌더링
     - 컴포넌트의 동작(event)와 상호작용을 수행할 수 있는 매커니즘을 제고
     - 클래스 컴포넌트에서는 constructor에서 초기화
     - 클래스 컴포넌트에서 상태 변경을 위해서는 setState 함수를 사용
     - 함수 컴포넌트에서는 useState 후크 함수를 통해 초기화
     - 함수 컴포넌트에서 상태변경을 위해 useState 후크함수를 사용하고  
     변환된 배열의 두번째 배열 요소를 사용
  2. 예제 : src/01
### 02 : 제어 컴포넌트

### 03 : 상태(Stateful) 컴포넌트 vs 순수(Pure, Dumb) 컴포넌트
- emaillist
### 04 : Data Flow - Bottom-Up
- emaillist

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