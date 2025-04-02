<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />

        <TodoList
          :todoList="state.todolist"
          @delete-todo="deleteTodo"
          @toggle-completed="toggleCompleted"
        />
      </div>
    </div>
  </div>
</template>
<script setup>
import { reactive, onMounted } from 'vue';
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';

const ts = new Date().getTime();
// todoList에 바로 교체를 하면 반응성을 잃기 때문에 state 안에 객체로 todoList를 배치함
const state = reactive({ todolist: [] });

onMounted(() => {
  state.todolist.push({ id: ts, todo: '자전거 타기', completed: false });
  state.todolist.push({
    id: ts + 1,
    todo: '딸과 공원 산책',
    completed: true,
  });
  state.todolist.push({
    id: ts + 2,
    todo: '일요일 애견 카페',
    completed: false,
  });
  state.todolist.push({
    id: ts + 3,
    todo: 'Vue 원고 집필',
    completed: false,
  });
});

const addTodo = (todo) => {
  if (todo.length >= 2) {
    // 사용자가 입력한 할일이 2글자 이상인 경우 todolist에 추가
    state.todolist.push({
      id: new Date().getTime(),
      todo: todo,
      completed: false,
    });
  }
};

const deleteTodo = (id) => {
  // 삭제할 todo가 todolist에서 몇번째 인덱스인지 id를 통해 검색
  let index = state.todolist.findIndex((item) => id === item.id);
  // index 위치부터 한개의 todo를 삭제
  state.todolist.splice(index, 1);
};

const toggleCompleted = (id) => {
  // 완료시킬 todo가 todolist에서 몇번째 인덱스인지 id를 통해 검색
  let index = state.todolist.findIndex((item) => id === item.id);
  // 클릭한 todo의 완료 여부를 반대로 변경
  state.todolist[index].completed = !state.todolist[index].completed;
};
</script>
