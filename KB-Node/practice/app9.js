import { menu } from './menu.js';
import { filterMenuByPrice } from './menuFilter.js';

const maxPrice = 18000;

async function showAffordableMenu() {
  const filteredMenu = await filterMenuByPrice(menu, maxPrice);
  console.log('✅ 선택 가능한 메뉴:');
  for (const i of filteredMenu) {
    console.log(`${i.meat}: ${i.price}원`);
  }
}

showAffordableMenu();
