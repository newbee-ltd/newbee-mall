

function loadQaPages(num) {

	var arr = window.location.href.split('/');
	var goodsId = parseInt(arr[arr.length - 1]);
	var sort = '';
	var pageNo = parseInt(document.getElementsByClassName("currentPageNo")[0].innerHTML);

				
	
	
	if(num===1 ||num===-1 ){
		pageNo = pageNo+num;
		sort = document.getElementById("zv-cqa-select-sort").value;
	}else{
		sort = document.getElementById("zv-cqa-select-sort").value;
	}
	
	var data = {
		"goodsId": goodsId,
		"sort": sort,
		"pageNo": pageNo
	};
	


	$.ajax({
		type: 'POST',//方法类型
		url: '/goods/qaList',
		contentType: 'application/json',
		data: JSON.stringify(data),

		success: function(result) {
			

			if (result.resultCode == 200) {
					var totalPage = result.data.totalPageNo;
					
				if(pageNo>1){
					$(".zv-cqa-arrow-left").show();
				}else if(pageNo=1){
					$(".zv-cqa-arrow-left").hide();
				}
				if(pageNo<totalPage){
					$(".zv-cqa-arrow-right").show();
				}else if(pageNo=totalPage){
					$(".zv-cqa-arrow-right").hide();
				}
					var list = result.data.qaList;
					$("#ZVCQuestionsArea").find(".zv-cqa").remove();
					for (var i = 0; i < list.length; i++) {
						var cloneEl = $(".hiddenQaDiv").clone();
						cloneEl.find(".zv-cqa-q-text").text(list[i].question);
						cloneEl.find(".zv-cqa-q-created-at").text(list[i].questionDate);
						cloneEl.find(".zv-cqa-a-text").text(list[i].answer);
						cloneEl.find(".zv-cqa-a-created-at").text(list[i].answerDate);
						cloneEl.find("#ZVHelpfulYesNum-206077").text(list[i].count);
						cloneEl.removeClass("hiddenQaDiv");
						cloneEl.find(".hiddenQaId").val(list[i].qaId);
						cloneEl.find(".zv-helpful-yes")[0].setAttribute('onclick', 'helpNumClickFunc(' + goodsId + ',' + list[i].qaId + ')');
						$("#detailFooter").before(cloneEl);
						$(".currentPageNo").text(pageNo);
						



					}
				
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

/*function qaPage(num) {
	var arr = window.location.href.split('/');
	var goodsId = parseInt(arr[arr.length - 1]);
	var currentPage = parseFloat(document.getElementById("currentPageNo").innerHTML);
	var pageNo = 0;
	var sort = '';
	if(num==1 ){
		loadQaPages("right");
	}else if(num=-1){
		loadQaPages("left")
		
	}else{
		sort = document.getElementById("zv-cqa-select-sort").value;
	}
	var data = {
		"goodsId": goodsId,
		"sort": sort
	}
		$.ajax({
		type: 'POST',//方法类型
		url: '/goods/helpNum',
		contentType: 'application/json',
		data: JSON.stringify(data)
		})
}*/

function helpNumClickFunc(goodsId, qaId) {

	var data = {
		"goodsId": goodsId,
		"qaId": qaId
	}
	var _this = $("#ZVHelpfulYesNum-206077");
	$.ajax({
		type: 'POST',//方法类型
		url: '/goods/helpNum',
		contentType: 'application/json',
		data: JSON.stringify(data),

		success: function(result) {
			if (result.resultCode == 200) {
				/*_this.text("参考になった（"+qaId+"人)");*/
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



function qaClick() {
	var questionText = document.getElementById("ZVQuestionTextarea").value;

	if (questionText != '') {
		insertQa();
	} else {
		swal("操作失败", {
			icon: "error",
		});
	}
}

function insertQa() {
	var arr = window.location.href.split('/');
	var goodsId = parseInt(arr[arr.length - 1]);
	var data = {
		"goodsId": goodsId,
	};
	$.ajax({
		type: 'POST',//方法类型
		url: '/goods/insertGoodsQa',
		contentType: 'application/json',
		data: JSON.stringify(data),

		success: function(result) {

			if (result.resultCode == 200) {
				swal(result.message, {
					icon: "提问成功",
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