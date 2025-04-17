<template>
  <div class="button-container">
    <button @click="handleClick" class="readyButton">🎬 대사 준비 완료!</button>
    <p>버튼을 누른 횟수: {{ clickCount }}회</p>
    <p class="comment">
      <slot><em>🎭 준비되면 눌러주세요! 자신감을 가져요!</em></slot>
    </p>
  </div>
</template>

<script>
export default {
  name: 'LineReadyButton',
  data() {
    return {
      clickCount: 0,
    };
  },
  methods: {
    handleClick() {
      this.clickCount++;
      this.$emit('ready', `대사 준비 완료! 총(${this.clickCount}회 눌림)`);
    },
  },
};
</script>

<style>
.button-container {
  display: flex; /* Flexbox 활성화 */
  flex-direction: column; /* 요소들을 세로로 정렬 */
  align-items: center; /* 수평 가운데 정렬 */
  justify-content: center; /* 수직 가운데 정렬 */
  text-align: center; /* 텍스트 가운데 정렬 */
  width: 100%; /* 부모 요소의 너비에 맞춤 */
}

.readyButton {
  padding: 10px 20px;
  font-size: 16px;
  color: white;
  border-radius: 12px;
  border: none;
  cursor: pointer;
  background-color: #ff7675;
  margin-bottom: 10px; /* 버튼과 텍스트 사이 간격 */
  transition: 0.3s;
}

.readyButton:hover {
  background-color: #d63031;
}

.comment {
  background-color: #f1f2f6;
  padding: 14px;
  border: 1px solid #dfe4ea;
  border-radius: 10px;
  max-width: 400px;
  margin: 20px 0;
  width: 400px;
  font-weight: 400;
}
</style>
