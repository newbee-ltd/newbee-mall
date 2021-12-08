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
$('#now-date').text(nowDatei.length = 1 ? '0' + nowDatei : nowDatei);
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
				$(tdi).click(function() {
					checkReserveDate(this);
				})
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

	$('#js-week-wrap tbody tr td').each(function(k, v) {
		if ($(v).text() == '') {
			$(v).addClass('without-after-element');
		}
	})
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

	$('#js-week-wrap tbody tr td').each(function(k, v) {
		if ($(v).text() == '') {
			$(v).addClass('without-after-element');

		}
	});
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
		if (nowYear > currentYear || nowMonth > currentMonth && nowYear == currentYear
			|| dayi > nowDatei + 1 && nowMonth == currentMonth && nowYear == currentYear) {
			$(v).addClass('reserve-ok-after');
		}
		if (dayi >= nowDatei && nowMonth == currentMonth && nowYear == currentYear) {
			$(v).addClass('tel-after');
		}
	})


}
refreshDate();

function showcourse(_this) {
	$('#course-reserve-modal').css({ 'display': 'block' });
	$('.js-booking-info-root').css({ 'display': 'block' });
	let courseName = $(_this).parent().parent().find('.rstdtl-course-list__course-title-text').text();
	let coursePriceStr = $(_this).parent().parent().parent().find('.rstdtl-course-list__price-num em').text();
	//let coursePrice = parseInt(coursePriceStr.replace(/\,/g, ''));
	$('.p-booking-calendar__course-title').text(courseName);
	$('.p-booking-calendar__course-price-sale').text(coursePriceStr);
}

function changeNaviColor(_this) {
	//window.event.preventDefault();
	$(_this).removeClass('is-selected');
}

function showSeaReserve(_this) {
	$('#course-reserve-modal').css({ 'display': 'block' });
	$('.js-booking-info-root').css({ 'display': 'block' });
	$('.p-booking-calendar__option-subject').text('座席');
	$('.p-booking-calendar__option-item').text('完全個室');
}
function checkReserveDate(_this) {
	$('#reserve-calendar').css({
		'display': 'none'
	});
	let checkDate = $(_this).text();
	$('#js-week-wrap tbody tr td').css({
		'outline': '',
		'background-color': ''
	});
	$(_this).css({
		'outline': '1px solid #fae486',
		'background-color': '#fefae6'
	});
	$('#now-month').text($('#reserve-month').text());
	$('#now-date').html(checkDate.length == 1 ? '0' + checkDate : checkDate);
	let week = ['日', '月', '火', '水', '木', '金', '土'];
	$('#now-day').text(week[$(_this).index()]);

	let reserveDayStr = $('#reserve-year').text() + "-" + $('#reserve-month').text() + "-" + checkDate;
	let from = reserveDayStr.split("-")
	let reserveDay = new Date(from[0], from[1] - 1, from[2]);
	//日期//console.log(reserveDay);//"Fri Dec 10 2021 00:00:00 GMT+0900 (日本標準時)"

	let reservetimeStr = $('#reserve-time option:selected').text()
	let reserveTime = reservetimeStr.slice(reservetimeStr.length - 5);
	//console.log(reservetime);
	var reserveDaytime = new Date(reserveDayStr + ' ' + reserveTime);
	//日期+时间//console.log(reserveTime);//"Fri Dec 10 2021 19:00:00 GMT+0900 (日本標準時)"


	let reserveDay1 = Date.parse(reserveDay) / 1000 / 60 / 60;
	let nowDate1 = Date.parse(nowDate) / 1000 / 60 / 60;
	let dateIntival = Math.ceil((reserveDay1 - nowDate1) / 24);


}

function changeReverseTime() {
	var e = document.getElementById("reserve-time");
	var strUser = e.options[e.selectedIndex].text.slice(2);
	//console.log(strUser);
}

$('#js-week-wrap tbody tr td').each(function(k, v) {
	if ($(v).text() == '') {
		$(v).addClass('without-after-element');
	}
})

