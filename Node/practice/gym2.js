fs = require('fs');

fs.readFile(
  './Node/practice/members/logs/workout_log.txt',
  'utf-8',
  (err, data) => {
    if (err) {
      console.error('운동 기록 파일이 없습니다.');
    } else {
      console.log(`운동 기록 출력 완료!`);
      console.log(data);
    }
  }
);
