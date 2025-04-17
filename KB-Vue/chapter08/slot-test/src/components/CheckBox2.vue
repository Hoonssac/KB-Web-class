<template>
  <div>
    <!-- id, checked는 부모에게서 받아온 props -->
    <!-- input이 변경될 때 check-changed라는 이벤트에 id와 현재 input 체크 여부를 담아서 부모에게 전송 -->
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- 부모가 넘겨준 템플릿이 없다면 기본 텍스트인 item이 출력 -->
    <slot>Item</slot>
  </div>
</template>

<script>
export default {
  name: 'CheckBox1',
  props: ['id', 'checked', 'label'],
};
</script>
