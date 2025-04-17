<template>
  <input type="radio" name="selectSize" @click="handleSizeChange" />
  <label for="size">{{ size }}</label>
</template>

<script>
export default {
  name: 'DrinkOptions',
  props: ['size', 'extraShot', 'ice'],

  methods: {
    handleSizeChange() {
      // 사이즈만 변경하고 다른 옵션은 그대로 유지
      this.$emit('options-changed', {
        size: this.size,
        extraShot: this.$parent.selectedOptions.extraShot, // 부모의 현재 extraShot 값 사용
        ice: this.$parent.selectedOptions.ice, // 부모의 현재 ice 값 사용
      });
    },
  },
};
</script>
