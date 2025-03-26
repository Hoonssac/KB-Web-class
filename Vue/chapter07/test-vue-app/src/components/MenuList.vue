<template>
  <button :class="{ selected: isSelected }" @click="handleClick">
    {{ name }} ({{ price }}원)
  </button>
</template>

<script>
export default {
  name: 'MenuList',
  props: ['name', 'price', 'isSelected'],

  methods: {
    handleClick() {
      this.$emit('select-drink', this.name);
      console.log(this.name);
    },
  },
};
</script>

<style>
button {
  padding: 10px 15px;
  margin: 0 5px;
  font-size: 15px;
  border-radius: 5px;
  border: solid black 1px;
}

button.selected {
  border-color: rgb(59, 144, 255);
}
</style>
