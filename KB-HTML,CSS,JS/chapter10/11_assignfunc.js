var add = function (a, b) {
  return a + b;
};

// 변수도 함수처럼 전달 가능
var plus = add;
console.log('2 + 3 = ' + plus(2, 3));
