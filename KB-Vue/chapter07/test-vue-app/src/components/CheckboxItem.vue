<template>
  <li><input type="checkbox" v-model="checked" />옵션 1</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  props: ['name', 'checked'], // 속성명을 배열로 정의
  data() {
    return {
      checked: false,
    };
  },
};
</script>
