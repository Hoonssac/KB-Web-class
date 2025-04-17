<template>
  <!-- 체크박스의 체크여부 = "부모한테서 받아온 boolean값" -->
  <li><input type="checkbox" v-model="checked" />{{ name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  props: ['name', 'checked'], // 부모 컴포넌트에게서 받아온 속성 배열
  data() {
    return {
      checked: false,
    };
  },
};
</script>
