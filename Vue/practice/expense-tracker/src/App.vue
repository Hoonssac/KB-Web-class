<template>
  <div class="app">
    <h1 style="color: #7fffd4">💸 Simple Budget Diary</h1>
    <ExpenseForm @add-expense="handleAddExpense" />
    <h3 style="margin: 30px 0">🧾 지출 내역</h3>
    <ExpenseList :expenses="expenses" @remove-expense="handleRemoveExpense" />
    <h3 style="margin: 30px 0">📊 카테고리별 지출 합계</h3>
    <TotalDisplay
      :totalExpense="totalExpense"
      :categoryTotals="categoryTotals"
    />
  </div>
</template>

<script>
import { ref, computed } from 'vue'; // computed를 추가로 import
import ExpenseForm from './components/ExpenseForm.vue';
import TotalDisplay from './components/TotalDisplay.vue';
import ExpenseList from './components/ExpenseList.vue';

export default {
  name: 'App',
  components: { ExpenseForm, TotalDisplay, ExpenseList },

  setup() {
    const expenses = ref([]);
    const totalExpense = ref(0);

    const handleAddExpense = (expense) => {
      expenses.value.push(expense);
      totalExpense.value += expense.price;
    };

    const handleRemoveExpense = (index) => {
      totalExpense.value -= expenses.value[index].price;
      expenses.value.splice(index, 1);
    };

    const categoryTotals = computed(() => {
      const totals = {};
      expenses.value.forEach((expense) => {
        if (!totals[expense.category]) {
          totals[expense.category] = 0;
        }
        totals[expense.category] += expense.price;
      });
      return totals;
    });

    return {
      expenses,
      handleAddExpense,
      totalExpense,
      handleRemoveExpense,
      categoryTotals,
    };
  },
};
</script>

<style>
.app {
  background-color: #1e1e1e;
  color: #f0f0f0;
  padding: 30px;
  font-family: 'Segoe UI', sans-serif;
  max-width: 600px;
  margin: 50px auto;
  border-radius: 16px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.3);
}

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

h3 {
  color: #c8ffed;
}

.expense-list {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #363636;
  padding: 10px;
  margin: 8px 0;
  border-radius: 8px;
}
</style>
