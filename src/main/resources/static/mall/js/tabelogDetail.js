/* ---------------------------------- Main Photo ---------------------------------- */
var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
	showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
	showSlides(slideIndex = n);
}

function showSlides(n) {
	var i;
	var slides = document.getElementsByClassName("photo-slide");
	var dots = document.getElementsByClassName("demo");
	//var captionText = document.getElementById("caption");
	if (n > slides.length) {
		slideIndex = 1
	}
	if (n < 1) {
		slideIndex = slides.length
	}
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += " active";
	//captionText.innerHTML = dots[slideIndex   1].alt;
}

/* ---------------------------------- Kodawari Modal ---------------------------------- */
const openBtn = document.getElementsById('top-kodawari-item');
const modal = document.getElementById('kodawariModalContainer');
const closeBtn = document.getElementById('closeModal');

openBtn.addEventListener('click', openModal);
function openModal() {
	modal.style.display = 'block';
}

closeBtn.addEventListener('click', closeModal);
function closeModal() {
	modal.style.display = 'none';
}

addEventListener('click', outsideClose);
function outsideClose(e) {
	if (e.target == modal) {
		modal.style.display = 'none';
	};
};

