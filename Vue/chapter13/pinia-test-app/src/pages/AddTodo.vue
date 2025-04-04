<template>
  <div class="row">
    <div class="col">
      <h2>할일 추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할일 :</label>
        <input
          type="text"
          id="todo"
          class="form-control"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명 :</label>
        <textarea
          class="form-control"
          rows="3"
          id="desc"
          v-model="todoItem.desc"
        ></textarea>
      </div>
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="addTodoHandler"
        >
          추 가
        </button>
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취 소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, reactive } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const { addTodo } = inject('actions');
const todoItem = reactive({ todo: '', desc: '' });

const addTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    // todo의 유효성 검사
    alert('할일은 반드시 입력해야 합니다.');
    return;
  }
  addTodo({ ...todoItem }, () => {
    // 리스트의 마지막에 할일 추가
    router.push('/todos'); // 할일 목록 페이지로 이동
  });
};
</script>
