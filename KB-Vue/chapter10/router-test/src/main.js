import { createApp } from 'vue';
import 'bootstrap/dist/css/bootstrap.css';
import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(router); // 라우터를 app에 연결

app.mount('#app');
