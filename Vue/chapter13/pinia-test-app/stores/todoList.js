import { reactive, computed } from 'vue';
import { defineStore } from 'pinia';

export const useTodoListStore = defineStore('todoList', () => {
  // states: 기본적인 데이터 관리 (data에 해당하는 부분)
  const state = reactive({
    todoList: [
      { id: 1, todo: 'ES6 학습', done: false },
      { id: 2, todo: 'React 학습', done: false },
      { id: 3, todo: 'ContextAPI 학습', done: true },
      { id: 4, todo: '야구경기 관람', done: false },
    ],
  });

  // actions: 함수, 비동기 함수도 가능 (methods에 해당하는 부분)
  const addTodo = (todo) => {
    state.todoList.push({ id: new Date().getTime(), todo, done: false });
  };

  const deleteTodo = (id) => {
    const index = state.todoList.findIndex((todo) => todo.id === id);
    if (index !== -1) {
      state.todoList.splice(index, 1);
    }
  };

  const toggleDone = (id) => {
    const index = state.todoList.findIndex((todo) => todo.id === id);
    if (index !== -1) {
      state.todoList[index].done = !state.todoList[index].done;
    }
  };

  // getters: 계산된 속성 (computed에 해당하는 부분)
  const doneCount = computed(() => {
    return state.todoList.filter((todoItem) => todoItem.done === true).length;
  });

  const todoList = computed(() => state.todoList);

  // defineStore 함수 내부에서 반환
  return { todoList, doneCount, addTodo, deleteTodo, toggleDone };
});
