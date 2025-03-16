const fs = require('fs').promises;
const listPath = './Node/practice/members/logs/reservations.txt';

const name = '이승기';
const field = '스피닝';

async function enter() {
  try {
    // fs.promises.readFile을 사용하여 파일 읽기
    const data = await fs.readFile(listPath, { encoding: 'utf-8' });

    if (data.includes(name)) {
      return `${name} 회원님은 이미 예약되어 있습니다.`;
    } else {
      // setTimeout을 Promise로 감싸서 비동기 처리
      await new Promise((resolve) => setTimeout(resolve, 1000));

      // 파일에 새 예약 추가
      await fs.appendFile(listPath, `\n${name}: ${field}`);
      console.log(`${name} 회원님의 ${field} 예약이 완료되었습니다.`);
      return '예약 기록이 파일에 저장되었습니다!';
    }
  } catch (err) {
    // 파일이 없는 경우 새로 생성
    if (err.code === 'ENOENT') {
      console.log('예약 파일이 없어 새로 생성합니다.');
      await fs.writeFile(listPath, `${name}: ${field}`);
      console.log(`${name} 회원님의 ${field} 예약이 완료되었습니다.`);
      return '첫 예약 기록이 파일에 저장되었습니다!';
    }
    console.error('파일 읽기 오류:', err);
    return '예약 처리 중 오류가 발생했습니다.';
  }
}

async function check() {
  console.log('예약 처리 중...');
  console.log(await enter());
}

check();
