<template>
  <ul>
    <div v-for="movie in movieList" :key="movie.id" class="movie-card">
      <li>
        <!-- router-link를 사용하여 동적 라우트로 이동 -->
        <router-link :to="`/movies/${movie.id}`">
          🎬 {{ movie.title }} - {{ movie.director }}
        </router-link>
      </li>
    </div>
  </ul>
</template>

<script setup>
import { inject } from 'vue';

const movieList = inject('movieList');
</script>
