<template>
  <div>
    X : <input type="text" v-model.number="x" /> <br />
    Y : <input type="text" v-model.number="y" /><br />
    <button @click="calcAdd">계산</button><br />
    <div>결과 : {{ result }}</div>
  </div>
</template>
<script>
import { ref } from 'vue';

export default {
  name: 'Calc',
  setup() {
    const x = ref(10);
    const y = ref(20);
    const result = ref(30);
    const calcAdd = () => {
      // script 내부에서 ref값에 접근할때는 .value를 사용한다
      result.value = x.value + y.value;
    };
    return { x, y, result, calcAdd };
  },
};
</script>
