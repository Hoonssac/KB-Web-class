fs = require('fs');

fs.appendFile('./Node/chapter03/text-2.txt', '\n\n 새로운 내용 추가', (err) => {
  if (err) {
    console.log(err);
  }
  console.log('appending to file');
});
