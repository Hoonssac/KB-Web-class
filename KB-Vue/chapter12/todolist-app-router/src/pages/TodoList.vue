<template>
  <h1>TodoList</h1>
  <div class="row">
    <div class="col p-3">
      <ul class="list-group">
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
  </div>
</template>

<script setup>
import { inject, onMounted } from 'vue';
import TodoItem from '@/components/TodoItem.vue';

const todoList = inject('todoList');

onMounted(() => {
  console.log(todoList.value);
});
</script>
