const fs = require('fs');
const path = './Node/practice/members/logs/workout_log.txt';
const destPath = './Node/practice/members/logs/backup_log.txt';

const rs = fs.createReadStream(path);
const ws = fs.createWriteStream(destPath);

rs.on('error', (err) => {
  console.error(`백업 중 오류가 발생했습니다. Error: ${err.message}`);
});

ws.on('error', (err) => {
  console.error(`백업 중 오류가 발생했습니다. Error: ${err.message}`);
});

ws.on('finish', () => {
  console.log('백업이 완료되었습니다.');
});

rs.pipe(ws);
