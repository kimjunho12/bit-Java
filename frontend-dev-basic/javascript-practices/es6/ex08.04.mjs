/**
 * named export 1
 *
 * exports(require.js)와 유사하다. 이 모듈을 import 할 때에는 destructing이 가능
 */

const add = function (a, b) {
  return a + b;
};

const subtract = function (a, b) {
  return a - b;
};

// o = {
//   add,
//   subtract,
// };
export { add, subtract };
