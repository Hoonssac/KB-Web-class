import { orders } from './orderList.js';

import { calculateTotal, isTopMenu } from './orderProcessor2.js';

const totalOrders = calculateTotal(orders);
console.log('✅ 총 주문 수량:', totalOrders);

console.log(
  `🥩 삼겹살이 가장 인기 메뉴인가요? ${
    isTopMenu(orders, '삼겹살') ? '네!' : '아니오!'
  }`
);
