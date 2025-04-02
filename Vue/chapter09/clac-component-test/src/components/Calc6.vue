<template>
  <div>
    x : <input type="text" v-model.number="state.x" />
    <br />
    결과 : {{ state.result }}
  </div>
</template>

<script>
import { relative, watch } from 'vue';

export default {
  name: Calc6,
  setup() {
    const state = relative({ x: 0, result: 0 });
    watch(
      () => state.x,
      (current, old) => {
        console.log(`${old} -> ${current}`);
        state.result = current * 2;
      }
    );
    return { state };
  },
};
</script>
