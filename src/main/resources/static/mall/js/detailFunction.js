//--------- imglist---------
const imgList = document.querySelectorAll('.phone-img');
const mainImg = document.querySelector('.swiper-container img');

const imgBlock = document.querySelectorAll('.img-block');
const SlideDot = document.querySelectorAll('.fa-circle');
const imgColumn = document.querySelector('.img-column');

const prevSlide = document.querySelector('.fa-chevron-left');
const nextSlide = document.querySelector('.fa-chevron-right');

//--------- imglist---------
imgList[0].classList.add('active');

function showActiveDot(index) {
	for (let i = 0; i < imgBlock.length; i++) {
		if (SlideDot[i].classList.contains('activeDot')) {
			SlideDot[i].classList.remove('activeDot');
		}
	}
	SlideDot[index].classList.add('activeDot');
}

SlideDot[0].classList.add('activeDot');
//let preClickDot = 0;
function clickDot(dotI) {
	imgColumn.style.transform = `translateX(${-dotI * 480}px)`;
	//preClickDot = dotI;
	showActiveDot(dotI);
}

function clickImg(i) {
	for (let j = 0; j < imgList.length; j++) {
		if (imgList[j].classList.contains('active')) {
			imgList[j].classList.remove('active');
		}
	}

	for (let k = 0; k < imgBlock.length; k++) {
		let dotIndex = 0;
		if (SlideDot[k].classList.contains('activeDot')) {
			dotIndex = k;
			//console.log(imgBlock[dotIndex].children[i]);
			imgBlock[dotIndex].children[i].classList.add('active');
			let changeSrc = imgBlock[dotIndex].children[i].src.slice(21);
			//console.log(src.slice(21));
			mainImg.setAttribute('src', changeSrc);
		}
	}
}

let blockIndex = 0;
function prevImgSlide() {
	blockIndex--;
	if (blockIndex < 0) {
		blockIndex = imgBlock.length - 1;
	}
	imgColumn.style.transform = `translateX(${-blockIndex * 480}px)`;
	showActiveDot(blockIndex);
}
function nextImgSlide() {
	blockIndex++;
	if (blockIndex > imgBlock.length - 1) {
		blockIndex = 0;
	}
	imgColumn.style.transform = `translateX(${-blockIndex * 480}px)`;
	showActiveDot(blockIndex);
}
//imgItems.forEach(img => {
//	img.addEventListener('click', currentImg);
//});
prevSlide.addEventListener('click', prevImgSlide);
nextSlide.addEventListener('click', nextImgSlide);


//--------- QA---------

$(function() {
	// qa
	$("#next-page").click(function() {
		QAPage(1);
	});
	$("#prev-page").click(function() {
		QAPage(-1);
	});

	$('#ZVQuestionTextarea').change(function() {
		inputQ(this);
	});
	$('#ZVPostQuestionButton').click(function() {
		if ($('#ZVQuestionTextarea').val() !== '' && $('#ZVQuestionTextarea').val() !== undefined) {
			submitQ();
		}
	});

	// review
	$("#displaymorereview").click(function() {
		reviewMore();
	});
	$("#rvSaveBt").click(function() {
		reviewSubmit();
	});

});
const qaSortDiv = document.getElementById("zv-cqa-select-sort");
// review
const fade = document.querySelector('.fade');
const stars = document.querySelectorAll("#stars");
const closeModal = document.querySelector("#close-modal");
const reviewAdd = document.querySelector('#reviewAdd');
const reviewTitle = document.querySelector('#reviewTitle');
const reviewDetail = document.querySelector('#reviewDetail');
const chooseFile = document.querySelector('#uploadRVImage');
const fileInput = document.querySelector("#fileInput");

// Date format
Date.prototype.Format = function(fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份
		"d+": this.getDate(),  //日 
		"h+": this.getHours() + 1, //小时(此处本不需要+1,但是我电脑有一小时时差)
		"m+": this.getMinutes(), //分
		"s+": this.getSeconds(), //秒
		//"q+": Math.floor((this.getMonth() + 3) / 3), //季度
		//"S": this.getMilliseconds() //毫秒
	};
	if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var k in o)
		if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}
//var str1 = new Date(result.data.list[0].submitDate);
//var str2 = str1.Format("yyyy年MM月dd日");
//console.log(str2);


