const fs = require('fs').promises;
const path = require('path');

const files = {
  bench: './Node/practice/members/logs/bench.txt',
  squat: './Node/practice/members/logs/squat.txt',
  deadlift: './Node/practice/members/logs/deadlift.txt',
};

async function getRecord(filePath, name) {
  try {
    const data = await fs.readFile(filePath, 'utf-8');
    const lines = data.trim().split('\n');
    for (const line of lines) {
      const [memberName, record] = line.split(': ').map((item) => item.trim());
      if (memberName === name) {
        return parseInt(record, 10);
      }
    }
    return null;
  } catch (err) {
    if (err.code === 'ENOENT') {
      console.error('운동 기록 파일이 없습니다!');
    } else {
      console.error('파일 읽기 오류:', err);
    }
    return null;
  }
}

async function analyzeRecords(name) {
  const benchRecord = await getRecord(files.bench, name);
  const squatRecord = await getRecord(files.squat, name);
  const deadliftRecord = await getRecord(files.deadlift, name);

  if (benchRecord === null && squatRecord === null && deadliftRecord === null) {
    console.log(`${name} 회원님의 기록이 없습니다!`);
    return;
  }

  const total = (benchRecord || 0) + (squatRecord || 0) + (deadliftRecord || 0);

  if (total >= 500) {
    console.log(`${name} 회원님! 3대 500 돌파! 강력한 힘의 소유자!`);
  } else if (total >= 200) {
    console.log(`${name} 회원님, 3대 200은 넘으셨네요. 꾸준히 파이팅!`);
  } else {
    console.log(`${name} 회원님, 아직 3대 200은 부족해요. 힘내세요!`);
  }
}

async function main() {
  await analyzeRecords('이승기');
  await analyzeRecords('김종국');
  await analyzeRecords('유재석');
  await analyzeRecords('박보검');
  await analyzeRecords('이병헌');
  await analyzeRecords('정우성');
}

main();
