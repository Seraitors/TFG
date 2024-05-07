let currentSlide = 0;
const slides = document.querySelectorAll('.carrusel-slide');
const totalSlides = slides.length;

function showSlide(index) {
  slides.forEach((slide) => {
    slide.classList.remove('activar');
  });
  slides[index].classList.add('activar');
}

function nextSlide() {
  currentSlide = (currentSlide + 1) % totalSlides;
  showSlide(currentSlide);
}

// Para avanzar automáticamente al siguiente slide cada cierto tiempo
setInterval(nextSlide, 3000);