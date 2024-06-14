document.addEventListener("DOMContentLoaded", function() {
  let currentSlide = 0;
  const slides = document.querySelectorAll('.carousel-item');
  const totalSlides = slides.length;
  const prevBtn = document.querySelector('.carousel-control-prev');
  const nextBtn = document.querySelector('.carousel-control-next');
  let intervalId;

  function showSlide(index) {
    slides.forEach((slide) => {
      slide.classList.remove('active');
    });
    slides[index].classList.add('active');
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
    clearInterval(intervalId); // Detener cambio automático de diapositivas cuando se cambian manualmente
    intervalId = setInterval(nextSlide, 3000); // Reiniciar cambio automático de diapositivas después del cambio manual
  });

  prevBtn.addEventListener('click', () => {
    prevSlide();
    clearInterval(intervalId); // Detener cambio automático de diapositivas cuando se cambian manualmente
    intervalId = setInterval(nextSlide, 3000); // Reiniciar cambio automático de diapositivas después del cambio manual
  });

  // Cambio automático de diapositivas cada 3 segundos
  intervalId = setInterval(nextSlide, 3000);
});
