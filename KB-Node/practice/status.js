const orderStatus = {
  samgyeopsal: '주문 대기',
  galbi: '주문 대기',
};

function updateStatus(menu, status) {
  return new Promise((resolve) => {
    setTimeout(() => {
      orderStatus[menu] = status;
      resolve(`🔄 ${menu} 상태가 '${status}'로 변경되었습니다.`);
    }, 1000);
  });
}

export { orderStatus, updateStatus };
