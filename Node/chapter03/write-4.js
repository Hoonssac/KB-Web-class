fs = require('fs');

let content = `
===========================
새로운 내용을 추가해 보겠습니다
===========================
`;

fs.writeFileSync('./Node/chapter03/text-1.txt', content, { flag: 'a' });
