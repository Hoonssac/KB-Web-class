fs = require('fs');

const data = '\n서상훈: 체중 60kg, 벤치프레스 327kg';

if (!fs.existsSync('./Node/practice/members/logs/members.txt')) {
  console.log('회원 정보 파일이 없습니다.');
} else {
  fs.appendFile('./Node/practice/members/logs/members.txt', data, (err) => {
    console.log('회원 정보가 성공적으로 추가되었습니다.');
  });
}
