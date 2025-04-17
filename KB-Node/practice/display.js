export function calculateDiscount(price, quantity) {
  // 5인분 이상이면 10% 할인 적용 후 가격 계산
  // 5인분 미만일 경우, 할인 없이 원래 가격 계산
  let totalPrice = 0;
  if (quantity >= 5) {
    totalPrice = price * quantity * 0.9;
  } else {
    totalPrice = price * quantity;
  }
  return `✅ 최종 결제 금액: ${totalPrice.toLocaleString()}원`;
}
