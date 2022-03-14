/**
 * named export 1
 *
 * exports(require.js)와 유사하다. 이 모듈을 import 할 때에는 destructing이 가능
 */

export const add = function (a, b) {
  return a + b;
};

export const subtract = function (a, b) {
  return a - b;
};
