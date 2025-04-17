const path = require('path'); // 내장 모듈

// 경로 연결하기
const fullPath = path.join('some', 'work', 'ex.txt');
console.log(fullPath);

// 파일 경로 추출하기
// __filename : 파일의 절대 경로
console.log(`파일 절대 경로: ${__filename}`);

// dirname : 해당 파일이 있는 폴더의 절대 경로
const dir = path.dirname(__filename);
console.log(`경로만: ${dir}`);

// 파일 이름 추출하기
// basename : 경로 제외한 파일명만 가져온다
const fn = path.basename(__filename);
console.log(`파일 이름: ${fn}`);

// 확장자까지 제외 가능
const fn2 = path.basename(__filename, '.js');
console.log(`파일 이름(확장자 제외): ${fn2}`);

// 확장자 추출하기
// extname : 확장자만 추출
const ext = path.extname(__filename);
console.log(`파일 확장자: ${ext}`);
console.log(path.basename(__filename, '.js'));

// 경로 분해하기
// parse : 경로에 대한 정보를 객체로 반환
const parsePath = path.parse(__filename);
console.log(parsePath);
