___
## ex04
_애플리케이션 번들링 (bundling)_ 

> ### Webpack
> : 작게 분리된 많은 애플리케이션의 모듈(js, css, image, font)들의 의존성을 분석해서 하나의 JS 파일로 묶는 도구

1. 하나의 JS파일을 번들 (bundle)이라고 하고 묶는 작업을 번들링(bundling) 이라고 함
2. 번들링이 단순히 모듈들을 하나의 파일로 묶는 작업만을 의미 하지 않는다. (build 작업)
3. 빌드 작업
   - linting (ESLint, 문법 체크)
   - document (JSDoc)
   - test (Mocha, jest)
   - 난독화 / 압축 (Uglyfy)
   - 번들링  
   <br>![](https://images.velog.io/images/98kimjh/post/3e95ae0d-11ee-4312-bacf-ffde7071a6bf/image.png)
   
   <br>
4. 자바 스크립트 뚠만 아니라 다양한 에셋(image, css, font)들도 모듈로 취급
5. 설치  
   `$ npm i -D webpack webpack-cli`  
   `$ npm .\node_modules\.bin\webpack --version`  
   `$ npx webpack --version`