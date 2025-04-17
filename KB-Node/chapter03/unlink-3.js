const fs = require('fs');

if (!fs.existsSync('./Node/chapter03/text-2.txt')) {
  console.log('file does not exist');
} else {
  fs.unlinkSync('./Node/chapter03/text-2.txt', (err) => {
    if (err) {
      return console.error(err);
    }
    console.log('file deleted');
  });
}
