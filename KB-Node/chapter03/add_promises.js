const fs = require('fs').promises;

const processFile = async () => {
  try {
    // 1. 파일 생성
    await fs.writeFile('./Node/chapter03/example.txt', 'Hello, Node.js!');
    console.log('파일이 생성되었습니다.');

    // 2. 파일 읽기
    await fs.readFile('./Node/chapter03/example.txt', 'utf-8');
    console.log('파일 내용: ', data);

    // 3. 파일에 내용 추가
    await fs.appendFile('./Node/chapter03/example.txt', '\n추가된 내용입니다.');
    console.log('파일에 내용이 추가되었습니다.');

    // 4. 파일 삭제
    await fs.unlink('./Node/chapter03/example.txt');
    console.log('파일이 삭제되었습니다.');
  } catch {
    console.log('오류 발생');
  }
};

processFile();
