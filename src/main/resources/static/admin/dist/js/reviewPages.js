
var btContent;
function showReview() {

	var arr = window.location.href.split('/');
	var goodsId = parseInt(arr[arr.length - 1]);
	var data = {
		"goodsId": goodsId,
	}
	



	if ($("#showMore").text() === "閉じる") {
		
		$("#p-reviewMore").find(".reviewMoreLi-item").remove();
		$("#showMore").text(btContent);
		console.log(btContent);
		$(".g-i-arrow-d2").attr('class', 'g-i-arrow-d');
		return;
	}
	
	/*$("#p-reviewMore").find(".reviewMoreLi").not("#hiddenReviewLi").remove();*/
	
	else {
		btContent = $("#showMore").text();
		console.log(btContent);
		$.ajax({
			type: 'POST',//方法类型
			url: '/goods/goodsReview',
			contentType: 'application/json',
			data: JSON.stringify(data),

			success: function(result) {

				if (result.resultCode == 200) {
					var list = result.data.reviewList;

					for (var i = 3; i < list.length; i++) {
						var cloneEl = $(".hiddenReviewLi").clone();
						cloneEl.find("#reviewUserId").text(list[i].userId);
						cloneEl.find("#reviewDate").text(list[i].reviewDate);
						cloneEl.find(".g-reviewList_h").text(list[i].reviewTitle);
						cloneEl.find("#review").text(list[i].review);
						cloneEl.find(".p-review-gallery_photo").attr('src', list[i].image);

						cloneEl.removeClass("hiddenReviewLi");
						cloneEl.addClass("reviewMoreLi-item")
						cloneEl.css("display", "list-item");
						cloneEl.find(".hiddenReviewId").val(list[i].reviewId);
						cloneEl.find(".g-reviewList_like")[0].setAttribute('onclick','reviewLikeNum('+goodsId+','+list[i].reviewId+')');
						$("#hiddenReviewLi").before(cloneEl);
						$(".g-i-arrow-d").attr('class', 'g-i-arrow-d2');
						$("#showMore").text("閉じる");

					}

				} else {
					swal(result.message, {
						icon: "error",
					});
				};

			},
			error: function() {
				swal("操作失败", {
					icon: "error",
				});
			}

		});
	}
}

function reviewLikeNum(goodsId,reviewId){
	var data = {
		"goodsId":goodsId,
		"reviewId": reviewId
	}
	$.ajax({
			type: 'POST',//方法类型
			url: '/goods/likeNum',
			contentType: 'application/json',
			data: JSON.stringify(data),

			success: function(result) {
 
				if (result.resultCode == 200) {
						swal(result.message, {
						icon: "点赞成功",
					});
					}

				else {
					swal(result.message, {
						icon: "error",
					});
				}
			}
		});
	
}

function showReviewModal(){
	$('#orderInfoModal').modal('show');
}





function starRating(e){
	var classNames = e.target.className;
	var classNameArr = [];
	classNameArr = classNames.split(" ");
	if(classNameArr.includes("checked")){
		var starNum = classNameArr[classNameArr.length-2];
		var num = starNum.replace("star","");
	}else{
		var starNum = classNameArr[classNameArr.length-1];
		var num = starNum.replace("star","");
	}

	
	for(var i = 5;i>=1;i--){
		var el = document.getElementsByClassName("star"+i);
		if(!el[0].classList.contains("checked")){
			if(i<=num){
				el[0].classList.add("checked");
			}else{
			el[0].classList.remove("checked");
		}
		}else{
			for(i=5;i>=num;i--)
			el[0].classList.remove("checked");
		}

	}
}






$.fn.stars = function() { 
  return this.each(function() {
    // Get the value
    var val = parseFloat($(this).html()); 
    // Make sure that the value is in 0 - 5 range, multiply to get width
    var size = Math.max(0, (Math.min(5, val))) * 18.4; 
    // Create stars holder
    var $span = $('<span> </span>').width(size); 
    // Replace the numerical value with stars
    $(this).empty().append($span);
  });
}

$(function() {
  console.log("Calling stars()");
  $('.results-content span.stars').stars();
});



new AjaxUpload('#uploadCarouselImage', {
        action: '/upload/reviewImage',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                alert('只支持jpg、png、gif格式的文件！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r != null && r.resultCode == 200) {
                $("#carouselImg").attr("src", r.data);
                $("#carouselImg").attr("style", "width: 128px;height: 128px;display:block;");
                return false;
            } else {
                alert("error");
            }
        }
    })
    
    
    function insertReview() {
	var arr = window.location.href.split('/');
	var goodsId = parseInt(arr[arr.length - 1]);
	var reviewTitle = $("#totalPrice").val();
	var review = $("#reviewContent").val();
	var reviewImage = $('#carouselImg').attr('src');
	var data = {
		"goodsId": goodsId,
		"reviewTitle": reviewTitle,
		"review": review,
		"image":reviewImage
	};
	$.ajax({
		type: 'POST',//方法类型
		url: '/goods/insertGoodsReview',
		contentType: 'application/json',
		data: JSON.stringify(data),

		success: function(result) {

			if (result.resultCode == 200) {
				swal(result.message, {
					icon: "评论成功",
				});
			}

			else {
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