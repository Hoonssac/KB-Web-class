function processOrder(menu, quantity) {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(`🍴${menu} ${quantity}인분 주문 처리 완료!`);
    }, 1000);
  });
}

export { processOrder };
