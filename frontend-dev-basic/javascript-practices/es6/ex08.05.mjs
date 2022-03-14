/**
 * name & unnamed export
 */

const add = function (a, b) {
  return a + b;
};

const subtract = function (a, b) {
  return a - b;
};

const divide = function (a, b) {
  return a / b;
};

export { add, subtract, divide };

export default { add, subtract };
