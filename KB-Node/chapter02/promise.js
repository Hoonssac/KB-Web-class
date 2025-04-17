let likePizza = true;
const pizza = new Promise((resolve, reject) => {
  // resolve : 성공시 호출하는 메서드
  if (likePizza) resolve('피자를 주문합니다.');
  // reject : 실패시 호출하는 메서드
  else reject('피자를 주문하지 않습니다.');
});

// then으로 resolve 매개변수 받아오기
pizza.then((result) => console.log(result)).catch((err) => console.log(err));
