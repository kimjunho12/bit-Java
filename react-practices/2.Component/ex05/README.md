___
## ex05
_Component - Lifecycle_

### 01 : Class Component
  - Lifecycle I : mount
    1. constructor
    2. getDerivedStateFromProps : props로 받아온 값을 state에 동기화 [react v16.3 +]
    3. render
    4. *componentDidMount : 컴포넌트 생성을 마치고 렌더링 작업이 끝난 후
     
  - Lifecycle II : update
    1. getDerivedStateFromProps
    2. shouldComponentUpdate : props나 state을 변경 했을 때, 리렌더링 여부를 결정
    3. render
    4. getSnapshotBeforeUpdate : 메소드 호출 후, DOM에 변화를 반영하기 직전에 호출 [react v16.3 +]
    5. *componentDidUpdate : DOM 업데이트가 끝난 직후 호출, DOM 작업 가능
   
  - Lifecycle III : Unmount
    1. *componentWillUnmount : 컴포넌트를 DOM에서 제거하기 전

  - 예제
    - src/01

### 02 : Alternative : Function Component Lifecycle - useEffect Hook
  - Alternative I : getDerivedStateFromProps
  - After Rendering 함수 : (상태의 변화 -> 렌더링 -> 함수)
  - 어떤 특정 상태의 변화에 반응하는 After Rendering 함수 : 관심의 분리
  - Alternative II : componentDidMount & componentWillUnmount
  - 예제
    - src/02

### 03 : Clock Component
_Class Component Lifecycle 이용_  
  - src/03

### 04 : Clock Component
_useEffect Hook 이용_  
  - src/04
___

1. 설치
    ```shell
    $ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader node-sass sass-loader babel-loader @babel/core @babel/cli @babel/preset-env @babel/preset-react
    $ npm i react react-dom prop-types
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