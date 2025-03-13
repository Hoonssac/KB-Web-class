fs = require('fs');

const data = fs.readFileSync('./Node/chapter03/example.txt', 'utf-8');
fs.writeFileSync('./Node/chapter03/text-1.txt', data);
