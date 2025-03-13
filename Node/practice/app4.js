import { processOrder } from './orderProcessor.js';

async function processOrders() {
  console.log(await processOrder('삼겹살', 2));
  console.log(await processOrder('목살', 3));
  console.log(await processOrder('갈비', 1));
  console.log(`🔥모든 주문 처리 완료! 식사 시작!`);
}

processOrders();
