/**
 * unnamed export with default
 */

export default function (a, b) {
  return a + b;
}

// 오류 : 이름 없이 export 하기 때문에 하나만 export 할 수 있다.
// export default function(a, b) {
//    return a - b;
//}
