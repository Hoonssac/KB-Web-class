<template>
  <div>
    <h1>영화 상세 정보</h1>
    <!-- 데이터가 로드되었을 때만 렌더링 -->
    <div v-if="movie">
      <h1>{{ movie.title }} ({{ movie.year }})</h1>
      <h2>감독: {{ movie.director }}</h2>
      <h2>줄거리: {{ movie.description }}</h2>
      <img :src="movie.poster" />
    </div>
    <!-- 로딩 중 메시지 -->
    <div v-else>
      <p>로딩 중...</p>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute(); // 현재 라우트 정보 가져오기
const movie = ref(null); // 영화 데이터를 저장할 변수

// 영화 데이터를 가져오는 함수
const fetchMovie = async () => {
  try {
    const response = await axios.get(
      `http://localhost:3000/movies/${route.params.id}`
    );
    movie.value = response.data; // 영화 데이터를 저장
  } catch (error) {
    console.error('영화 데이터를 가져오는 중 오류 발생:', error);
  }
};

// 컴포넌트가 마운트될 때 fetchMovie 호출
onMounted(fetchMovie);
</script>

<style>
img {
  width: 35rem;
}
</style>
