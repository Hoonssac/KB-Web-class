// 일반 함수 ver
const test1 = function (a, b) {
  return a + b;
};

// 화살표 함수 ver
const test2 = (a, b) => {
  return a + b;
};

// 화살표 함수 return 생략 ver
// 구현부가 한줄짜리 간단한 코드일 때만 가능
const test3 = (a, b) => a + b;

console.log(test1(3, 4));
console.log(test2(3, 4));
console.log(test3(3, 4));
