<template>
  <div>
    <!-- 자식에서 보낸 이벤트명과 동일해야 한다. 이벤트핸들러와 연결 -->
    <InputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터 : {{ parentName }}</h3>
  </div>
</template>

<script>
import InputName from './components/InputName.vue';
export default {
  name: 'App',
  components: { InputName },

  data() {
    return {
      parentName: '',
    };
  },

  methods: {
    nameChangedHandler(e) {
      // 자식에게서 받아온 name을 부모 컴포넌트에 출력해줌
      this.parentName = e.name;
      console.log(e.name);
    },
  },
};
</script>
