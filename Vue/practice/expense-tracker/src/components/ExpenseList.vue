<template>
  <div>
    <div v-for="(expense, index) in expenses" :key="index" class="expense-list">
      <span>{{ expense.title }}: {{ expense.price.toLocaleString() }}원</span>
      <button @click="removeExpense(index)" class="delete-button">❌</button>
    </div>
  </div>
</template>

<script setup>
defineProps({
  expenses: {
    type: Array,
    required: true,
  },
});

const emit = defineEmits(['remove-expense']);

const removeExpense = (index) => {
  emit('remove-expense', index);
};
</script>

<style>
.delete-button {
  cursor: pointer;
  background: none;
  font-size: 15pt;
}
</style>
