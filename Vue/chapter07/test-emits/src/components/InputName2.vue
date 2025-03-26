<template>
  <div style="border: solid 1x gray; padding: 5px">
    이름 : <input type="text v-model=name" />
    <!-- nameChanged라는 이벤트명으로 name을 객체로 감싸서 부모 컴포넌트로 전달 -->
    <!-- emit : 자식이 부모에게 이벤트 전달 -->
    <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
  </div>
</template>

<script>
export default {
  name: 'InputName',
  emits: ['nameChanged1'],
  data() {
    return { name: '' };
  },
};
</script>
