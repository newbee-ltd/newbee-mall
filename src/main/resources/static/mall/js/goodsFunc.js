const image = document.querySelectorAll('.image');
const coverImg = document.querySelectorAll('.swiper-container fl');
var totalSlide = document.querySelectorAll('.img-column');
var pagination = document.querySelectorAll('.swiper-pagination-bullet');
const imgContainer = document.getElementById('imageContainer');

// Set Current Img
function currentImg(src) {
	$(".img-container").find(".image").attr('src', src);
}

// Set Active Slide
function paginationActive(i) {
	for (let i = 0; i < totalSlide.length; i++) {
		if (pagination[i].classList.contains('swiper-pagination-bullet-active')) {
			pagination[i].classList.remove('swiper-pagination-bullet-active');
		}
	}
	pagination[i].classList.add('swiper-pagination-bullet-active');
}

// Set Pagination
var currentPage = 1;

function clickPagination(evt) {
	currentPage = evt.currentTarget.index;
	console.log(currentPage);
	var xLength = - currentPage * 560;
	imgContainer.style.transform = `translateX(${xLength}px)`;
	paginationActive(currentPage);
}

$(document).ready(function() {
	pagination = [...pagination];
	pagination.map((e, index) => {
		console.log(e);
		e.index = index;
		return e.addEventListener('click', clickPagination)
	});
});

// Previous Img Slide
let currentPageIndex = 0;

function prevImgSlide() {
	currentPageIndex--;
	if (currentPageIndex < 0) {
		currentPageIndex = totalSlide.length - 1;
	}
	var xLength = - currentPageIndex * 560;
	imgContainer.style.transform = `translateX(${xLength}px)`;
	paginationActive(currentPageIndex);
}

// Next Img Slide
function nextImgSlide() {
	currentPageIndex++;
	if (currentPageIndex > totalSlide.length - 1) {
		currentPageIndex = 0;
	}
	var xLength = - currentPageIndex * 560;
	imgContainer.style.transform = `translateX(${xLength}px)`;
	paginationActive(currentPageIndex);
}

/* ----------------------------------------- QA ----------------------------------------- */

$(function() {

	var currentPage = 1;

	// QA分页
	$("#right-btn").click(function() {
		qaPage(1);
	});

	$("#left-btn").click(function() {
		qaPage(-1);
	});

	// QA Sort
	$('select').on('change', function() {
		qaPage(0);
		//$(this).value;
	});

	function qaPage(num) {

		var url = '/questionAndAnswer/list';
		var page = parseInt($("#currentPageHead").text());
		var totalPage = parseInt($("#totalPageHead").text());

		var value = parseInt($("#totalPageHead").text());

		if (num == 1) {
			currentPage++;
			if (currentPage > totalPage || currentPage == page) {
				currentPage = 1;
			}
		} else if (num == -1) {
			currentPage--;
			if (currentPage < 1) {
				currentPage = totalPage;
			} else if (currentPage == page) {
				currentPage = 1;
			}
		} else {
			currentPage = 1;
		}
		console.log(currentPage);

		if (value == 2) {
			var data = {
				"goodsId": 10700,
				"limit": 3,
				"page": currentPage,
				"orderByColumn": "submit_date",
				"ascOrDesc": "asc"
			}
		}

		var data = {
			"goodsId": 10700,
			"limit": 3,
			"page": currentPage,
			"orderByColumn": "help_num",
			"ascOrDesc": "desc"
		}

		$.ajax({
			type: 'POST',
			url: url,
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: function(resp) {
				if (resp.resultCode == 200) {
					var el;
					if (resp.data.list.length > 0) {
						$(".qa-step").find(".zv-qa").remove();
					}
					for (let i = 0; i < resp.data.list.length; i++) {
						el = $(".zv-qa-hidden").clone().removeClass("zv-qa-hidden");
						el.find(".q-text").html(resp.data.list[i].question);
						el.find("q-create-at").html(resp.data.list[i].submitDate);
						el.find(".a-text").html(resp.data.list[i].answer);
						el.find("a-create-at").html(resp.data.list[i].answerDate);
						el.find("#helpNum").html(resp.data.list[i].helpNum);
						el.click(help);
						$("#footStep").before(el);
					}
					$(".currentPage").text(currentPage);
				} else {
					swal(resp.message, {
						icon: "error",
					})
				}
			},
			error: function() {
				swal(resp.message, {
					icon: "error",
				})
			}
		});
	}

	// 質問を投稿
	$("#questionButton").click(function() {
		insertQuestion();
		alert("送信しました！");
	});

	function insertQuestion() {

		var url = '/insertQuestion';
		var question = $("#textArea").text();

		var data = {
			"goodsId": 10700,
			"question": question,
		}

		$.ajax({
			type: 'POST',
			url: url,
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: function(resp) {
				if (resp.resultCode == 200) {
					$(".q-text").text(question);
				} else {
					swal(resp.message, {
						icon: "error",
					})
				}
			},
			error: function() {
				swal(resp.message, {
					icon: "error",
				})
			}
		});
	}

});

function help() {
	qaHelpNum(this);
}

function initHelp(_this) {
	debugger;
	qaHelpNum(_this);
}

