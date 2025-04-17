<template>
  <div class="input-box">
    <input
      class="input-item"
      type="text"
      v-model="title"
      placeholder="항목명 입력"
    />
    <input
      class="input-item"
      type="number"
      v-model.number="price"
      placeholder="금액 입력"
    />
    <select class="input-item" v-model="category">
      <option value="🍽️ 식비">🍽️ 식비</option>
      <option value="🚗 교통">🚗 교통</option>
      <option value="🛍️ 쇼핑">🛍️ 쇼핑</option>
    </select>
    <button @click="addExpense">추가</button>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'ExpenseForm',
  setup(_, { emit }) {
    const title = ref('');
    const price = ref(0);
    const category = ref(''); // 기본값 설정

    const addExpense = () => {
      if (title.value && price.value) {
        emit('add-expense', {
          title: title.value,
          price: price.value,
          category: category.value, // 카테고리 포함
        });
        title.value = '';
        price.value = 0;
        category.value = ''; // 기본값으로 초기화
      }
    };

    return { title, price, category, addExpense };
  },
};
</script>

<style>
.input-box {
  display: flex;
  gap: 10px;
  justify-content: center;
}

.input-item {
  flex-grow: 1;
  background-color: #363636;
  border: none;
  color: white;
  padding: 5px;
  border: solid 0.5px rgb(148, 148, 148);
  border-radius: 5px;
}

button {
  background-color: #7fffd4;
  width: 50px;
  height: 30px;
  border: none;
  border-radius: 5px;
  font-weight: 700;
}
</style>
