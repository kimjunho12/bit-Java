## [ex01](./ex01)
### JS 모듈만 번들링  

1. 설치 패키지
   - `$ npm i -D webpack webpack-cli`
2. 스크립팅
   - ```json
      "build": "npx webpack ./src/index.js -o ./public"
     ```
3. 번들링
   - `$ npm run build`

## [ex02](./ex02/)
### webpack.config.js: 번들링 환경 설정 파일
1. 설치 패키지
   - `$ npm i -D webpack webpack-cli`
2. 번들링 환경 설정 ([webpack.config.js](./ex02/webpack.config.js))
   - ```jsonc
      module.exports = {
        entry: path.resolve("src/index.js"),
        output: {
            path: path.resolve('public'),
            filename: 'bundle.js'
        }
      }
     ```
3. 스크립팅
   - ```json
      "build": "npx webpack"
     ```
4. 번들링
   - `$ npm run build`

## [ex03](./ex03/)
### webpack 개발 서버 설정
1. 설치 패키지
   - `$ npm i -D webpack webpack-cli webpack-dev-server`
2. 개발 서버 설정 ([webpack.config.js](./ex03/webpack.config.js))
   - ```jsonc
        devServer: {
            host: '0.0.0.0',
            port: 9090,
            liveReload: true,
            hot: false,
            compress: true
        }
     ```
3. 스크립팅
   - ```json
      "start": "npx webpack serve --progress"
     ```
4. 개발 서버 실행
   - `$ npm start`

## [ex04](./ex04/)
### CSS 모듈 번들링 하기
1. 설치 패키지
   - `$ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader`
2. CSS Loader 설정 ([webpack.config.js](./ex04/webpack.config.js))
   - ```jsonc
        module: {
            rules: [{
                test: /\.css$/i,
                use: ['style-loader', 'css-loader']
            }]
        }
     ```
3. 개발 서버 실행
   - `$ npm start`

## [ex05](./ex05/)
### SASS/SCSS 모듈 번들링 하기
1. 설치 패키지
   - `$ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader node-sass sass-loader`
2. SASS/SCSS 설정 ([webpack.config.js](./ex05/webpack.config.js))
   - ```jsonc
        module: {
            rules: [{
                test: /\.(sa|sc|c)ss$/i,
                use: ['style-loader', 'css-loader', 'sass-loader']
            }]
        }
     ```
3. 개발 서버 실행
   - `$ npm start`

## [ex06](./ex06/)
### 이미지 모듈 번들링 하기
1. 설치 패키지
   - `$ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader node-sass sass-loader`
2. Image Loader 설정 ([webpack.config.js](./ex06/webpack.config.js))
   - ```jsonc
        output: {
            .
            [생략]
            .
            assetModuleFilename: 'assets/images/[hash][ext]'
        },
        module: {
            rules:[{
                test: /\.(png|git|jpe?g|svg|ico|tiff?|bmp)$/i,
                type: 'asset/resource'
            }]
        }
     ```
3. 개발 서버 실행
   - `$ npm start`