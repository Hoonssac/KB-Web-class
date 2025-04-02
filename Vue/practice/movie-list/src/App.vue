<template>
  <div>
    <h1>📽️ 지브리 영화 리스트</h1>
    <router-view />
    <!-- 현재 라우트에 따라 컴포넌트를 렌더링 -->
  </div>
</template>

<script setup>
/**
 * 필요한 모듈 및 컴포넌트 import
 * - axios: HTTP 요청을 처리하기 위한 라이브러리
 * - ref: Vue 3의 반응형 데이터 선언을 위한 Composition API
 * - onMounted: 컴포넌트가 마운트될 때 실행할 로직 정의
 * - provide: 데이터를 하위 컴포넌트에 전달하기 위한 Vue 3 API
 */
import axios from 'axios';
import { ref, onMounted, provide } from 'vue';

// 영화 데이터를 가져올 API URL
const listUrl = 'http://localhost:3000/movies';

// 반응형으로 관리될 영화 목록 데이터 선언
const movieList = ref([]);

/**
 * fetchMovies 함수
 * - 비동기로 영화 데이터를 API에서 가져와 movieList에 저장
 */
const fetchMovies = async () => {
  const response = await axios.get(listUrl);
  movieList.value = response.data;
};

// 컴포넌트가 마운트될 때 fetchMovies 함수 실행
onMounted(fetchMovies);

// movieList 데이터를 하위 컴포넌트에서 사용할 수 있도록 provide로 전달
provide('movieList', movieList);
</script>
