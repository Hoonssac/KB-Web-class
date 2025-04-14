<template>
  <div class="modal-overlay">
    <div class="modal">
      <h2 style="color: black">🎬 영화 추가하기</h2>
      <form @submit.prevent="addMovie">
        <input
          v-model="newMovie.title"
          required
          placeholder="제목"
          class="input-box"
        />
        <input
          v-model="newMovie.year"
          type="number"
          required
          class="input-box"
          placeholder="연도"
        />
        <input
          v-model="newMovie.director"
          required
          class="input-box"
          placeholder="감독"
        />
        <textarea
          v-model="newMovie.description"
          required
          class="input-box"
          placeholder="줄거리"
        ></textarea>
        <input
          v-model="newMovie.poster"
          required
          class="input-box"
          placeholder="포스터 이미지 URL"
        />
        <div class="buttons">
          <button type="submit">등록</button>
          <button type="button" @click="closeModal">닫기</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';

// 이벤트 정의
const emit = defineEmits(['movie-added', 'close']);

const newMovie = ref({
  title: '',
  year: '',
  director: '',
  description: '',
  poster: '',
});

// 영화 추가 함수
const addMovie = async () => {
  try {
    await axios.post('http://localhost:3000/movies', newMovie.value);
    emit('movie-added'); // 영화 추가 후 부모 컴포넌트에 알림
    emit('close'); // 모달 닫기
  } catch (error) {
    console.error('영화를 추가하는 중 오류 발생:', error);
  }
};

// 모달 닫기 함수
const closeModal = () => {
  emit('close');
};
</script>

<style>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  background: white;
  padding: 20px;
  border-radius: 8px;
  width: 400px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

form {
  display: flex;
  flex-direction: column;
}

label {
  margin-bottom: 10px;
}

input,
textarea {
  width: 100%;
  padding: 8px;
  margin-top: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 8px 12px;
  background-color: #87fd93;
  border: none;
  font-size: 13pt;
  border-radius: 5px;
  cursor: pointer;
}

.buttons {
  margin: 10px 0;
  display: flex;
  justify-content: space-between;
}

button:hover {
  opacity: 0.9;
}

.input-box {
  margin: 10px 0;
  border: 1px solid black;
}
</style>
