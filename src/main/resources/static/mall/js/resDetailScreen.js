$(function() {

	$("#bx-prev").click(function() {
		bxPrev();
	});
	$("#bx-next").click(function() {
		bxNext();
	});


});

let defaultMainPhoto = $('.p-main-photos__slider-item').eq(0);
defaultMainPhoto.css({ 'z-index': '50', 'display': 'block' });

function changeMainPhoto(i) {
	let mainPhoto = document.querySelectorAll('.p-main-photos__slider-item');
	mainPhoto.forEach(e => {
		e.style.zIndex = '0';
		e.style.display = 'none';
	});

	let currentMainPhoto = $('.p-main-photos__slider-item').eq(i);
	currentMainPhoto.css({ 'z-index': '50', 'display': 'block' });
}

let defaultSmallPhoto = $('.js-main-photos__switch-photo-target').eq(0);
defaultSmallPhoto.addClass('active1');

function showMainPhoto(_this) {
	let hasActive1 = document.querySelectorAll('.active1');
	hasActive1.forEach(e => {
		e.classList.remove('active1');
	})
	$(_this).addClass('active1');

	let thisValue = $(_this).find('img')[0].attributes.value.value;
	//let thisSrc = $(_this).find('img')[0].attributes.src.value;
	changeMainPhoto(thisValue - 1);
}
let bxIndex = 0;
function bxPrev() {

	let hasActive1 = document.querySelectorAll('.active1');
	hasActive1.forEach(e => {
		if (e.classList.contains('active1')) {
			let currentIndex = parseInt(e.firstElementChild.attributes.value.value);
			bxIndex = currentIndex;
		}
	});
	
	console.log(bxIndex);
	bxIndex--;
	if (bxIndex < 0) {
		bxIndex = 9;
	}
	console.log(bxIndex-1);

	changeMainPhoto(bxIndex-1);
}