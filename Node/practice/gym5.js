function runStretching() {
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log('🤸‍♂️스트레칭 완료');
      resolve();
    }, 1000);
  });
}

function runTreadmill() {
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log('🏃‍♂️러닝머신 완료');
      resolve();
    }, 500);
  });
}

function runProtein() {
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log('🍗단백질 보충 완료');
      resolve();
    }, 0);
  });
}

async function exercise() {
  await runStretching();
  await runTreadmill();
  await runProtein();
  console.log('운동 기록 처리 종료');
}

console.log('운동 기록 처리 시작');
exercise();
