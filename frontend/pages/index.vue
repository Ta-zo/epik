<template>
  <!-- Main 사진 -->
  <div class="container">
    <div class="photo-slider">
      <div class="photo-slider__container" ref="sliderRef" :style="sliderStyle">
        <div v-for="(slide, index) in slides" :key="index" class="photo-slider__item">
          <!-- <img class="photo-slider__image" :src="slide.image" :alt="`Image ${index + 1}`"> -->
          <img class="photo-slider__image"
            :src="`http://localhost:8081/api/v1/uploads/images/popup/${slide.imgSavedName}`"
            :alt="`Image ${index + 1}`">
          <div class="photo-slider__overlay">
            <div class="photo-slider__tags">
              <span v-for="(tag, tagIndex) in slide.tags" :key="tagIndex" class="photo-slider__tag">{{ tag }}</span>
            </div>
            <a href="#" class="photo-slider__link"><i class="fas fa-arrow-right"></i></a>
            <div class="photo-slider__info">
              <h2 class="photo-slider__title">{{ slide.title }}</h2>
              <p class="popup__date">
                <span>{{ formatDate(slide.startDate) }}</span>
                <span>~</span>
                <span>{{ formatDate(slide.endDate) }}</span>
              </p>
            </div>
          </div>
        </div>
      </div>
      <button class="photo-slider__arrow photo-slider__arrow--left" @click="moveSlider(-1)">&#8592;</button>
      <button class="photo-slider__arrow photo-slider__arrow--right" @click="moveSlider(1)">&#8594;</button>
      <div class="photo-slider__scrollbar" @mousedown="onScrollbarClick">
        <div class="photo-slider__scrollbar-thumb" ref="scrollbarThumbRef" :style="scrollbarThumbStyle"></div>
      </div>
    </div>

    <!-- 팝업 -->
    <div class="popup">
      <h2 class="popup__title">Pop-up</h2>
      <div class="popup__grid">
        <div v-for="(item, index) in popupItems" :key="index" class="popup__item">
          <a href="http://localhost:3001/popup/170"></a>
          <img :src="`http://localhost:8081/api/v1/uploads/images/popup/${item.imgSavedName}`"
            :alt="`Popup ${index + 1}`">
          <div class="popup__info">
            <span class="popup__status">진행중</span>
            <h3>{{ item.title }}</h3>
            <p class="popup__location">{{ item.address }}</p>
            <p class="popup__date-main">
              <span>{{ formatDate(item.startDate) }}</span>
              <span>~</span>
              <span>{{ formatDate(item.endDate) }}</span>
            </p>
          </div>
        </div>
      </div>
    </div>

    <!-- 배너 섹션 -->
    <div class="banner">

      <div class="banner__grid">
        <img src="/images/베너1.png" alt="Banner 1" class="banner__item">
        <a href="http://localhost:3001/popup/159"><img src="/images/베너2.png" alt="Banner 2" class="banner__item"></a>
        <a href="http://localhost:3001/musical/146"><img src="/images/베너3.png" alt="Banner 3" class="banner__item"></a>
        <img src="/images/베너4.png" alt="Banner 4" class="banner__item">
        <img src="/images/베너5.png" alt="Banner 5" class="banner__item">
        <img src="/images/베너6.png" alt="Banner 6" class="banner__item">
      </div>
    </div>


    <!-- 콘서트 -->
    <div class="popup">
      <h2 class="popup__title">Concert</h2>
      <div class="popup__grid">
        <div v-for="(item, index) in concertItems" :key="index" class="popup__item">
          <img :src="`http://localhost:8081/api/v1/uploads/images/concert/${item.fileSavedName}`"
            :alt="`Image ${index + 1}`">
          <div class="popup__info">
            <span class="popup__status">진행중</span>
            <h3>{{ item.title }}</h3>
            <p class="popup__location">{{ item.venue }}</p>
            <p class="popup__date-main">
              <span>{{ formatDate(item.startDate) }}</span>
              <span>~</span>
              <span>{{ formatDate(item.endDate) }}</span>
            </p>
          </div>
        </div>
      </div>
    </div>

    <!-- 뮤지컬 -->
    <div class="popup">
      <h2 class="popup__title">Musical</h2>
      <div class="popup__grid">
        <div v-for="(item, index) in musicalItems" :key="index" class="popup__item">
          <img :src="`http://localhost:8081/api/v1/uploads/images/musical/${item.fileSavedName}`"
            :alt="`Popup ${index + 1}`">
          <div class="popup__info">
            <span class="popup__status">진행중</span>
            <h3>{{ item.title }}</h3>
            <p class="popup__location">{{ item.venue }}</p>
            <p class="popup__date-main">
              <span>{{ formatDate(item.startDate) }}</span>
              <span>~</span>
              <span>{{ formatDate(item.endDate) }}</span>
            </p>
          </div>
        </div>
      </div>
    </div>

    <!-- 영상 섹션 -->
    <div class="video">
    <div class="video__container">
      <button class="video__nav video__nav--left" @click="moveVideoSlider(-1)">&#8249;</button>
      <div class="video__slider" ref="videoSliderRef" :style="videoSliderStyle">
        <div v-for="(embedUrl, index) in embedYoutubeUrls" :key="index" class="video__item">
          <iframe
            :src="embedUrl"
            frameborder="0"
            allowfullscreen
            title="YouTube video player"
          ></iframe>
        </div>
      </div>
      <button class="video__nav video__nav--right" @click="moveVideoSlider(1)">&#8250;</button>
    </div>
  </div>

    <!-- EXHIBITION -->
    <!-- <div class="popup">
      <h2 class="popup__title">Exhibition</h2>
      <div class="popup__grid">
        <div v-for="(item, index) in exhibitionItems" :key="index" class="popup__item">
          <img class="photo-slider__image"
            :src="`http://localhost:8081/api/v1/uploads/images/exhibition/${item.fileSavedName}`"
            :alt="`Image ${index + 1}`">
          <div class="popup__info">
            <span class="popup__status">진행중</span>
            <h3>{{ item.title }}</h3>
            <p class="popup__location">{{ item.venue }}</p>
            <p class="popup__date">
              <span>{{ formatDate(item.startDate) }}</span>
              <span>~</span>
              <span>{{ formatDate(item.endDate) }}</span>
            </p>
          </div>
        </div>
      </div>
    </div> -->
    <!-- <div class="container"> -->
    <div class="popup">
      <h2 class="popup__title">Exhibition</h2>
      <div class="popup__grid">
        <div class="popup__item">
          <img src="/images/툴루즈 로트렉.gif" alt="exhibition 1">
          <div class="popup__info">
            <span class="popup__status">진행중</span>
            <h3>툴루즈 로트렉</h3>
            <p class="popup__location">서울특별시 강남구</p>
            <p class="popup__date-main">24.09.14-03.03</p>
          </div>
        </div>

        <div class="popup__item">
          <img src="/images/르네그뤼오.gif" alt="exhibition 2">
          <div class="popup__info">
            <span class="popup__status">진행중</span>
            <h3>르네 그뤼오 : 르 엘레강스</h3>
            <p class="popup__location">서울 마포구</p>
            <p class="popup__date-main">24.11.11-25.01.19</p>
          </div>
        </div>

        <div class="popup__item">
          <img src="/images/퓰리처상.gif" alt="exhibition 3">
          <div class="popup__info">
            <span class="popup__status">진행중</span>
            <h3>퓰리처상 사진전</h3>
            <p class="popup__location">서울특별시 서초구</p>
            <p class="popup__date-main">24.12.21-25.01.31</p>
          </div>
        </div>

        <div class="popup__item">
          <img src="/images/어반아트.gif" alt="exhibition 4">
          <div class="popup__info">
            <span class="popup__status">진행중</span>
            <h3>나가노마켓 팝업스토어</h3>
            <p class="popup__location">서울특별시 중구</p>
            <p class="popup__date-main">24.10.02-25.02.02</p>
          </div>
        </div>
      </div>
    </div>
    <!-- </div> -->


  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useFetch } from '#app';

