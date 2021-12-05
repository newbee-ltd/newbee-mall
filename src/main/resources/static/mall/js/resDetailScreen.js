$(function() {

	$("#bx-prev").click(function() {
		bxPrev();
	});
	$("#bx-next").click(function() {
		bxNext();
	});
	//$('#prev-commit-modal').click(function() {
	//	changeCommitModal(-1);
	//});
	//$('#next-commit-modal').click(function() {
	//	changeCommitModal(1);
	//});

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


function bxPrev() {
	let currentIndex;
	let mainBlock = document.querySelectorAll('.p-main-photos__slider-item');
	mainBlock.forEach(e => {
		if (e.style.display == 'block' && e.style.zIndex == '50') {
			currentIndex = parseInt(e.firstElementChild.attributes.value.value)
		}
	});
	changeMainPhoto(currentIndex - 1 - 1);

	//console.log(currentIndex - 1);
	let hasActive1 = document.querySelectorAll('.active1');
	hasActive1.forEach(e => {
		e.classList.remove('active1');
	});
	$('.js-main-photos__switch-photo-target').eq(currentIndex - 1 - 1).addClass('active1');

}
function bxNext() {
	let currentIndex;
	let mainBlock = document.querySelectorAll('.p-main-photos__slider-item');
	mainBlock.forEach(e => {
		if (e.style.display == 'block' && e.style.zIndex == '50') {
			currentIndex = parseInt(e.firstElementChild.attributes.value.value);
		}
	});
	if (currentIndex > mainBlock.length - 1) {
		currentIndex = 0;
	}
	changeMainPhoto(currentIndex - 1 + 1);

	let hasActive1 = document.querySelectorAll('.active1');
	hasActive1.forEach(e => {
		e.classList.remove('active1');
	});
	$('.js-main-photos__switch-photo-target').eq(currentIndex - 1 + 1).addClass('active1');

}

function closeModal() {
	$('.c-overlay').css('display', "none");
}

let hiddenRevM = document.querySelector('#reviewModal');
let hiddenKoda = document.querySelector('#kodawari-madal');
let hiddenCourseM = document.querySelector('#course-reserve-modal');
window.onclick = function(event) {
	if (event.target == hiddenKoda) {
		$('#kodawari-madal').css('display', "none");
	}
	if (event.target == hiddenRevM) {
		$('#reviewModal').css('display', "none");
	}
	if (event.target == hiddenCourseM) {
		$('#course-reserve-modal').css('display', "none");
	}

}

function showCommitModal(_this) {
	$('#kodawari-madal').css('display', "block");

	let madelIndex = $(_this).index();
	for (i = 0; i < $('.c-kodawari-contents').length; i++) {
		$('.c-kodawari-contents').eq(i).css({ 'display': 'none' });
	}
	$('.c-kodawari-contents').eq(madelIndex).css({ 'display': 'block' });

}

function changeCommitModal(num) {
	let commitIndex;
	let commitModal = document.querySelectorAll('.c-kodawari-contents');
	commitModal.forEach(e => {
		if (e.style.display == 'block') {
			commitIndex = $(e).index();
		}
	});

	for (i = 0; i < $('.c-kodawari-contents').length; i++) {
		$('.c-kodawari-contents').eq(i).css({ 'display': 'none' });
	}
	if (num = - 1) {
		$('.c-kodawari-contents').eq(commitIndex - 1 - 1).css({ 'display': 'block' });
	} else if (num = 1) {
		$('.c-kodawari-contents').eq(commitIndex - 1 + 1).css({ 'display': 'block' });
	}

}

function showNotice() {
	if ($('.showNotice').text() == "显示更多") {
		$('#notice-p').css({ '-webkit-line-clamp': 'unset' });
		$('.showNotice').text('收起更多');
	} else {
		$('#notice-p').css({ '-webkit-line-clamp': '7' });
		$('.showNotice').text('显示更多');
	}
}


function showMoreMealUserPhoto() {
	$('#showMoreMealUserPhoto').css({ 'display': 'block' });
	$('.js-images-more-link').css({ 'display': 'none' });
	$('.js-hidden-photolist-link').css({ 'display': 'block' });
}

function showReviewModal() {
	$('#reviewModal').css({ 'display': 'block' });
}

$('.rstdtl-takeout-info__text').each(function(k, v) {
	if ($(v).find('br').length < 5) {
		$(v).parent().find('.rstdtl-takeout-info__more-trigger').css({ 'display': 'none' });
	}
});

function showTakeOut(_this) {
	$(_this).parent().find('.rstdtl-takeout-info__text').css({ '-webkit-line-clamp': 'unset' });
	$(_this).css({ 'display': 'none' });
}

// calender
let nowDate = new Date();
let nowYear = nowDate.getFullYear();
let nowMonth = nowDate.getMonth() + 1;
let nowDatei = nowDate.getDate();
let nowDay = '日月火水木金土'.charAt(nowDate.getDay());

$('#reserve-year').text(nowYear);
$('#reserve-month').text(nowMonth);
$('#now-month').text(nowMonth);
$('#now-date').text(nowDatei);
$('#now-day').text(nowDay);

let monthDays1 = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
let monthDays2 = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

function becomeDate(nowYear, nowMonth) {
	let dt = new Date(nowYear, nowMonth - 1, 1);
	let firstDay = dt.getDay();
	let table = document.getElementById("js-week-wrap");
	let monthDays = isRunNian();
	let rows = 6;
	let cols = 7;
	let k = 1;
	for (let i = 1; i <= rows; i++) {
		let tri = table.insertRow();
		for (let j = 1; j <= cols; j++) {
			let tdi = tri.insertCell();
			if (i == 1 && i * j < firstDay + 1) {
				tdi.innerHTML = "";
			} else {
				if (k > monthDays[nowMonth - 1])
					break;
				tdi.innerHTML = k;
				k++;
			}
		}
	}
}
function lastMon() {
	window.event.preventDefault();
	let table = document.getElementById("js-week-wrap");
	table.innerHTML = "";

	if (nowMonth > 1) {
		nowMonth = nowMonth - 1;
	} else {
		nowYear--;
		nowMonth = 12;
	}
	$('#reserve-year').text(nowYear);
	$('#reserve-month').text(nowMonth);
	becomeDate(nowYear, nowMonth);
	refreshDate();
}

function nextMon() {
	window.event.preventDefault();
	let table = document.getElementById("js-week-wrap");
	table.innerHTML = "";
	if (nowMonth < 12) {
		nowMonth = nowMonth + 1;
	} else {
		nowYear++;
		nowMonth = 1;
	}

	$('#reserve-year').text(nowYear);
	$('#reserve-month').text(nowMonth);
	becomeDate(nowYear, nowMonth);
	refreshDate();
}

function isRunNian() {
	if ((nowYear % 4 == 0 || nowYear % 400 == 0) && nowYear % 100 != 0) {
		return monthDays1;
	}
	else {
		return monthDays2;
	}
}
becomeDate(nowYear, nowMonth);

function refreshDate() {
	let currentMonth = nowDate.getMonth() + 1;
	let currentYear = nowDate.getFullYear();
	//console.log(nowMonth,currentMonth,nowYear,currentYear)
	$('#js-week-wrap').find('tr').each(function(k, v) {
		v.children[0].style.color = '#e64c30';
		$(v).find('td').eq(6).css({ 'color': '#3d90dd' });
	});

	$('#js-week-wrap').find('td').each(function(k, v) {
		let dayi = parseInt(v.textContent);
		if (nowYear < currentYear || nowMonth < currentMonth && nowYear == currentYear
			|| dayi < nowDatei && nowMonth == currentMonth && nowYear == currentYear) {
			v.style.color = 'lightgrey';
		}
	})
}
refreshDate();

function showcourse(_this) {
	$('#course-reserve-modal').css({ 'display': 'block' });
	let courseName = $(_this).parent().parent().find('.rstdtl-course-list__course-title-text').text();
	let coursePriceStr = $(_this).parent().parent().parent().find('.rstdtl-course-list__price-num em').text();
	//let coursePrice = parseInt(coursePriceStr.replace(/\,/g, ''));
	$('.p-booking-calendar__course-title').text(courseName);
	$('.p-booking-calendar__course-price-sale').text(coursePriceStr);
}
