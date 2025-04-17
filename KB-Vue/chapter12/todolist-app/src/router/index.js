import { createRouter, createWebHistory } from 'vue-router';
import About from '@/pages/About.vue';
import Home from '@/pages/Home.vue';
import TodoList from '@/pages/TodoList.vue';
import AddTodo from '@/pages/AddTodo.vue';
import EditTodo from '@/pages/EditTodo.vue';
import NotFound from '@/pages/NotFound.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 해당 path로 접근 시 해당 컴포넌트 렌더링
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      component: About,
    },
    {
      path: '/todos',
      name: 'todos',
      component: TodoList,
    },
    {
      path: '/todos/add',
      name: 'todos/add',
      component: AddTodo,
    },
    {
      path: '/todos/edit/:id',
      name: 'todos/edit/id',
      component: EditTodo,
    },
    {
      path: '/:pathMatch(.*)*', // 위에서 매칭되지 않은 나머지 경로
      name: 'NotFound',
      component: NotFound,
    },
  ],
});

// router.beforeEach((to) => {
//   if (to.query && Object.keys(to.query).length > 0) {
//     return {
//       path: to.path,
//       query: {},
//       params: to.params,
//     };
//   }
// });

// router.afterEach((to, from, failure) => {
//   if (isNavigationFailure(failure)) {
//     console.log('@@ 내비게이션 중단 : ', failure);
//     return { name: 'home' };
//   }
// });

export default router;
