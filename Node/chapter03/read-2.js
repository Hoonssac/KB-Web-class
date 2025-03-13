fs = require('fs');

const data = fs.readFileSync('./Node/chapter03/example.txt', 'utf-8');
console.log(data);
