let obj = { result: 0 };
obj.add = function (x, y) {
  this.result = x + y;
};

let add2 = obj.add;
console.log(add2 === obj.add);
