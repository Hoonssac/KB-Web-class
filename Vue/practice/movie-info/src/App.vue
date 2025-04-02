<template>
  <div class="container mt-5">
    <h1>영화 정보</h1>
    <div class="column mt-3">
      <div v-for="movie in movies" :key="movie.id" class="col-md-12 mb-4">
        <div class="card d-flex flex-row">
          <div class="image-container">
            <img :src="movie.imgUrl" :alt="movie.title" />
          </div>
          <div class="card-body">
            <h3 class="card-title">{{ movie.title }}</h3>
            <p class="card-text">개봉: {{ movie.year }}</p>
            <p class="card-text">장르: {{ movie.category }}</p>
            <button @:click="increaseLike(movie.id)" class="btn btn-secondary">
              좋아요
            </button>
            <span style="margin-left: 10px">{{ movie.like }}</span> <br />
            <button
              style="margin-top: 10px"
              @click="toggleDetail(movie.id)"
              class="btn btn-secondary"
            >
              {{ movie.showDetail ? '닫기' : '상세보기' }}
            </button>
            <p v-if="movie.showDetail" class="mt-3">
              {{ movie.detail }}
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// 좋아요 증가 함수
const increaseLike = (id) => {
  const movie = movies.value.find((movie) => movie.id === id); // id로 영화 찾기
  if (movie) {
    movie.like += 1;
  }
};

const toggleDetail = (id) => {
  const movie = movies.value.find((movie) => movie.id === id);
  if (movie) {
    movie.showDetail = !movie.showDetail;
  }
};

// 영화 데이터
const movies = ref([
  {
    id: 1,
    title: '노량',
    year: 2023,
    category: '액션, 드라마',
    textRed: 'color: red',
    like: 0,
    imgUrl: './src/assets/노량.webp',
    detail:
      '임진왜란 발발로부터 7년이 지난 1598년 12월. 이순신(김윤석)은 왜군의 수장이던 도요토미 히데요시가 갑작스럽게 사망한 뒤 왜군들이 조선에서 황급히 퇴각하려 한다는 것을 알게 된다. “절대 이렇게 전쟁을 끝내서는 안 된다” 왜군을 완벽하게 섬멸하는 것이 이 전쟁을 올바르게 끝나는 것이라 생각한 이순신은 명나라와 조명연합함대를 꾸려 왜군의 퇴각로를 막고 적들을 섬멸하기로 결심한다. 하지만 왜군의 뇌물 공세에 넘어간 명나라 도독 진린(정재영)은 왜군에게 퇴로를 열어주려 하고, 설상가상으로 왜군 수장인 시마즈(백윤식)의 살마군까지 왜군의 퇴각을 돕기 위해 노량으로 향하는데...',
    showDetail: false,
  },
  {
    id: 2,
    title: '아쿠아맨과 로스트 킹덤',
    year: 2023,
    category: '액션, 판타지, 어드벤쳐',
    like: 0,
    imgUrl: './src/assets/아쿠아맨.webp',
    detail:
      '아틀란티스 왕국을 이끌 왕의 자리에 오른 ‘아쿠아맨’. 그 앞에 ‘블랙 만타’가 세상을 뒤흔들 강력한 지배 아이템 ‘블랙 트라이던트’를 손에 넣게 된다. 그동안 겪지 못 했던 최악의 위협 속 ‘아쿠아맨’은 ‘블랙 만타’와 손을 잡았던 이부 동생 ‘옴’ 없이는 절대적 힘이 부족한 상황. 바다를 지배할 슈퍼 히어로가 세상의 판도를 바꾼다!',
    showDetail: false,
  },
  {
    id: 3,
    title: '3일의 휴가',
    year: 2023,
    category: '판타지, 드라마',
    like: 0,
    imgUrl: './src/assets/3일의 휴가.webp',
    detail:
      '“따님은 어머님을 보거나 목소리를 들을 수 없고요. 휴가 동안 좋은 기억만 담고 오시면 됩니다.” 죽은 지 3년째 되는 날, ‘복자’(김해숙)는 하늘에서 3일간의 휴가를 받아 규칙 안내를 맡은 신입 ‘가이드’(강기영)와 함께 지상에 내려온다. 미국 명문 대학교 교수인 자랑스러운 딸을 볼 생각에 설레던 마음도 잠시, 돌연 자신이 살던 시골집으로 돌아와 백반 장사를 시작한 ‘진주’(신민아)의 모습에 당황한다. 속 타는 엄마의 마음도 모르는 ‘진주’는 자신을 찾아온 단짝 ‘미진’(황보라)과 엄마의 레시피를 찾아가고, 낯익은 요리를 보자 서로의 추억이 되살아나는데…',
    showDetail: false,
  },
]);
</script>

<style>
body {
  width: 800px;
  display: flex;
  flex-direction: column;
  margin: 0 auto;
}
.card {
  padding: 15px;
}
img {
  width: 200px;
}
</style>
