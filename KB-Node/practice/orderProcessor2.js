export function calculateTotal(orderList) {
  return orderList.reduce((acc, order) => {
    if (acc[order.menu]) {
      acc[order.menu] += order.quantity;
    } else {
      acc[order.menu] = order.quantity;
    }
    return acc;
  }, {});
}

export function isTopMenu(orders, menu) {
  const totals = calculateTotal(orders);
  const max = Math.max(...Object.values(totals));
  return totals[menu] === max;
}
