const orderList = require('./order');
const orderString = JSON.stringify(orderList);

if (orderString.includes('삼겹살')) {
  console.log(`🐽삼겹살 주문 수량: ${orderList.삼겹살}`);
} else {
  console.log(`❌삼겹살 주문 내역이 없습니다.`);
}
