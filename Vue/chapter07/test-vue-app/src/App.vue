<template>
  <div class="container">
    <h1>카페 주문 앱</h1>
    <h2>메뉴 선택</h2>
    <MenuList
      v-for="menu in menuList"
      :key="menu.name"
      :name="menu.name"
      :price="menu.price"
      :is-selected="menu.name === selectedDrink"
      @select-drink="selectHandler"
    />
    <br />
    <div v-if="selectedDrink">
      <h3 class="selectBox">선택한 음료 : {{ selectedDrink }}</h3>
    </div>
  </div>
</template>

<script>
import MenuList from './components/MenuList.vue';

export default {
  name: 'App',
  components: { MenuList },

  data() {
    return {
      menuList: [
        { name: '아메리카노', price: 4000 },
        { name: '카페라떼', price: 4500 },
        { name: '바닐라라떼', price: 4800 },
        { name: '콜드브루', price: 5000 },
      ],
      selectedDrink: '',
    };
  },

  methods: {
    selectHandler(e) {
      this.selectedDrink = e;
      console.log(e);
    },
  },
};
</script>
<style>
h1 {
  font-weight: 400;
  margin: 0 auto;
}
h2 {
  font-weight: 350;
  margin: 10px auto;
}
.container {
  margin: 30px 30px;
}
.selectBox {
  background-color: rgb(227, 227, 227);
  font-weight: 400;
  border: solid black 0.2px;
  border-radius: 5px;
}
h3 {
  padding: 10px;
}
</style>
