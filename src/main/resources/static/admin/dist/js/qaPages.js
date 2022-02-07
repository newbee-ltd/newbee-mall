

function loadQaPages(leftOrRight) {

	var arr = window.location.href.split('/');
	var goodsId = parseInt(arr[arr.length - 1]);
	var sort = document.getElementById("zv-cqa-select-sort").value;
	var pageNo = document.getElementById("currentPageNo").innerHTML;
	var data = {
		"goodsId": goodsId,
		"sort": sort,
		"pageNo": pageNo
	};
	/*var qaId = $(".hiddenQaId").text();*/


	if (leftOrRight === 'right') {
		$.ajax({
			type: 'POST',//方法类型
			url: '/goods/qaList',
			contentType: 'application/json',
			data: JSON.stringify(data),

			success: function(result) {

				if (result.resultCode == 200) {
					$("#ZVCQA i.zv-cqa-arrow-left").css("display", "inline-block");
					var list = result.data.qaList;
					$("#ZVCQuestionsArea").find(".zv-cqa").remove();
					for (var i = 3; i < list.length; i++) {
						var cloneEl = $(".hiddenQaDiv").clone();
						cloneEl.find(".zv-cqa-q-text").text(list[i].question);

						cloneEl.find(".zv-cqa-a-text").text(list[i].answer);
						cloneEl.removeClass("hiddenQaDiv");
						cloneEl.find(".hiddenQaId").val(list[i].qaId);
						cloneEl.find(".zv-helpful-yes")[0].setAttribute('onclick','helpNumClickFunc('+goodsId+','+list[i].qaId+')');
						$("#detailFooter").before(cloneEl);

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
	if (leftOrRight === 'left') {
		$.ajax({
			type: 'POST',//方法类型
			url: '/goods/qaList',
			contentType: 'application/json',
			data: JSON.stringify(data),

			success: function(result) {

				if (result.resultCode == 200) {
					$("#ZVCQA i.zv-cqa-arrow-left").css("display", "none");
					var list = result.data.qaList;
					$("#ZVCQuestionsArea").find(".zv-cqa").remove();
					for (var i = 0; i < 3; i++) {
						var cloneEl = $(".hiddenQaDiv").clone();
						cloneEl.find(".zv-cqa-q-text").text(list[i].question);

						cloneEl.find(".zv-cqa-a-text").text(list[i].answer);
						cloneEl.removeClass("hiddenQaDiv");
						cloneEl.find(".hiddenQaId").val(list[i].qaId);
						cloneEl.find(".zv-helpful-yes")[0].setAttribute('onclick','helpNumClickFunc('+goodsId+','+list[i].qaId+')');
						$("#detailFooter").before(cloneEl);

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
}

function helpNumClickFunc(goodsId,qaId) {
	
	var qaId = $(this).parent().find(".hiddenQaId").text();
	var data = {
		"goodsId":goodsId,
		"qaId": qaId
	}
	var _this = $("#ZVHelpfulYesNum");
	$.ajax({
			type: 'POST',//方法类型
			url: '/goods/userId',
			contentType: 'application/json',
			data: JSON.stringify(data),

			success: function(result) {
 
				if (result.resultCode == 200) {
					_this.text("参考になった（"+qaId+"人)");

					}

				else {
					swal(result.message, {
						icon: "error",
					});
				}
			}
		});
}