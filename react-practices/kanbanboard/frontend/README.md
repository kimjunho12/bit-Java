___
## Kanban Board

Commponent 데이터 전달

```
📦kanbanboard
 ┣ 📂public
 ┃ ┣ 📜babel.config.json
 ┃ ┗ 📜webpack.config.json
 ┣ 📂public
 ┃ ┣ 📜data.json
 ┃ ┣ 📜index.h
 ┃ ┣ 📜styles.css
 ┃ ┗ 📜_index.html
 ┣ 📂src
 ┃ ┣ 📜App.js
 ┃ ┣ 📜CardList.js
 ┃ ┣ 📜CardListItems.js
 ┃ ┣ 📜index.js
 ┃ ┗ 📜TaskList.js
 ┣ 📜babel.config.json
 ┣ 📜package-lock.json
 ┣ 📜package.json
 ┣ 📜README.md
 ┗ 📜webpack.config.js
```

![Kanban Board 예시 이미지](https://user-images.githubusercontent.com/42087448/158123894-ed57f2bf-06a1-4b61-bff2-4d47b8697f2a.png)


1. 설치
    ```shell
    $ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader node-sass sass-loader babel-loader @babel/core @babel/cli @babel/preset-env @babel/preset-react @babel/plugin-transform-runtime @babel/plugin-syntax-throw-expressions
    $ npm i react react-dom prop-types react-addons-update
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
      "build": "npm run build:frontend && npm run build:backend",
      "build:frontend": "npx webpack",
      "build:backend": "cd ../backend && mvn clean package",
      "dev": "",
      "dev:frontend": "npx webpack serve --progress --config config/webpack.  config.js --mode development",
      "dev:backend": "cd ../backend && mvn spring-boot:run"
    },
   ```

4. 실행  
   `$ npm run [build | build:frontend | build:backend | dev | dev:frontend | dev:backend]`