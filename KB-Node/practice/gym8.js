const fs = require('fs').promises;
const dietPath = './Node/practice/members/logs/diet.txt';

async function recordDiet(name, calories) {
  try {
    // 파일 읽기
    const data = await fs.readFile(dietPath, { encoding: 'utf-8' });

    // 칼로리 메시지 생성
    let message = `${name}: ${calories}kcal, 괜찮아요 아직 여유 있어요!`;

    await new Promise((resolve) => {
      setTimeout(resolve, 1000);
    });

    console.log(`${name} 회원님, 오늘도 건강한 한 끼 감사합니다!`);

    if (calories >= 500) {
      message += `\n${name} 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!`;
      console.log(`${name} 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!`);
    }
    await fs.appendFile(dietPath, `\n${message}`);

    console.log(`식단 기록이 맛있게 저장되었습니다!`);
  } catch (err) {
    console.log('file Error');
  }
}

async function checkDiet() {
  console.log('식단 기록 중...(오늘도 건강한 한 끼!)');
  await recordDiet('이승기', 550);
}

checkDiet();
