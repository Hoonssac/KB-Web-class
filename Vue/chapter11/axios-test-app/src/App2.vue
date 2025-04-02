<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = async () => {
  let todoList;

  // 보통 axios 처리할 때 서버에서 받아오기 위해ㅐ await을 붙인다.
  let response = await axios.get(listUrl);
  todoList = response.data;
  // 리스트의 개별 요소들을 돌면서 하나씩 출력
  console.log('# TodoList : ', todoList);
  for (let i = 0; i < todoList.length; i++) {
    response = await axios.get(todoUrlPrefix + todoList[i].id);
    console.log(`# ${i + 1}번째 Todo : `, response.data);
  }
};

requestAPI();
</script>
