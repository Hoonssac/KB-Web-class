<template>
  <div class="container">
    <Header />
    <router-view></router-view>
  </div>
</template>

<script setup>
import Header from '@/components/Header.vue';
import { reactive, computed, provide } from 'vue';

const states = reactive({
  todoList: [
    {
      id: 1,
      todo: 'ES6 학습',
      desc: '설명 1',
      done: false,
    },
    {
      id: 2,
      todo: 'React 학습',
      desc: '설명2',
      done: false,
    },
    {
      id: 3,
      todo: 'Context API 학습',
      desc: '설명3',
      done: true,
    },
    {
      id: 4,
      todo: '야구경기 관람',
      desc: '설명4',
      done: false,
    },
  ],
});

const addTodo = ({ todo, desc }) => {
  states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
};

const deleteTodo = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList.splice(index, 1);
};

const toggleDone = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index].done = !states.todoList[index].done;
};

provide(
  'todoList',
  computed(() => states.todoList)
);

provide('actions', { addTodo, deleteTodo, toggleDone });
</script>
