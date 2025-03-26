<template>
  <div>
    <h3>당신이 경험한 프론트엔드 기술은? (두번째: Slot 기본)</h3>
    <CheckBox3
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @check-changed="CheckBoxChanged"
    >
      <template>
        <i v-if="item.checked" class="far fa-grin-beam"></i>
        <i v-else class="far fa-grin"></i>
      </template>
      <template v-slot:label>
        <span
          v-if="item.checked"
          style="color: blue; text-decoration: underline"
        >
          <i> {{ item.label }}</i>
        </span>

        <span v-else style="color: gray">{{ p2.label }}</span>
      </template>
    </CheckBox3>
  </div>
</template>

<script>
import CheckBox2 from './CheckBox3.vue';

export default {
  name: 'SlotTest',
  components: { CheckBox3 },
  data() {
    return {
      items: [
        { id: 'V', checked: true, label: 'Vue' },
        { id: 'A', checked: false, label: 'Angular' },
        { id: 'R', checked: false, label: 'React' },
        { id: 'S', checked: false, label: 'Svelte' },
      ],
    };
  },

  methods: {
    CheckBoxChanged(e) {
      // 받아온 객체의 id를 items 배열에서 찾아서 일치하는 객체 반환
      let item = this.items.find((item) => item.id === e.id);
      // 찾은 객체의 checked를 받아온 값으로 변경
      item.checked = e.checked;
    },
  },
};
</script>
<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css');
</style>
