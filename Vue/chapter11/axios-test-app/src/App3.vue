<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// get : 데이터를 가져올 때 사용, url과 config를 지정 가능
const requestAPI = async () => {
  const url = '/api/todos';
  axios.get(url).then((response) => {
    console.log('# 응답객체: ', response);
  });
};

requestAPI();
</script>
