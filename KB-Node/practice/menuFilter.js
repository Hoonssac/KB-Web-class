export function filterMenuByPrice(menu, maxPrice) {
  return new Promise((resolve) => {
    setTimeout(() => {
      const filteredMenu = menu.filter((item) => item.price <= maxPrice);
      resolve(filteredMenu);
    }, 1000);
  });
}
