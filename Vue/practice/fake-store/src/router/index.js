import { createRouter, createWebHistory } from 'vue-router';

import HomePage from '@/pages/Homepage.vue';
import ElectronicsPage from '@/pages/ElectronicsPage.vue';
import JeweleryPage from '@/pages/JeweleryPage.vue';
import MensClothingPage from '@/pages/MensClothingPage.vue';
import WomensClothingPage from '@/pages/WomensClothingPage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    {
      path: '/electronics',
      name: 'electronics',
      component: ElectronicsPage,
    },
    {
      path: '/jewelery',
      name: 'jewelery',
      component: JeweleryPage,
    },
    {
      path: '/mensclothing',
      name: 'mansclothing',
      component: MensClothingPage,
    },
    {
      path: '/womensclothing',
      name: 'womensclothing',
      component: WomensClothingPage,
    },
  ],
});

export default router;
