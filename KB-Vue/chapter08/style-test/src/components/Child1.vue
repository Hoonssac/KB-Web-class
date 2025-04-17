<template>
  <div class="child">
    <h2>Child1</h2>
  </div>
</template>

<script>
export default {
  name: 'Child1',
};
</script>

<!-- scoped를 붙이면 해당 컴포넌트 내에서만 스타일 적용 -->
<style scoped>
.child {
  background-color: yellow;
  border: solid 1px black;
  margin: 1.5rem;
  padding: 1em;
}
</style>
