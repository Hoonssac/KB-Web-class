// 동기 방식, 순차적으로 처리

function displayA() {
  console.log('A');
}

function displayB() {
  // 2초 후에 B를 출력하라 -> 콜백 함수
  setTimeout(() => {
    console.log('B');
    // 받아온 콜백함수를 언제 설명해줄지 결정, 비동기
  }, 2000);
}

function displayC() {
  console.log('C');
}

displayA();
displayB();
displayC();
