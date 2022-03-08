const babel = require('@babel/core');

const result = babel.transform('const fn = () => 1;', {});
console.log(result);