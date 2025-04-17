fs = require('fs');

// readFile : 콜백함수를 받아서 파일을 비동기로 읽어온다.
fs.readFile('./Node/chapter03/example.txt', 'utf-8', (err, data) => {
  if (err) {
    console.error(err);
  }
  console.log(data);
});
