const fs = require('fs');

let files = fs.readdirSync('./');
console.log(files);

files = fs.readdirSync(__dirname);
console.log(files);
