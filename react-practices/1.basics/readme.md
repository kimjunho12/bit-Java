___
## React Practices - Basics

### [ex00.cra](./ex00.cra/)
_create-react-app(cra)으로 React Application 빨리 만들어보기_
<details>
<summary> CRA React App 과정 자세히 보기 </summary>
- cra 설치
```shell
    PS D:\BIT\bit-Java\react-practices\1.basics> npm i -g create-react-app
    npm WARN deprecated tar@2.2.2: This version of tar is no longer supported, and will not receive security updates. Please upgrade asap.

    added 67 packages, and audited 68 packages in 2s

    4 packages are looking for funding
      run `npm fund` for details

    2 high severity vulnerabilities

    Some issues need review, and may require choosing
    a different dependency.

    Run `npm audit` for details.
```
- React Application 생성
```shell
    PS D:\BIT\bit-Java\react-practices\1.basics> npx create-react-app ex00.cra

    Creating a new React app in D:\BIT\bit-Java\react-practices\1.basics\ex00.cra.

    Installing packages. This might take a couple of minutes.
    Installing react, react-dom, and react-scripts with cra-template...


    added 1367 packages in 53s

    169 packages are looking for funding
      run `npm fund` for details

    Installing template dependencies using npm...
    npm WARN deprecated source-map-resolve@0.6.0: See https://github.com/lydell/source-map-resolve#deprecated

    added 38 packages in 4s

    169 packages are looking for funding
      run `npm fund` for details
    Removing template package using npm...


    removed 1 package, and audited 1405 packages in 3s

    169 packages are looking for funding
      run `npm fund` for details

    6 moderate severity vulnerabilities

    To address all issues (including breaking changes), run:
      npm audit fix --force

    Run `npm audit` for details.

    Success! Created ex00.cra at D:\BIT\bit-Java\react-practices\1.basics\ex00.cra
    Inside that directory, you can run several commands:

      npm start
        Starts the development server.

      npm run build
        Bundles the app into static files for production.

      npm test
        Starts the test runner.

      npm run eject
        Removes this tool and copies build dependencies, configuration files
        and scripts into the app directory. If you do this, you can’t go back!

    We suggest that you begin by typing:

      cd ex00.cra
      npm start

    Happy hacking!
```
- 실행
![cra_react_start](https://images.velog.io/images/98kimjh/post/657f84a1-b7fe-47ef-81d6-c40e6882ef56/image.png)
</details>

### [ex01](./ex01/)
_전통적인 DOM API 기반의 애플리케이션_ 

### [ex02](./ex02/)
_애플리케이션1 : 애플리케이션 분리_

### [ex03](./ex03/)
_애플리케이션2 : ES6 모듈 시스템_

### [ex04](./ex04/)
_번들링 : webpack_

### ex05
_React API 기반의 애플리케이션 리팩토링_

### ex06
_React JSX 기반의 애플리케이션 리팩토링 /w babel(transpile)_

### ex07
_ex00.cra Reconfiguration (직접설정)_

### ex08
_JSX Tutorial_


### Appendices
[webpack-practices](./)  
[babel-practices](./)