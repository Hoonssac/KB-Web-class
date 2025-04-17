import { processOrder } from './orderProcessor3.js';

// 고기와 수량을 담은 orders 배열
const orders = [
  { meat: '삼겹살', quantity: 2 },
  { meat: '목살', quantity: 3 },
  { meat: '갈비', quantity: 1 },
  { meat: '항정살', quantity: 4 },
];

async function processAllOrders() {
  for (const order of orders) {
    console.log(await processOrder(order));
  }
}

processAllOrders();
