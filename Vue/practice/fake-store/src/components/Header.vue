<template>
  <div class="header-container">
    <div class="header-image">
      <div class="header-text">
        <h1 class="header-text-1">Weapon Store</h1>
        <p class="header-text-2">Vue3 연습 사이트</p>
      </div>
    </div>

    <nav
      class="navbar navbar-expand-md bg-dark navbar-dark mt-0"
      style="padding: 8px 8px"
    >
      <span class="navbar-brand">
        <router-link class="nav-link" to="/"
          ><i class="fa-solid fa-house"></i> HOME</router-link
        >
      </span>

      <div :class="navClass">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" to="/womensclothing"
              ><i class="fa-solid fa-gun"></i> Guns</router-link
            >
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/electronics"
              ><i class="fa-solid fa-battery-three-quarters"></i>
              Bullets</router-link
            >
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/jewelery"
              ><i class="fa-solid fa-fire"></i> Grenades
            </router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/mensclothing"
              ><i class="fa-solid fa-car-side"></i> Tanks</router-link
            >
          </li>
        </ul>
      </div>

      <button class="navbar-toggler" type="button" @click="changeIsNavShow">
        <span class="navbar-toggler-icon"></span>
      </button>
    </nav>
  </div>
</template>

<script>
import { reactive, computed } from 'vue';

export default {
  name: 'Header',

  setup() {
    const state = reactive({ isNavNow: false });

    const navClass = computed(() =>
      state.isNavNow
        ? 'collapse navbar-collapse show'
        : 'collapse navbar-collapse'
    );
    const changeIsNavShow = () => {
      state.isNavNow = !state.isNavNow;
    };

    return { state, changeIsNavShow, navClass };
  },
};
</script>

<style>
.header-image {
  width: 100%;
  height: 100%;
  background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
    url('https://www.nam.ac.uk/sites/default/files/styles/slice_lg/public/2019-01/132564_slice.jpg.webp?itok=d7plx3ld');
  background-size: cover;
  background-position: center 30%;
  display: flex;
  align-items: center;
}

.header-text {
  color: white;
  padding: 30px;
}
.header-text-1 {
  font-size: 30pt;
}
.header-text-2 {
  font-size: 15pt;
  font-weight: 300;
}

.header-container {
  width: 100%;
  height: 200px;
  display: flex;
  flex-direction: column;
}
.navbar-nav {
  display: flex;
  flex-direction: row;
  gap: 10px;
  justify-content: start; /* 버튼들을 왼쪽으로 정렬 */
}
</style>
