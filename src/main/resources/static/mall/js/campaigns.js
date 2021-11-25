// Onclick (Page1 Page2)
function showMore(_this) {
	// Click Plus
	if ($(_this).hasClass('fa-plus-square')) {
		$(_this).removeClass('fa-plus-square');
		$(_this).addClass('fa-minus-square');

		var url = '/campaigns';
		var parentId = parseInt($(_this).find('.parentId-hidden').text());
		//var camList = $(_this).parent().find('.camDropDownList');
		//var initContainer = $(_this).parent().parent();

		var data = {
			"parentId": parentId
		}

		let camList = {
			"0": "",
			"1": "每满200减30",
			"2": "买一送一",
			"3": "领劵满199减25",
			"4": "打折",
			"5": "买3件1000"
		}

		$.ajax({
			type: 'GET',
			url: url,
			contentType: 'application/json',
			data: data,
			success: function(resp) {
				if (resp.resultCode == 200) {
					var list = resp.data;

					var select = $('<select/>');
					for (let val in camList) {
						$('<option/>', { value: val, text: camList[val] }).appendTo(select);
					}

					let el;
					let secondContainer = $("#hidden-div2").clone();
					for (let i = 0; i < list.length; i++) {
						el = $(".second-container").clone().removeClass("second-container");
						if ('goodsId' in list[i]) {
							el.find("#category2").html(list[i].goodsName);
						} else {
							el.find("#category2").html(list[i].categoryName);
						}
						
						if (list[i].campaignId != 0) {
							el.find(".checkbox2").val(list[i].categoryId).prop('checked', true);
						} else {
							el.find(".checkbox2").val(list[i].categoryId).prop('checked', false);
						}
						
						select.clone().val(list[i].campaignId).appendTo(el.find('#dropDownList2'));
						el.show();
						secondContainer.append(el);
						el.css({ "display": "flex", "flex-direction": "row", "flex-wrap": "nowrap" });
					}
					secondContainer.appendTo($("body"));
					secondContainer.show();
					secondContainer.addClass("currentShow");
					$(".init-container").css({ 'opacity': '0.5' });
 					
 					// Position a div in a specific coordinates
					//var rect1 = document.getElementById('showMore');
					var rect2Top = _this.getBoundingClientRect().top;
					var rect2Left = _this.getBoundingClientRect().right;
					secondContainer[0].style.position = "absolute";
					secondContainer[0].style.top = rect2Top + 'px';
					secondContainer[0].style.left = rect2Left + 'px';
					
					/*
							for (let j = 0; j < camList.length; j++) {
								if (camList[j].value == list[i].campaignId) {
									value = list[i].campaignId;
								}
							}
							*/

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
	} else {
		// Click Minus
		$(_this).removeClass('fa-minus-square');
		$(_this).addClass('fa-plus-square');
		$(".currentShow").remove();
		$(".init-container").css({ 'opacity': '1' });
		$(".currentGoods").remove();
		$(".currentGoodsCategory").remove();
	}
}

