let items = {};

// 용품
class Item {
  constructor(name, type, stock, alreadyWarned) {
    this.name = name;
    this.type = type;
    this.stock = stock;
    this.alreadyWarned = alreadyWarned;
  }
}

// 재고 관리
class InventoryManager {
  constructor() {
    this.checkInterval = null;
    this.checkTimeout = null;
  }
  // 아이템 등록
  addItem(item) {
    console.log(`[추가] ${item.type} - ${item.name} (재고: ${item.stock}개)`);
    items[item.name] = item;
  }

  updateStock(name, newStock) {
    if (newStock < 0) {
      console.log(`[업데이트 오류] 재고는 0 이상이어야 합니다.`);
    } else {
      items[name].stock = newStock;
      console.log(`[업데이트] ${name} 재고: ${newStock}개`);
      if (newStock < 5) {
        console.log(`[재고 부족 경고] ${name}: 재고가 5개 미만입니다!`);
        items[name].alreadyWarned = false;
      }
    }
  }

  checkStock() {
    if (this.checkInterval) {
      clearInterval(this.checkInterval);
    }

    if (this.checkTimeout) {
      clearTimeout(this.checkTimeout);
    }

    this.checkInterval = setInterval(() => {
      for (const itemName in items) {
        if (items[itemName].stock < 5 && !items[itemName].alreadyWarned) {
          console.log(
            `[자동 경고] ${items[itemName].name}: 재고가 5개 미만입니다!`
          );
          items[itemName].alreadyWarned = true;
        }
      }
    }, 1000);

    this.checkTimeout = setTimeout(() => {
      this.stopItemCheck();
      console.log('[재고 검사 종료]');
    }, 5000);
  }
  stopItemCheck() {
    if (this.checkInterval) {
      clearInterval(this.checkInterval);
      this.checkInterval = null;
    }
  }
}

// 🐾 시스템 사용 예시
const inventory = new InventoryManager();

// 아이템 등록
const item1 = new Item('고급 고양이 사료', '사료', 10);
inventory.addItem(item1);

// 재고 업데이트
inventory.updateStock('고급 고양이 사료', 4); // 5개 미만 → 경고 발생
inventory.updateStock('고급 고양이 사료', -1); // 음수 입력 → 오류 발생

// 재고 상태 검사 시작 (5초 후 종료)
inventory.checkStock();
