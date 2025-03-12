var getTriangle = (base, height) => (base * height) / 2;
var getCircle = (radius) => radius * radius * Math.PI;

// 객체 return 시에는 ()로 한번 더 감싸준다. 함수 본체로 인식되기 때문에
var getObject = (x) => ({
  a: 5,
  b: 4,
});

console.log('삼각형의 면적: ' + getTriangle(5, 2));
console.log('원의 면적: ' + getCircle(5));