let time1 = $('#lunch-start').text();
let time2 = $('#lunch-end').text();
let time3 = $('#dinner-start').text();
let time4 = $('#dinner-end').text();
let array1 = time1.split(":");
let array2 = time2.split(":");
let array3 = time3.split(":");
let array4 = time4.split(":");
let t1 = (parseFloat(array1[0], 10) * 60 + parseInt(array1[1], 10) + parseInt(array1[2], 10)) / 60;
let t2 = (parseFloat(array2[0], 10) * 60 + parseInt(array2[1], 10) + parseInt(array2[2], 10)) / 60;
let t3 = (parseFloat(array3[0], 10) * 60 + parseInt(array3[1], 10) + parseInt(array3[2], 10)) / 60;
let t4 = (parseFloat(array4[0], 10) * 60 + parseInt(array4[1], 10) + parseInt(array4[2], 10)) / 60;
//console.log(t1, t2, t3, t4)

// Generate array of times (as strings) for every x minutes 
let x = 15; //minutes interval
let times = []; // time array
//let tt = 11 * 60; // start time
//let tt1 = 17  * 60;
//var ap = ['AM', 'PM']; // AM-PM
t1 = t1 * 60;
t3 = t3 * 60;
//loop to increment the time and push results in array
for (var i = 0; t1 < t2 * 60; i++) {
	var hh = Math.floor(t1 / 60); // getting hours of day in 0-24 format
	var mm = (t1 % 60); // getting minutes of the hour in 0-55 format
	times.push(("0" + (hh % 24)).slice(-2) + ':' + ("0" + mm).slice(-2)); // pushing data in array in [00:00 - 12:00 AM/PM format]
	t1 = t1 + x;

}
for (var i = 0; t3 < t4 * 60; i++) {
	var hh = Math.floor(t3 / 60); // getting hours of day in 0-24 format
	var mm = (t3 % 60); // getting minutes of the hour in 0-55 format
	times.push(("0" + (hh % 24)).slice(-2) + ':' + ("0" + mm).slice(-2)); // pushing data in array in [00:00 - 12:00 AM/PM format]
	t3 = t3 + x;
}

for (let val in times) {
	$('<option />', { value: val, text: '○ ' + times[val], selected: times[val] == '19:00' }).appendTo($('#reserve-time'));
}

function reserveSeatOnly() {
	$('#course-reserve-modal').css({ 'display': 'block' });
	$('.js-booking-info-root').css({ 'display': 'none' });
}

$('#menu-navi2').css('display') == 'block' ? $('#menu-navi').css({ 'display': 'none' }) : $('#menu-navi').css({ 'display': 'display' });

window.onscroll = function() { naviSticky() };
var navbar = document.getElementById("main-navi");
var sticky = navbar.offsetTop;
function naviSticky() {
	if (window.pageYOffset >= sticky) {
		navbar.classList.add("navi-sticky")
	} else {
		navbar.classList.remove("navi-sticky");
	}
}


