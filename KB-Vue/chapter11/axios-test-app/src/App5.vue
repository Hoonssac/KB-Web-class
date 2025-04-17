<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// post : 데이터를 생성할 때 사용, url/data/config 설정 가능
const requestAPI = async () => {
  const url = '/api/todos';
  try {
    const response = await axios.get(url, { timeout: 900 });
    console.log('# 응답 객체 : ', response);
  } catch (e) {
    console.log('### 다음 오류가 발생했습니다.');
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};

requestAPI();
</script>
