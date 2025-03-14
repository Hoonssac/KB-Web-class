let obj = { result: 0 };
obj.add = function (x, y) {
  this.result = x + y;
};

// 일반 함수에서는 호출한 객체가 this가 된다.
obj.add(3, 4);
console.log(obj);
