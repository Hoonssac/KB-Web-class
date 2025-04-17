const orderList = [];

const addOrder = (menu, quantity) => {
  let add = {
    menu: menu,
    quantity: quantity,
  };
  orderList.push(add);
};
export { orderList, addOrder };
