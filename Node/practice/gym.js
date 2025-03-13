fs = require('fs');
const path = require('path');

const data = '서상훈, 나이: 24, 체중: 60kg, 운동: 벤치프레스 300kg';
fs.writeFile('./Node/practice/members/seo_sang_hoon.txt', data, (err) => {
  if (err) {
    console.log(err);
  }
  console.log('파일 생성 완료!');

  const dir = path.dirname('./Node/practice/members/seo_sang_hoon.txt');
  console.log(`디렉터리 경로: ${path.parse(dir).name}`);

  const fn = path.basename('./Node/practice/members/seo_sang_hoon.txt');
  console.log(`파일 이름: ${fn}`);

  const ext = path.extname('./Node/practice/members/seo_sang_hoon.txt');
  console.log(`파일 확장자: ${ext}`);

  const fn2 = path.basename(
    './Node/practice/members/seo_sang_hoon.txt',
    '.txt'
  );
  console.log(`파일 이름(확장자 제외): ${fn2}`);
});
