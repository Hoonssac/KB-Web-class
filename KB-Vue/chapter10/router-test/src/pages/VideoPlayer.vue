<script>
import { reactive, ref, inject } from 'vue';
import { useRoute, useRouter, onBeforeRouteUpdate } from 'vue-router';
import { YoutubeVue3 } from 'youtube-vue3';

export default {
  name: 'VideoPlayer',
  components: { YoutubeVue3 },
  setup() {
    const videos = inject('videos');
    const playerRef = ref(null);
    const currentRoute = useRoute();
    const router = useRouter();
    let videoInfo, currentIndex, prevVideoId, nextVideoId;
    videoInfo = reactive({
      video: videos.find((v) => v.id === currentRoute.paramss.id),
    });

    const getNavId = (t0) => {
      videoInfo.video = videos.find((v) => v.id === to.params.id);
      currentIndex = videos.findIndex((v) => v.id === videoInfo.video.id);
      prevVideoId = videos[currentIndex - 1]
        ? videos[currentIndex - 1].id
        : null;
      nextVideoId = videos[currentIndex + 1]
        ? videos[currentIndex + 1].id
        : null;
    };

    getNavId(currentRoute);
    const stopVideo = () => {
      playerRef.value.player.stopVideo();
      router.push({ name: 'videos' });
    };
    const playerNext = () => {
      if (nextVideoId)
        router.push({ name: 'videos/id', params: { id: nextVideoId } });
      else router.push({ name: 'videos/id', params: { id: videos[0].id } });
    };
    const playerPrev = () => {
      if (prevVideoId)
        router.push({ name: 'videos/id', params: { id: prevVideoId } });
    };
    onBeforeRouteUpdate((to) => {
      getNavId(to);
    });
    return { videoInfo, playerRef, playNext, stopVideo, playerPrev };
  },
};
</script>
