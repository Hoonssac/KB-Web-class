import {
  createRouter,
  createWebHistory,
  isNavigationFailure,
} from 'vue-router';
import About from '@/pages/About.vue';
import Home from '@/pages/Home.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import MemberInfo from '@/pages/MemberInfo.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 해당 path로 접근 시 해당 컴포넌트 렌더링
    {
      path: '/',
      component: {
        default: Home,
        left: HomeLeft,
      },
    },
    {
      path: '/about',
      name: 'about',
      component: About,
    },
    {
      path: '/members',
      component: {
        default: Members,
        left: MemberLeft,
        footer: MembersFooter,
      },
    },
    {
      path: '/videos',
      name: 'video',
      component: Videos,
    },
    {
      path: '/members/id',
      name: 'members/id',
      component: MemberInfo,
      beforeEnter: membersIdGuard,
    },
    {
      path: '/songs',
      name: 'videos',
      component: Videos,
      children: [{ path: ':id', name: 'videos/id', component: VideoPlayer }],
    },
    {
      path: '/videos',
      name: 'videos',
      component: Videos,
      children: [{ path: ':id', name: 'videos/id', component: VideoPlayer }],
    },
  ],
});

const membersIdGuard = (to, from) => {
  if (from.name !== 'members' && from.name !== 'members/id') {
    return false;
  }
};

router.beforeEach((to) => {
  if (to.query && Object.keys(to.query).length > 0) {
    return {
      path: to.path,
      query: {},
      params: to.params,
    };
  }
});

router.afterEach((to, from, failure) => {
  if (isNavigationFailure(failure)) {
    console.log('@@ 내비게이션 중단 : ', failure);
    return { name: 'home' };
  }
});

export default router;
