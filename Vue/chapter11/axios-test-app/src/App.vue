<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = () => {
  let todoList = [];
  axios
    .get(listUrl)
    .then((response) => {
      // 전체 TodoList 출력
      todoList = response.data;
      console.log('# TodoList : ', todoList);
      return todoList[0].id;
    })
    .then((id) => {
      return axios.get(todoUrlPrefix + id);
    })
    .then((response) => {
      // 가져온 첫번째 Todo 출력하고 두번째 Todo 아이디 리턴
      console.log('## 첫번째 Todo : ', response.data);
      return todoList[1].id;
    })
    .then((id) => {
      // 두번째 Todo 가져와서 출력
      axios.get(todoUrlPrefix + id).then((response) => {
        console.log('## 두번째 Todo : ', response.data);
      });
    });
};

// const requestAPI = () => {
//   // const url = 'http://localhost:3000/todos/1';
//   const url = 'api/todos/1';
//   // 해당 url로 get 메소드 보낸 후 응답 데이터 출력
//   axios.get(url).then((response) => {
//     console.log('#응답객체 : ', response);
//   });
// };

requestAPI();
</script>
