fs = require('fs');

fs.readFile('./Node/chapter03/example.txt', 'utf-8', (err, data) => {
  if (err) {
    console.log(err);
  }

  // fs.writeFileSync : 넣어준 내용으로 새로운 파일을 쓴다 (동기기)
  fs.writeFile('./Node/chapter03/text-2.txt', data, (err) => {
    if (err) {
      console.log(err);
    }
    console.log('text-2.txt is saved!');
  });
});