const slides = ref([]);
const popupItems = ref([]);
const concertItems = ref([]);
const musicalItems = ref([]);
const exhibitionItems = ref([]);
// const videos = ref([]);

//slides 랜덤 조회
const { data: slidesData, error: slidesError } = await useFetch('/api/v1/popup/random', {
  baseURL: 'http://localhost:8081',
})

if (slidesError.value) {
  console.error('API 호출 에러:', slidesError.value)
} else if (slidesData.value) {
  slides.value = (Array.isArray(slidesData.value) ? slidesData.value : [slidesData.value]).slice(0, 6)
  console.log('Fetched popup items:', slides.value)
}


//popup 랜덤 조회
const { data: popupData, error: popupError } = await useFetch('/api/v1/popup/random', {
  baseURL: 'http://localhost:8081',
})

if (popupError.value) {
  console.error('API 호출 에러:', popupError.value)
} else if (popupData.value) {
  popupItems.value = (Array.isArray(popupData.value) ? popupData.value : [popupData.value]).slice(0, 4)
  popupItems.value.forEach((item, index) => {
    console.log(`Item ${index}:`, item);  // 각 항목을 출력
  });
  console.log('Fetched popup items:', popupItems.value)
}

//concert 랜덤 조회
const { data: concertData, error: concertError } = await useFetch('/api/v1/concert/random', {
  baseURL: 'http://localhost:8081',
})

