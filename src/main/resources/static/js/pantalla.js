let currentSlide = 0;
const slides = document.querySelectorAll('.carrusel-slide');
const totalSlides = slides.length;
const prevBtn = document.getElementById('prevBtn');
const nextBtn = document.getElementById('nextBtn');
let intervalId;

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

function prevSlide() {
  currentSlide = (currentSlide - 1 + totalSlides) % totalSlides;
  showSlide(currentSlide);
}

nextBtn.addEventListener('click', () => {
  nextSlide();
  clearInterval(intervalId); // Stop automatic slide change when manually changing slides
  intervalId = setInterval(nextSlide, 3000); // Restart automatic slide change after manual change
});

prevBtn.addEventListener('click', () => {
  prevSlide();
  clearInterval(intervalId); // Stop automatic slide change when manually changing slides
  intervalId = setInterval(nextSlide, 3000); // Restart automatic slide change after manual change
});

// Automatic slide change every 3 seconds
intervalId = setInterval(nextSlide, 3000);
