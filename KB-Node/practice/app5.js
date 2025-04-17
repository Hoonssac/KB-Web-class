import { orderStatus, updateStatus } from './status.js';

async function trackStatus() {
  console.log(await updateStatus('samgyeopsal', '굽는 중'));
  console.log(await updateStatus('samgyeopsal', '완료'));
  console.log(await updateStatus('galbi', '굽는 중'));
  console.log(await updateStatus('galbi', '완료'));
  console.log(`📋 최종 주문 상태: ${JSON.stringify(orderStatus)}`);
}

trackStatus();