function qaHelpNum(_this) {

	var url = '/insertQaHelpNum';
	const questionId = $(_this).find('.question-id-hidden').text();
	//console.log(_this);	
	//console.log(questionId);	

	var data = {
		"goodsId": 10700,
		"questionId": questionId,
	}

	$.ajax({
		type: 'POST',
		url: url,
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(resp) {
			if (resp.resultCode == 200) {
				var newHelpNum = parseInt($(_this).parent().parent().find("#helpNum").text() + 1);
				$(_this).parent().parent().find("#helpNum").text(newHelpNum);
			} else {
				swal(resp.message, {
					icon: "error",
				})
			}
		},
		error: function() {
			swal(resp.message, {
				icon: "error",
			})
		}
	});
}

/* ------------------------------------ Goods Review ------------------------------------ */

$(function() {
	// Show More View
	$('.review-more-btn').click(function() {

		var url = '/goodsReview/list';

		var data = {
			"goodsId": 10700,
		}

		$.ajax({
			type: 'POST',
			url: url,
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: function(resp) {
				if (resp.resultCode == 200) {
					var list = resp.data;
					$(".review-more").show();
					for (i = 0; list.length; i++) {
						var el = $(".review-more").clone().removeClass(".review-more");
						el.find(".review-list-star").html(list[i].star);
						el.find(".review-user-id").html(list[i].reviewUserId);
						el.find(".review-date").html(list[i].submitDate);
						el.find(".review-list-info").html(list[i].goodsId);
						el.find(".review-list-title").html(list[i].reviewTitle);
						el.find(".review-list-detail").html(list[i].reviewDetail);
						el.find(".review-photo").html(list[i].imageUrl);
						el.find("#helpNum").html(list[i].helpNum);
						el.click(reviewhelp);
						$(".review-foot").before(el);
					}
					$(".review-more-btn").hide();
					$(".close-btn").show();
				} else {
					swal(resp.message, {
						icon: "error",
					})
				}
			},
			error: function() {
				swal(resp.message, {
					icon: "error",
				})
			}
		});
	});

	// Close Show More View
	$('.close-btn').click(function() {
		$(".review-more").hide();
		$(".review-more-btn").show();
		$(".close-btn").hide();
	});

	// Star
	//var starWidth = $('.review-average-star').width();
	//$('.review-average-star').width(starWidth);
	$('review-list-star').on('change', function() {
		rvStar();
	});

	function rvStar() {

		var url = '/goodsReview/averageStar';

		var data = {
			"goodsId": 10700,
		}

		$.ajax({
			type: 'POST',
			url: url,
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: function(resp) {
				if (resp.resultCode == 200) {
					//var averageStar = resp.data;
					$('.review-average-star-fill-ratings').css('width', '(resp.data / 5) * 100%');
				} else {
					swal(resp.message, {
						icon: "error",
					})
				}
			},
			error: function() {
				swal(resp.message, {
					icon: "error",
				})
			}
		});
	}

	// Upload Review Modal Picture
	new AjaxUpload('#loadFile', {
		action: '/admin/upload/reviewModalPic',
		name: 'file',
		autoSubmit: true,
		responseType: "json",
		onSubmit: function(file, extension) {
			if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
				alert('只支持jpg、png、gif格式的文件！');
				return false;
			}
		},
		onComplete: function(file, r) {
			if (r != null && r.resultCode == 200) {
				$("#rvUploadImg").attr("src", r.data);
				$("#rvUploadImg").attr("style", "width: 128px;height: 128px;display:block;");
				return false;
			} else {
				alert("error");
			}
		}
	});
	
    // insert review
	$("#modalSubmit").click(function() {
		insertReview();
		$(".modal-container").hide();
		alert("送信しました！");
	});

	function insertReview() {

		var url = '/insertGoodsReview';
		var star = $(".review-list-star").text();
		var reviewTitle = $(".review-list-title").text();
		var reviewDetail = $(".review-list-detail").text();
		var imageUrl = $(".review-photo").text();

		var data = {
			"goodsId": 10700,
			"star": star,
			"reviewTitle": reviewTitle,
			"reviewDetail": reviewDetail,
			"imageUrl": imageUrl,
		}

		$.ajax({
			type: 'POST',
			url: url,
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: function(resp) {
				if (resp.resultCode == 200) {
					$(".review-list-item").text();
				} else {
					swal(resp.message, {
						icon: "error",
					})
				}
			},
			error: function() {
				swal(resp.message, {
					icon: "error",
				})
			}
		});
	}

});

// Goods Review HelpNum
function reviewhelp() {
	reviewHelpNum(this);
}

function initReviewHelp(_this) {
	debugger;
	reviewHelpNum(_this);
}

function reviewHelpNum(_this) {

	var url = '/insertReviewHelpNum';
	const reviewId = $(_this).find('.review-id-hidden').text();

	var data = {
		"goodsId": 10700,
		"reviewId": reviewId,
	}

	$.ajax({
		type: 'POST',
		url: url,
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(resp) {
			if (resp.resultCode == 200) {
				var newNum = parseInt($(_this).find(".review-helpnum").text() + 1);
				$(_this).find(".review-helpnum").text(newNum);
			} else {
				swal(resp.message, {
					icon: "error",
				})
			}
		},
		error: function() {
			swal(resp.message, {
				icon: "error",
			})
		}
	});
}

// Modal
const reviewBtn = document.getElementById('reviewModalBtn');
const modal = document.getElementById('modal-container');
const closeBtn = document.getElementById('closeModal');

reviewBtn.addEventListener('click', openModal);
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
