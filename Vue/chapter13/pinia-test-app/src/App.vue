<template>
  <div>
    <h2>TodoList 테스트(Composition API )</h2>
    <hr />
    할일 추가 :
    <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
          {{ todoItem.todo }} {{ todoItem.done ? '완료' : '' }}
        </span>
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
  <div class="container">
    <Header />
    <router-view />
  </div>
</template>

<script setup>
import { useTodoListStore } from '../stores/todoList';
import { ref, computed } from 'vue';

const todo = ref('');

const todoListStore = useTodoListStore();

// 필요한 값들만 객체 구조 분해로 스토어에서 꺼낸다.
// const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;
// 기본 타입은 계싼된 속성이라면 다시 computed로 작성해야 한다.
const doneCount = computed(() => todoListStore.doneCount);

const addTodoHandler = () => {
  addTodo(todo.value);
  todo.value = '';
};
</script>
