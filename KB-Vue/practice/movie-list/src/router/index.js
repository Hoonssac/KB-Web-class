import { createRouter, createWebHistory } from 'vue-router';
import MovieList from '@/components/MovieList.vue';
import MovieDetail from '@/components/MovieDetail.vue';

const routes = [
  {
    path: '/',
    name: 'MovieList',
    component: MovieList,
  },
  {
    path: '/movies/:id',
    name: 'MovieDetail',
    component: MovieDetail,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
