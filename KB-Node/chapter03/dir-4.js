fs = require('fs');

fs.rm('./Node/chapter03/test2', { recursive: true }, (err) => {
  if (err) return console.error(err);

  console.log('folder deleted');
});