//总页数
let total = parseInt($('#mp-total-count').text());
//let total = 20;
$(function() {
	//页面初始化调用 生成页码
	makePage(total, 1);
});
//生成页码函数
function makePage(total, page) {
	let pageHtml = '';
	//点点点的html
	let ddd = '<li class="c-pagination__item"><strong class="c-pagination__dot"> ... </strong></li>';

	function createPage(index) { //单页码生成
		if (page == index) {
			//当前页(或选中)样式 多了个selected(换背景色字体色的)
			pageHtml += '<li class="c-pagination__item"><strong class="c-pagination__num is-current">' + page + '</strong ></li > ';
		} else {
			pageHtml += '<li class="c-pagination__item" onclick="pageClick(this)"><strong class="c-pagination__num  onclick="pageClick(this)">' + index + '</strong ></li>';
		}
	}

	if (page > 1 && total > 1) { // 上一页
		pageHtml += '<li class="c-pagination__item" onclick="mpPagePrev()"><a class="c-pagination__arrow c-pagination__arrow--prev">前の6件</a></li>';
	} else {
		pageHtml += '<li class="c-pagination__item""><a class="c-pagination__arrow c-pagination__arrow--prev">前の6件</a></li>';
	}

	if (total <= 6) { //总页数小于10
		for (let i = 1; i <= total; i++) {
			//正常生成排列
			createPage(i);
		}
	} else {
		if (page <= 4) { //总页数大于10且当前页远离总页数(小于4)
			for (let i = 1; i <= 4 + 1; i++) { //显示1-5
				createPage(i);
			}
			//三个点...
			pageHtml += ddd;
			//三个点后面 生成最后一个页数
			createPage(total);

		} else if (page > total - 4) { //总页数大于10且当前页接近总页数(大于总页数-4)
			//第一页
			createPage(1);
			//三个点...
			pageHtml += ddd;
			//生成最后5个页数
			for (let i = total - 4; i <= total; i++) {
				createPage(i);
			}
		} else { //除开上面两个情况 当前页在中间
			//页数1
			createPage(1);
			//三个点...
			pageHtml += ddd;
			//生成当前页和 前跟后一个页数
			for (let i = page - 1; i <= page + 1; i++) {
				createPage(i);
			}
			//三个点...
			pageHtml += ddd;
			//最后一个页数
			createPage(total);
		}
	}


	if (page < total && total > 1) { // 下一页
		pageHtml += '<li class="c-pagination__item" onclick="mpPageNext()"><a class="c-pagination__arrow c-pagination__arrow--next">次の6件</a></li>';
	} else {
		pageHtml += '<li class="c-pagination__item"><a class="c-pagination__arrow c-pagination__arrow--next">次の6件</a></li>';
	}
	//赋值生成html
	$('#manuphoto-page-list').html(pageHtml);
}
//上一页点击事件
function mpPagePrev() {
	//获取当前页
	//var page = $('#manuphoto-page-list>.is-current').text();
	let page = $('.c-pagination__num.is-current').text();
	if (page <= 1) {
		return;
	}
	makePage(total, page - 1);
	menuPhotoPage();
}
//下一页点击事件
function mpPageNext() {
	//获取当前页
	let page = $('.c-pagination__num.is-current').text();
	if (page >= total) {
		return;
	}
	makePage(total, page * 1 + 1);
	menuPhotoPage();
}
//直接点击页数事件
function pageClick(that) {
	let page = parseInt($(that).children().html());
	//console.log(page);
	makePage(total, page * 1);
	menuPhotoPage();
}

Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function menuPhotoPage() {
	//let totalPage = parseInt(parseInt($('#mp-total-count').text()));
	let currPage = parseInt($('#manuphoto-page-list').find('.is-current').text());
	let restaurantId = parseInt($('#restaurant-id').text());
	let url = "/menuPhotoList";
	let data = {
		'restaurantId': restaurantId,
		'currentPage': currPage,
		'limit': 6
	}
	$.ajax({
		type: 'GET',
		contentType: 'application/json',
		data: data,
		url: url,

		success: function(result) {
			//console.log(result);
			if (result.resultCode == 200) {
				if (result.data.list.length > 0) {
					$("#default-menu-photo").find('.rstdtl-photo-list__item').remove();
				}

				let el;
				for (let i = 0; i < result.data.list.length; i++) {
					el = $("#menu-photo-clone-item").clone();
					el.find('#mp-a-img-href').attr('href', result.data.list[i].photoUrl);
					el.find('#mp-img-src').attr('src', result.data.list[i].photoUrl);
					el.find('#mp-post-date').html(new Date(result.data.list[i].photoPostDate).Format("yy-MM-dd"));
					el.find('#mp-like-num').html(result.data.list[i].helpNum);
					el.find('#mp-post-name').html(result.data.list[i].postUserName);
					el.find('.like-btn__label').click(mpLike);
					$("#default-menu-photo").append(el);
				}
			} else {
				swal(result.message, {
					icon: "error",
				});
			}

		},
		error: function() {
			swal("操作失败", {
				icon: "error",
			});
		}
	});

}

function mpLike(_this) {
	console.log(_this);
}


