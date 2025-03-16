// 5명 이상일 때 대형 룸 예약
export function reserveLargeRoom() {
  return '✅ 대형 룸이 예약되었습니다.';
}

// 5명 미만일 때 일반석 예약
export function reserveStandardSeat() {
  return '✅ 일반석이 예약되었습니다.';
}

// 인원 수에 따라 위의 함수를 선택적으로 반환
export function getReservation(people) {
  let output;
  if (people >= 5) {
    output = reserveLargeRoom();
  } else {
    output = reserveStandardSeat();
  }
  return output;
}
