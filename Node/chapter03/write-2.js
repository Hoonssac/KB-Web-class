fs = require('fs');

const data = fs.readFileSync('./example.txt', 'utf-8');

// existsSync : 해당 경로에 파일이 있는지 bool 값으로 반환
if (fs.existsSync('text-1'.txt)) {
  // 파일이 이미 존재한다면 여기서 처리
  console.log('file alraedy exist');
} else {
  // 파일이 없다면 기록
  fs.writeFileSync('./text-1.txt', data);
}
