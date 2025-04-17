const c = require('ansi-colors'); // commonJS 방식

function hello(name) {
  console.log(c.green(name) + ' 님, 안녕하세요?');
}

hello('홍길동');
