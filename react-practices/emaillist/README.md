## React Pracractices - Integration(개발 환경 통합)

## Configuration
1. Application(Project) Structure
   <pre>
   /emaillist
    |--- /backend
    |       |--- /src
    |       |--- pom.xml
    |--- /frontend
    |       |--- /config
    |       |       |--- babel.config.json
    |       |       |--- [webpack.config.json]
    |       |--- /public
    |       |       |--- favicon.ico
    |       |       |--- index.html
    |       |--- /src
    |       |       |--- /assets
    |       |--- /node_modules
    |       |--- package.json
    |       |--- package-lock.json
   </pre>
2. webpack dev server
3. package.json
4. concurrently

emaillist
    - 개발 통합 설정(with Spring Boot Backend)
    - backend: Fully APIs
    - Frontend: React(SPA)
    - AJAX: fetch 기반
    