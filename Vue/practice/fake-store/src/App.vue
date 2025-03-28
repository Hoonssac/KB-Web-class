<template>
  <div id="app">
    <Header />
    <router-view class="content"></router-view>
    <Footer />
  </div>
</template>

<script>
import Header from '@/components/Header.vue';
import Footer from './components/Footer.vue';
export default {
  name: 'App',
  components: { Header, Footer },
};
</script>

<style>
#app {
  height: 100vh;
  display: flex;
  flex-direction: column;
}
.page-content {
  margin: 50px 20px;
}
</style>
