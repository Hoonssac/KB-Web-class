fs = require('fs');

// readFileSync : 현재 파일을 동기적으로 읽는다 (기본적으로 이전 데이터)
const data = fs.readFileSync('./Node/chapter03/example.txt', 'utf-8');
console.log(data);
