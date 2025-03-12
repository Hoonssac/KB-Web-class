import { orderList, addOrder } from './orderManager.js';

addOrder('삼겹살', '3인분');
addOrder('목살', '2인분');

console.log('🐽 현재 주문 내역: ');
if (orderList.length > 0) {
  for (let i = 0; i < orderList.length; i++) {
    console.log(`${orderList[i].menu}: ${orderList[i].quantity}`);
  }
} else {
  console.log(`❌주문 내역이 없습니다.`);
}
