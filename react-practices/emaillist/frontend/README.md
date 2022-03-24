___

```
📦emaillist
 ┣ 📂config
 ┃ ┣ 📜babel.config.json
 ┃ ┗ 📜webpack.config.js
 ┣ 📂public
 ┃ ┣ 📜index.html
 ┃ ┣ 📜styles.css
 ┃ ┗ 📜_index.html
 ┣ 📂src
 ┃ ┣ 📂assets
 ┃ ┃ ┣ 📂json
 ┃ ┃ ┃ ┗ 📜data.json
 ┃ ┃ ┗ 📂scss
 ┃ ┃ ┃ ┣ 📜App.scss
 ┃ ┃ ┃ ┣ 📜Email.scss
 ┃ ┃ ┃ ┣ 📜Emaillist.scss
 ┃ ┃ ┃ ┣ 📜RegisterForm.scss
 ┃ ┃ ┃ ┗ 📜SearchBar.scss
 ┃ ┣ 📜App.js
 ┃ ┣ 📜Email.js
 ┃ ┣ 📜Emaillist.js
 ┃ ┣ 📜index.js
 ┃ ┣ 📜RegisterForm.js
 ┃ ┗ 📜SearchBar.js
 ┗ 📜package.json
```

> SCSS 분리
> Validation
> Data Flow (Top-Down / Bottom-Up (/w SearchBar callback))


1. 설치
    ```shell
    $ npm i -D webpack webpack-cli webpack-dev-server style-loader css-loader node-sass sass-loader babel-loader @babel/core @babel/cli @babel/preset-env @babel/preset-react @babel/plugin-transform-runtime @babel/plugin-syntax-throw-expressions
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
        "debug": "npx webpack serve --progress --config config/webpack.config.js --mode development",
        "build": "npx webpack"
    }
   ```

4. 실행  