if (concertError.value) {
  console.error('API 호출 에러:', concertError.value)
} else if (concertData.value) {
  concertItems.value = (Array.isArray(concertData.value) ? concertData.value : [concertData.value]).slice(0, 4)
  console.log('Fetched popup items:', concertItems.value)
}

//musical 랜덤 조회
const { data, error } = await useFetch('/api/v1/musical/random', {
  baseURL: 'http://localhost:8081',
})

if (error.value) {
  console.error('API 호출 에러:', error.value)
} else if (data.value) {
  musicalItems.value = (Array.isArray(data.value) ? data.value : [data.value]).slice(0, 4)
  musicalItems.value.forEach((item, index) => {
    console.log(`Item ${index}:`, item);  // 각 항목을 출력
  });
  console.log('Fetched musical items:', musicalItems.value)
}

const formatDate = (date) => {
  if (!date) return ''
  const options = { year: 'numeric', month: 'short', day: 'numeric' }
  return new Date(date).toLocaleDateString(undefined, options)
}

//exhibition 랜덤 조회
const { data: exhibitionData, error: exhibitionError } = await useFetch('/api/v1/exhibition/random', {
  baseURL: 'http://localhost:8081',
})

if (exhibitionError.value) {
  console.error('API 호출 에러:', exhibitionError.value)
} else if (exhibitionData.value) {
  exhibitionItems.value = (Array.isArray(exhibitionData.value) ? exhibitionData.value : [exhibitionData.value]).slice(0, 4)
  console.log('Fetched exhibition items:', exhibitionItems.value)
}


// YouTube URL 관리
const youtubeUrls = ref([
  "https://www.youtube.com/watch?v=yWMbEEO7TcU",
  "https://www.youtube.com/watch?v=zo1cYfqT1oM",
  "https://www.youtube.com/watch?v=IImyBu6Hh98", 
  "https://www.youtube.com/watch?v=0bx21frXDJE",
  "https://www.youtube.com/watch?v=HJ9tK01fSuk",
  "https://www.youtube.com/watch?v=k8F4s2Ie5xU"
]);

const embedYoutubeUrls = reactive([]);

function convertToEmbedUrl(url) {
  const videoIdMatch = url.match(/(?:\?v=|\/embed\/|\/v\/|youtu\.be\/)([^&?/\n]+)/);
  return videoIdMatch ? `https://www.youtube.com/embed/${videoIdMatch[1]}` : null;
}

onMounted(() => {
  youtubeUrls.value.forEach(url => {
    const embedUrl = convertToEmbedUrl(url);
    if (embedUrl) {
      embedYoutubeUrls.push(embedUrl);
    }
  });
  // URL 변환 이후 슬라이더 크기 다시 계산
  nextTick(() => {
    updateDimensions();
  });
});

