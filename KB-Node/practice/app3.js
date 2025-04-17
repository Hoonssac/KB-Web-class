import { grillMeat } from './grill.js';

async function startGrilling() {
  await grillMeat('삼겹살');
}
startGrilling();
console.log('식사 시작!');
