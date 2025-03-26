import { createApp } from 'vue';
import App from './App.vue';

// 전역 컴포넌트 등록 방법
// 모든 곳에 등록이 됙기 때문에 파일이 커질 수 있다는 단점 -> 비권장
// import CheckboxItem from './components/CheckboxItem.vue';
// createApp(App).component('CheckboxItem', CheckboxItem).mount('#app');

createApp(App).mount('#app');
