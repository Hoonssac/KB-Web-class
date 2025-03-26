<template>
  <div class="line-card">
    <p class="line" v-if="randomLine">"{{ randomLine.line}}"</p>
    <p v-if="randomLine" style="font-size: 10pt; font-weight: 100; margin-bottom: 15px">출처 : {{randomLine.source}}</p>
    <p v-else style="font-size: 20px; font-weight: 400; margin-bottom: 10px">"🎭 아직 대사가 없습니다. 버튼을 눌러주세요!""</p>
    <button class="randomButton" @click="pickRandomLine">🎲 랜덤 대사 뽑기</button>
    <p style="font-weight: 150">✨ 오늘의 즉흥 대사입니다!</p>
    <p class="tip-box">🎯 TIP: 표정 풍부하게, 발음 또박또박!</p>
    <img
      src="https://t2.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/2icR/image/15tu_vXeHUGpF1PJtHVs0fVjojo.jpg"
    ></img>
    <p v-if="randomLine && randomLine.line.length >= 40" style="font-weight: 301; font-size: 11pt; margin-top: 20px">📏 대사가 길어요! 천천히 연기해 보세요.</p>
  </div>
</template>

<script>
export default {
  name: 'LineCard',
  inject: ['lines'],
  data() {
    return {
        randomLine: null,
    }
  },

  methods: {
    pickRandomLine() {
      const randomIndex = Math.floor(Math.random() * this.lines.length);
      this.randomLine = this.lines[randomIndex];
      console.log(this.randomLine);
    },
  }
};
</script>

<style>
.line-card {
 display: flex;
 flex-direction: column;
 align-items: center;
 text-align: center;
  border: 2px solid lightgray;
  background-color: #f1f2f9;
  margin: 10px auto;
  padding: 25px;
  border-radius: 10px;
width: 400px;
}
p {
    margin: 0;
}

.randomButton {
    border: none;
    background-color: #7CABF9;
    color: white;
    font-weight: 301;
    padding: 10px;
    width: 130px;
    border-radius: 10px;
    margin-bottom: 20px;
    transition: 0.3s;
}
.randomButton:hover {
    border: solid blue 1px;
}

img {
  width: 250px;
}
.line {
    text-align: center; font-size: 14pt;
    margin-bottom: 10px;
}

.tip-box {
    margin: 15px 0;
    background-color: #BBDEFD;
    padding: 10px;
    width: 350px;
    border-radius: 10px;
    font-weight: 301
}
</style>
