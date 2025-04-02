<template>
  <div>
    <h1>영화 상세 정보</h1>
    <!-- <img :src="movie.poster" /> -->
    <p>{{ movie.title }}</p>
    <p>{{ movie.year }}</p>
    <p>{{ movie.director }}</p>
    <p>{{ movie.description }}</p>
    <router-link to="/">← 영화 목록으로 돌아가기</router-link>
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