const sliderRef = ref(null)
const scrollbarThumbRef = ref(null)
const videoSliderRef = ref(null)
const sliderPosition = ref(0)
const videoCurrentIndex = ref(0)
const containerWidth = ref(0)
const sliderWidth = ref(0)
const maxScroll = ref(0)
const slideWidth = ref(0)
const isDragging = ref(false)
const startX = ref(0)
const startScrollLeft = ref(0)

const sliderStyle = computed(() => ({
  transform: `translateX(${-sliderPosition.value}px)`,
  width: `${sliderWidth.value}px`
}))

const scrollbarThumbStyle = computed(() => ({
  width: `${Math.max((containerWidth.value / sliderWidth.value) * 100, 40)}px`,
  left: `${(sliderPosition.value / maxScroll.value) * 100}%`
}))

const videoItemWidth = 300
const videoItemMargin = 16
const videoMoveDistance = videoItemWidth + videoItemMargin

const videoSliderStyle = computed(() => ({
  transform: `translateX(-${videoCurrentIndex.value * videoMoveDistance}px)`
}))

const updateDimensions = () => {
  if (!sliderRef.value) return
  const slides = sliderRef.value.querySelectorAll('.photo-slider__item')

  if(slides.length === 0) return;

  containerWidth.value = sliderRef.value.parentElement.offsetWidth
  slideWidth.value = slides[0].offsetWidth + parseFloat(getComputedStyle(slides[0]).marginRight)
  sliderWidth.value = slideWidth.value * slides.length - parseFloat(getComputedStyle(slides[slides.length - 1]).marginRight)
  maxScroll.value = Math.max(0, sliderWidth.value - containerWidth.value)
}

const updateSliderPosition = (percentage) => {
  sliderPosition.value = Math.min(maxScroll.value, percentage * maxScroll.value)
}

const moveSlider = (direction) => {
  sliderPosition.value = Math.max(0, Math.min(maxScroll.value, sliderPosition.value + direction * slideWidth.value))
}

const moveVideoSlider = (direction) => {
  if (direction > 0 && videoCurrentIndex.value < embedYoutubeUrls.length - 3) {
    videoCurrentIndex.value++;
  } else if (direction < 0 && videoCurrentIndex.value > 0) {
    videoCurrentIndex.value--;
  }
};

const onScrollbarClick = (e) => {
  const thumbRect = scrollbarThumbRef.value.getBoundingClientRect()
  if (e.clientX < thumbRect.left || e.clientX > thumbRect.right) {
    const percentage = (e.clientX - sliderRef.value.getBoundingClientRect().left) / sliderRef.value.offsetWidth
    updateSliderPosition(percentage)
  }
}

const startDragging = (e) => {
  isDragging.value = true
  startX.value = e.clientX - scrollbarThumbRef.value.offsetLeft
  startScrollLeft.value = scrollbarThumbRef.value.offsetLeft
  document.addEventListener('mousemove', onMouseMove)
  document.addEventListener('mouseup', onMouseUp)
}

const onMouseMove = (e) => {
  if (!isDragging.value) return
  e.preventDefault()
  const x = e.clientX - sliderRef.value.getBoundingClientRect().left
  const scrollWidth = sliderRef.value.offsetWidth - parseFloat(scrollbarThumbRef.value.style.width)
  const newScrollLeft = Math.max(0, Math.min(scrollWidth, x - startX.value))
  const percentage = newScrollLeft / scrollWidth
  updateSliderPosition(percentage)
}

const onMouseUp = () => {
  isDragging.value = false
  document.removeEventListener('mousemove', onMouseMove)
  document.removeEventListener('mouseup', onMouseUp)
}

onMounted(() => {
  updateDimensions()
  window.addEventListener('resize', updateDimensions)
})

onUnmounted(() => {
  window.removeEventListener('resize', updateDimensions)
})
</script>

<style scoped>
@import url('/public/css/popup/index.css');
</style>