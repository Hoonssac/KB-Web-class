const fs = require('fs');

const rs = fs.createReadStream('./Node/practice/members/logs/workout_log.txt');
const ws = fs.createWriteStream('./Node/practice/members/logs/backup_log.txt');

// pipe를 이용하면 여러개의 스트림을 이어서 처리 가능
rs.pipe(ws);
