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
      desc: '설명1',
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

const updateTodo = ({ id, todo, desc, done }) => {
  // 사용자에게 받아온 ㅑd와 일치하는 객체의 인덱스 찾기
  let index = states.todoList.findIndex((todo) => todo.id === id);
  // 전개 연산자로 기존 값 복사 후 받아온 값 추가
  states.todoList[index] = { ...states.todoList[index], todo, desc, done };
};

const deleteTodo = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  // index 위치부터 한 개의 todo를 삭제
  states.todoList.splice(index, 1);
};

const toggleDone = (id) => {
  // 완료시킬 todo가 todoList에서 몇 번째 인덱스인지 id를 통해 검색
  let index = states.todoList.findIndex((todo) => todo.id === id);
  // 클릭한 todo의 완료 여부를 반대로 변경
  states.todoList[index].done = !states.todoList[index].done;
};

provide(
  'todoList',
  computed(() => states.todoList)
);

provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo });
</script>
