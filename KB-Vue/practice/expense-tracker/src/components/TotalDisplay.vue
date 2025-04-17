<template>
  <p
    class="category-list"
    style="margin: "
    v-for="(total, category) in categoryTotals"
    :key="category"
  >
    {{ category }}: {{ total.toLocaleString() }}원
  </p>
  <div class="total-display">
    <h3 style="margin: 0">🧮 총 지출: {{ totalExpense.toLocaleString() }}원</h3>
  </div>
</template>

<script setup>
defineProps({
  totalExpense: {
    type: Number,
    required: true,
  },
  categoryTotals: {
    type: Object,
    required: true,
  },
});
</script>

<style>
.total-display {
  text-align: center;
  color: #c8ffed;
  font-size: 18px;
  background-color: #656565;
  border-radius: 8px;
  padding: 15px;
}

.category-list {
  margin-top: 10px;
  list-style: none;
  padding: 10px;
  text-align: left;
  border-radius: 8px;
  background-color: #383838;
}
</style>