function QAPage(num) {
	const currPage = parseInt($('#currPage').text());
	const totalPage = parseInt($('#totalPage').text());
	let pathname = window.location.pathname;
	let goodsId = parseInt(pathname.substring(pathname.length - 5));

	const url = "/QA/list";
	let pageNo;
	if (num == 1) {
		pageNo = currPage + 1;  // num=1 下一页
		if (pageNo > totalPage) {
			pageNo = 1;
		}
	} else if (num == -1) {
		pageNo = currPage - 1; // num=-1 上一页
		if (pageNo < 1) {
			pageNo = totalPage;
		}
	} else if (num == 0 || num == 2) {
		pageNo = 1;   // num=0 排序top; num=2 排序buttom
	}
	//console.log(currPage,pageNo);

	if (num == 2) {
		data = {
			'goodsId': goodsId,
			'currentPage': pageNo,
			'orderByColumn': "help_num",
			'ascOrDesc': 'asc',
			'limit': 3
		};
	} else {
		data = {
			'goodsId': goodsId,
			'currentPage': pageNo,
			'orderByColumn': "help_num",
			'ascOrDesc': 'desc',
			'limit': 3
		};
	}

	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(data),
		url: url,

		success: function(result) {
			//console.log(result);
			if (result.resultCode == 200) {
				if (result.data.list.length > 0) {
					$("#ZVCQuestionsArea").find(".qaSecCls").remove();
				}

				let hiddenEl;
				for (let i = 0; i < result.data.list.length; i++) {
					hiddenEl = $(".hiddenQaSec").clone().removeClass("hiddenQaSec");
					hiddenEl.find('#qa-question').html(result.data.list[i].question);
					hiddenEl.find('#qa-submit-date').html(new Date(result.data.list[i].submitDate).Format("yyyy年MM月dd日"));
					hiddenEl.find('#qa-answer').html(result.data.list[i].answer);
					hiddenEl.find('#qa-answer-date').html(new Date(result.data.list[i].answersDate).Format("yyyy年MM月dd日"));
					hiddenEl.find('#qa-help-num').html(result.data.list[i].helpNum);
					hiddenEl.find('#qa-questionsId').html(result.data.list[i].questionsId);
					hiddenEl.click(helpSannkou2);
					$("#zv-cqa-step-footer").before(hiddenEl);
					//hiddenEl.appendTo("#ZVCQuestionsArea");
				}

				$("#currPage").html(result.data.currPage);

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

function qaSort() {
	const value = qaSortDiv.value;
	if (value === "ボトム評価") {
		QAPage(2);
	}
	if (value === "トップ評価") {
		QAPage(0);
	}
}

//var _this;
function clickSannkou(_this) {
	// var _this = this;

	let pathname = window.location.pathname;
	let goodsId = parseInt(pathname.substring(pathname.length - 5));
	//const questionIds = $('.hiddenQuestionId').text();
	//const questionId = parseInt(questionIds[i]);
	const questionId = $(_this).find('.hiddenQuestionId').text();

	let data = {
		"goodsId": goodsId,
		"questionsId": questionId,
	}

	$.ajax({
		type: 'POST',
		url: "/QA/helpNum",
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(result) {
			if (result.resultCode == 200) {
				$(_this).find('#qa-help-num').text(result.data);
			} else {
				swal(result.message, {
					icon: "error",
				});
			}
			;
		},

		error: function() {
			swal("操作失败", {
				icon: "error",
			});
		}

	});
}

// 通过jQuery在循环里加入click时事件
function helpSannkou2(_this) {
	// _this 是一个event，下面的this就是我点击的部分
	//const questionId = $(this2).find('.hiddenQuestionId').text();
	//console.log(questionId);
	const questionId = $(this).find('.hiddenQuestionId').text();
	clickSannkou(this);
}

// 在html传 helpSannkou2(this)
//function helpSannkou2(this2) {
//const questionId = $(this2).find('.hiddenQuestionId').text();
//console.log(questionId);
//clickSannkou(this2);
//}

function inputQ(el) {
	let queationT = el.value;
	//console.log(queationT);
}

function submitQ() {
	let queation = $('#ZVQuestionTextarea').val(); //1

	let submitDateStr = new Date().Format("yyyy-MM-dd hh:mm:ss"); //2
	let submitDate = Date.parse(submitDateStr);

	let pathname = window.location.pathname;
	let goodsId = parseInt(pathname.substring(pathname.length - 5)); //3
	let questionId = parseInt($('#totalCount').text()) + 1; //4

	let data = {
		'goodsId': goodsId,
		'questionsId': questionId,
		'question': queation,
		'submitDate': submitDate
	}

	$.ajax({
		type: 'POST',
		url: "/insertQA",
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(result) {
			if (result.resultCode == 200) {
				$('#totalCount').text(questionId);
			} else {
				swal(result.message, {
					icon: "error",
				});
			}
			;
		},
		error: function() {
			swal("操作失败", {
				icon: "error",
			});
		}
	});
}

/*---------------review------------------*/


function reviewMore() {
	$('.showReviewMore').toggleClass('moreReviewHidden');
	if (!$('.showReviewMore').hasClass('moreReviewHidden')) {
		$('#moreReviewMsg').html("閉じる ");
		$('#moreReviewIc').removeClass('fa-chevron-down');
		$('#moreReviewIc').addClass('fa-chevron-up');
	} else {
		let totalReview = $('#js-reviews').text();
		$('#moreReviewMsg').html(`レビューをもっと見る（3/${totalReview})`);
		$('#moreReviewIc').removeClass('fa-chevron-up');
		$('#moreReviewIc').addClass('fa-chevron-down');
	}

}


function clickReviewSannkou(_this) {
	// var _thi= this;

	let pathname = window.location.pathname;
	let goodsId = parseInt(pathname.substring(pathname.length - 5));
	//const questionIds = $('.hiddenQuestionId').text();
	//const questionId = parseInt(questionIds[i]);
	const reviewId = parseInt($(_this).parent().parent().parent().find('.hiddenReviewId').text());

	let data = {
		"goodsId": goodsId,
		"reviewId": reviewId,
	}


	$.ajax({
		type: 'POST',
		url: "/reviewHelpNum",
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(result) {
			if (result.resultCode == 200) {
				$(_this).find('#review-helpNum').text(result.data);
			} else {
				swal(result.message, {
					icon: "error",
				});
			}
			;
		},
		error: function() {
			swal("操作失败", {
				icon: "error",
			});
		}
	});

}
//平均星级
let avgStar = parseFloat($('.p-reviw-graph-area-g-score').text());
$('#avgStar').css("width", `${(avgStar / 5) * 100}%`);

// model 星星

for (let i = 0; i < stars.length; i++) {
	stars[i].onclick = function() {
		console.log('star rating: ' + this.value);
		$(this).html(this.value);
	}
}
closeModal.onclick = function() {
	fade.style.display = "none";
}
reviewAdd.onclick = function() {
	fade.style.display = "block";
}
window.onclick = function(event) {
	if (event.target == fade) {
		fade.style.display = "none";
	}
}

reviewTitle.onchange = function() {
	console.log('reviewTitle: ' + this.value);
}
reviewDetail.onchange = function() {
	console.log('reviewDetail: ' + this.value);
}
chooseFile.onclick = function() {
	$("#fileInput").click();
}
fileInput.onchange = function(e) {
	console.log(e);
	if (e.target.files.length > 0) {
		let src = URL.createObjectURL(e.target.files[0]);
		let preview = document.getElementById("carouselImg");
		preview.src = src;
		console.log(preview.src);
	}
}

function reviewSubmit() {
	let pathname = window.location.pathname;
	let goodsId = parseInt(pathname.substring(pathname.length - 5));
	let reviewId = parseInt(10 + $('#js-reviews-more').text()) + 1;
	let star;
	for (let i = 0; i < stars.length; i++) {
		//console.log(stars[i].textContent);
		if (stars[i].textContent != '') {
			star = stars[i].textContent;
		}
	}
	let submitDateStr = new Date().Format("yyyy-MM-dd hh:mm:ss");
	let submitDate = Date.parse(submitDateStr);
	let reviewTitle1 = reviewTitle.value;
	let reviewDetail1 = reviewTitle.value;
	let imageUrl = document.getElementById("carouselImg").src;

	let data = {
		"goodsId": goodsId,
		"reviewId": reviewId,
		"star": star,
		"submitDate": submitDate,
		"reviewTitle": reviewTitle1,
		"reviewDetail": reviewDetail1,
		"imageUrl": imageUrl
	};
	
	$.ajax({
		type: 'POST',//方法类型
		url: '/insertReview',
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(result) {
			if (result.resultCode == 200) {
				fade.style.display = "none";
				swal("保存成功", {
					icon: "success",
				});
				reload();
			} else {
				fade.style.display = "none";
				swal(result.message, {
					icon: "error",
				});
			}
			;
		},
		error: function() {
			swal("操作失败", {
				icon: "error",
			});
		}
	});

}
