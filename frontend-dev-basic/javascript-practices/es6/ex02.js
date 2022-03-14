/**
 * const: Block Scope의 상수
 */

// 1. block scope 확인
try {
  if (true) {
    const NUM = 10;
  }
  console.log(NUM);
} catch (error) {
  console.error("[error] " + error);
}

// 2. error: 대입 (Assignment) 에러
try {
  const NUM = 10;
  NUM = 20;
  console.log(NUM);
} catch (error) {
  console.error("[error] " + error);
}
