<template>
  <div class="quiz-card">
    <!-- 제목 슬롯 -->
    <slot name="title">
      <h2>🎯 드라마 대사 퀴즈</h2>
    </slot>

    <!-- 문제 대사 -->
    <p class="question" v-if="currentQuestion">"{{ currentQuestion.line }}"</p>

    <!-- 보기 -->
    <ul class="options" v-if="currentQuestion">
      <li
        v-for="(option, index) in options"
        :key="index"
        @click="checkAnswer(option)"
        :class="{ selected: selectedOption === option }"
      >
        {{ option }}
      </li>
    </ul>

    <!-- 정답/오답 메시지 -->
    <div v-if="resultMessage" class="result">
      <slot name="correct" v-if="isCorrect"> 정답입니다! </slot>
      <slot name="wrong" v-else>
        아쉽네요! 정답은 "{{ currentQuestion.source }}" 입니다.
      </slot>
    </div>

    <!-- 힌트 슬롯 -->
    <slot name="hint">
      <p class="hint">모두 유명 드라마입니다!</p>
    </slot>

    <!-- 다음 문제 버튼 -->
    <button v-if="resultMessage" @click="nextQuestion">다음 문제 풀기</button>
  </div>
</template>

<script>
export default {
  name: 'QuizCard',
  props: {
    lines: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {
      currentQuestion: null,
      options: [],
      selectedOption: null,
      resultMessage: null,
      isCorrect: false,
    };
  },
  methods: {
    generateQuestion() {
      // 랜덤 문제 선택
      const randomIndex = Math.floor(Math.random() * this.lines.length);
      this.currentQuestion = this.lines[randomIndex];

      // 보기 생성 (정답 + 랜덤 오답)
      const wrongOptions = this.lines
        .filter((line) => line.source !== this.currentQuestion.source)
        .map((line) => line.source);
      const shuffledOptions = [
        this.currentQuestion.source,
        ...this.shuffleArray(wrongOptions).slice(0, 3),
      ];
      this.options = this.shuffleArray(shuffledOptions);

      // 초기화
      this.selectedOption = null;
      this.resultMessage = null;
      this.isCorrect = false;
    },
    shuffleArray(array) {
      return array.sort(() => Math.random() - 0.5);
    },
    checkAnswer(option) {
      if (this.selectedOption) return; // 이미 선택한 경우 무시
      this.selectedOption = option;
      this.isCorrect = option === this.currentQuestion.source;
      this.resultMessage = true;

      // 선택 내용 로그
      console.log(`선택한 보기: ${option}`);
      console.log(`정답 여부: ${this.isCorrect ? '정답' : '오답'}`);
    },
    nextQuestion() {
      this.generateQuestion();
    },
  },
  mounted() {
    this.generateQuestion();
  },
};
</script>

<style>
.quiz-card {
  border: 2px solid #ccc;
  padding: 20px;
  border-radius: 10px;
  background-color: #f9f9f9;
  text-align: center;
  max-width: 600px;
  margin: 20px auto;
}

.question {
  font-size: 18px;
  margin-bottom: 20px;
}

.options {
  list-style: none;
  padding: 0;
}

.options li {
  margin: 10px 0;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  cursor: pointer;
  background-color: #fff;
  transition: background-color 0.3s;
}

.options li:hover {
  background-color: #f0f0f0;
}

.options li.selected {
  background-color: #d1ffd1;
}

.result {
  margin-top: 20px;
  font-size: 16px;
  font-weight: bold;
}

.hint {
  margin-top: 20px;
  font-size: 14px;
  color: #888;
}
</style>
