___
## Node Practices

> 1. [패키지](#1-패키지)
> 2. [의존성](#2-의존성)
> 3. [패키지 설치 방식](#3-패키지-설치-방식)
> 4. [Node Project (FE / BE) 생성](#4-node-project-fe--be-생성)
> 5. [Module](#5-module)
> 6. [npmjs.com(npm registry)에 내 패키지 배포 (생략, https://)](#6-npmjscom-npm-registry에-내-패키지-배포-생략-https)
> 7. [helloweb-ex01  (맨바닥)](#7-helloweb-ex01-맨바닥)
> 8. [helloweb-ex02  (express)](#8-helloweb-ex02-express)

### 1. 패키지
- 완전한 애플리케이션 (nodedeamon, babel, webpack)
 
- 프로젝트에서 사용하는 모듈 (라이브러리)

### 2. 의존성
- 개발하는 프로젝트<sup>(애플리케이션, 패키지)</sup>에서 설치하고 사용하는 패키지
- **일반 의존성**  
  개발하고 있는 프로젝트에서 사용하는 패키지로 꼭 배포에 포함  
  `$[project-ex01] npm i ...`

- **개발 의존성**  
  개발에 필요하거나 도움이 되는 패키지(dev tool) 배포에 포함되지 않음  
  `$[project-ex01] npm i -D ...`

### 3. 패키지 설치 방식
  1) 전역(global) 설치 : 여러 프로젝트에서 공통으로 사용하는 도구 설치
  2) 지역(project/local) 설치 : 특정 프로젝트에 종속적인 도구나 라이브러리
  3) 패키지 설치  
    `npm i ejs          (local, general dependency)`  
    `npm i -D nodemon   (local, dev. dependency)`  
    `npm i -g gulp      (global)`  
    `npx gulp --version (설치 확인)`  
   ```shell
    BIT@DESKTOP-EHGSDDI MINGW64 /d/BIT/bit-Java/node-practices/project-ex01
    $ npm i ejs
    added 15 packages, and audited 16 packages in 1s
    found 0 vulnerabilities

    BIT@DESKTOP-EHGSDDI MINGW64 /d/BIT/bit-Java/node-practices/project-ex01
    $ npm i -D nodemon
    added 119 packages, and audited 135 packages in 4s
    16 packages are looking for funding
    run `npm fund` for details
    found 0 vulnerabilities

    BIT@DESKTOP-EHGSDDI MINGW64 /d/BIT/bit-Java/node-practices/project-ex01
    $ npm i -g gulp
    npm WARN deprecated source-map-url@0.4.1: See https://github.com/lydell/    source-map-url#deprecated
    npm WARN deprecated urix@0.1.0: Please see https://github.com/lydell/   urix#deprecated
    npm WARN deprecated resolve-url@0.2.1: https://github.com/lydell/   resolve-url#deprecated
    npm WARN deprecated source-map-resolve@0.5.3: See https://github.com/lydell/    source-map-resolve#deprecated
    npm WARN deprecated chokidar@2.1.8: Chokidar 2 does not receive security    updates since 2019. Upgrade to chokidar 3 with 15x fewer dependencies

    added 349 packages, and audited 350 packages in 16s
    8 packages are looking for funding
      run `npm fund` for details
    5 high severity vulnerabilities
    To address all issues (including breaking changes), run:
      npm audit fix --force
    Run `npm audit` for details.
   ```
  4) 패키지 삭제  
    `npm un ejs          (local install 삭제)`  
    `npm un -g gulp      (global install 삭제)`
   ```shell
   BIT@DESKTOP-EHGSDDI MINGW64 /d/BIT/bit-Java/node-practices/project-ex01
    $ npm un -g gulp
    removed 349 packages, and audited 1 package in 1s
    found 0 vulnerabilities
   ```  

### 4. Node Project (FE / BE) 생성
_Node(JavaScript) Project (FE/BE Application, Package) 생성_  
  1) 프로젝트 생성 : `mkdir`
  2) 프로젝트 이동 : `cd`
  3) 프로젝트 초기화 : 프로젝트 메니페스트 파일 (package.json) 생성  
    `$[project-ex02] npm init`
   ```shell
   BIT@DESKTOP-EHGSDDI MINGW64 /d/BIT/bit-Java/node-practices/project-ex02
    $ npm init
    This utility will walk you through creating a package.json file.
    It only covers the most common items, and tries to guess sensible defaults.

    See `npm help init` for definitive documentation on these fields
    and exactly what they do.

    Use `npm install <pkg>` afterwards to install a package and
    save it as a dependency in the package.json file.

    Press ^C at any time to quit.
    package name: (project-ex02)
    version: (1.0.0)
    description:
    entry point: (index.js)
    test command:
    git repository:
    keywords:
    author:
    license: (ISC)
    About to write to D:\BIT\bit-Java\node-practices\project-ex02\package.json:

    {
      "name": "project-ex02",
      "version": "1.0.0",
      "description": "",
      "main": "index.js",
      "scripts": {
        "test": "echo \"Error: no test specified\" && exit 1"
      },
      "author": "",
      "license": "ISC"
    }


    Is this OK? (yes)
   ```

### 5. Module
  1) 코어 모듈(fs, os, ... node에서 제공해 주는 모듈)
  2) 파일 모듈 : 파일 경로로 불러와서 모듈안의 함수, 객체를 사용
  3) npm 모듈 : npm을 통해서 node_module에 설치하고 사용하는 모듈
       - 원격 배포
       - 로컬 배포

### 6. npmjs.com (npm registry)에 내 패키지 배포 (생략, https://)
_원격 배포_

### 7. [helloweb-ex01](./helloweb-ex01) (맨바닥)
_웹 애플리케이션 만들어보기 (그냥)_
  1) [app01](./helloweb-ex01/app01.js) : http - core module 기반
  2) [app02](./helloweb-ex01/app02.js) : http, fs - core module 기반
  3) [app03](./helloweb-ex01/app03.js) : connect, serve-static - npm package 기반
  4) [app04](./helloweb-ex01/app04.js) : connect, serve-static, connect-route - npm package 기반

### 8. [helloweb-ex02](./helloweb-ex02) (express)
_웹 애플리케이션 만들어보기 (express 프레임워크)_
