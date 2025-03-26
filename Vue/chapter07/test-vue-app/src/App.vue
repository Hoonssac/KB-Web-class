<template>
  <div class="container">
    <h1>카페 주문 앱</h1>
    <h2 style="font-weight: 350; margin: 10px auto">메뉴 선택</h2>
    <div class="menuList">
      <MenuList
        v-for="menu in menuList"
        :key="menu.name"
        :name="menu.name"
        :price="menu.price"
        :is-selected="menu.name === selectedDrink"
        @select-drink="selectHandler"
        class="menuList"
      />
    </div>

    <br />
    <div v-if="selectedDrink" class="menuBox">
      <h3 class="selectBox">선택한 음료 : {{ selectedDrink }}</h3>

      <div
        class="optionBox"
        style="
          border: solid black 1px;
          margin: 20px 0;
          background-color: skyblue;
        "
      >
        <h2 style="font-weight: 500; margin: 10px 0">
          {{ selectedDrink }} 옵션 선택
        </h2>
        <p style="margin-top: 10; margin-bottom: 0">사이즈:</p>
        <DrinkOptions
          v-for="size in sizeList"
          :key="size.id"
          :size="size.size"
          :extraShot="isShotAdded"
          :ice="selectedOptions.ice"
          @options-changed="handleOptionsChanged"
        />

        <div class="shotOption" style="margin: 10px 0">
          <input
            type="checkbox"
            id="addShot"
            v-model="isShotAdded"
            @change="updateShotOption"
          />
          <label for="addShot">샷 추가</label>
        </div>

        <div class="iceOption">
          얼음:
          <select v-model="selectedOptions.ice" @change="updateIceOption">
            <option value="적게">적게</option>
            <option value="보통">보통</option>
            <option value="많이">많이</option>
          </select>
        </div>
      </div>

      <div
        class="resultBox"
        style="
          border: solid black 1px;
          padding: 10px;
          background-color: lightgrey;
        "
      >
        <h3 style="font-weight: 500">현재 선택 옵션</h3>
        <p>사이즈: {{ selectedOptions.size }}</p>
        <p>샷 추가: {{ selectedOptions.extraShot ? '추가됨' : '없음' }}</p>
        <p>얼음 양: {{ selectedOptions.ice }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import MenuList from './components/MenuList.vue';
import DrinkOptions from './components/DrinkOptions.vue';

export default {
  name: 'App',
  components: { MenuList, DrinkOptions },

  data() {
    return {
      menuList: [
        { name: '아메리카노', price: 4000 },
        { name: '카페라떼', price: 4500 },
        { name: '바닐라라떼', price: 4800 },
        { name: '콜드브루', price: 5000 },
        // { name: '밀크티(고은 스페샬 메뉴)', price: 300 },
      ],
      selectedDrink: '',
      selectedSize: '',
      isShotAdded: false,
      sizeList: [
        { id: 1, size: 'Small' },
        { id: 2, size: 'Medium' },
        { id: 3, size: 'Large' },
      ],

      selectedOptions: {
        size: '',
        extraShot: false,
        ice: '보통',
      },
    };
  },

  methods: {
    selectHandler(e) {
      this.selectedDrink = e;
      console.log(e);
    },
    sizeHandler(size) {
      this.selectedSize = size;
    },

    handleOptionsChanged(options) {
      // options 객체를 업데이트
      this.selectedOptions = options;
      console.log('옵션 변경:', options);
    },
    updateShotOption() {
      // 기존 사이즈 정보를 유지하면서 샷 옵션만 업데이트
      this.selectedOptions = {
        ...this.selectedOptions, // 기존 옵션 유지
        extraShot: this.isShotAdded,
      };
      console.log('샷 옵션 변경:', this.isShotAdded);
    },

    handleOptionsChanged(options) {
      // 사이즈 변경 시 현재 샷 상태 유지
      this.selectedOptions = {
        ...this.selectedOptions, // 기존 옵션 유지
        size: options.size, // 사이즈만 업데이트
      };
      console.log('옵션 변경:', this.selectedOptions);
    },

    updateIceOption() {
      console.log('얼음 옵션 변경:', this.selectedOptions.ice);
    },
  },
  watch: {
    // isShotAdded 값이 변경될 때만 extraShot 업데이트
    isShotAdded(newVal) {
      this.selectedOptions.extraShot = newVal;
    },
  },
};
</script>
<style>
h1 {
  font-weight: 400;
  margin: 0 auto;
}

.container {
  margin: 10px 10px;
}
.selectBox {
  background-color: rgb(227, 227, 227);
  font-weight: 400;
  border: solid black 0.2px;
  border-radius: 5px;
  padding: 10px;
  margin: 0;
}

.menuList {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}
.optionBox {
  padding: 10px;
}
</style>
