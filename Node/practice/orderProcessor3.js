export function processOrder(order) {
  // 주문 수량이 3인분 이상일 때만 주문 처리
  // 조건에 맞지 않는 주문은 "주문 최소 수량 미달"
  return new Promise((resolve) => {
    setTimeout(() => {
      if (order.quantity < 3) {
        resolve(
          `❌ ${order.meat} ${order.quantity}인분은 주문 최소 수량 미달입니다.`
        );
      } else {
        resolve(`✅ ${order.meat} ${order.quantity}인분 주문 완료!`);
      }
    }, 1000);
  });
}
