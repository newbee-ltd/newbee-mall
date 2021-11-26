// Dynamically setting iconLevel
/*
var idCount = 1;
$(".iconLevel").each(function() {
	$(this).attr("id", "iconLevel1-" + idCount);
	idCount++;
});
*/

// Onclick
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
					let hiddenDiv = $("#hidden-div").clone();
					for (let i = 0; i < list.length; i++) {
						el = $(".next-container").clone().removeClass("next-container");
						
						if ('goodsId' in list[i]) {
							el.find("#category2").html(list[i].goodsName);
							el.find('.parentId-hidden').text(list[i].goodsId);
							el.find(".fa-plus-square").hide();
						} else {
							el.find("#category2").html(list[i].categoryName);
							el.find('.parentId-hidden').text(list[i].categoryId);
						}
 						
 						// 每个icon id生成的规则
 						var idAttr = $(_this).attr('id'); // returns iconLevel1_1
 						var iconLevel1 = idAttr.substring(9, 10); //iconLevel1_1的第1个数字
 						var iconLevel2 = idAttr.substring(11, 12); //iconLevel1_1的第2个数字
 						var divLevel = parseInt(iconLevel1) + 1; // 结果得到2_1 里面的2
 						var divPrifxi = divLevel + "_" + iconLevel2; // 2_1
 						el.find(".far").attr("id", "iconLevel" + divPrifxi + "_" + (i + 1)); //iconLevel2_1_1
 						
						select.clone().val(list[i].campaignId).appendTo(el.find('#dropDownList2'));
						
						for (let j = 0; j < camList.length; j++) {
							if (camList[j].value == list[i].campaignId) {
								el.find(".dropDownList2").val(list[i].categoryId).prop('selected', true);
							}
						}
						
						if (list[i].campaignId != 0) {
							el.find(".checkbox2").val(list[i].categoryId).prop('checked', true);
						} else {
							el.find(".checkbox2").val(list[i].categoryId).prop('checked', false);
						}

						el.show();
						hiddenDiv.append(el);
						el.css({ "display": "flex", "flex-direction": "row", "flex-wrap": "nowrap" });
						//$(this).attr("id", "iconLevel" + hiddenDiv + divLevel + iconLevel);
					}

					hiddenDiv.appendTo($("body"));
					hiddenDiv.show();
					hiddenDiv.addClass("second-div");
					$(".init-container").css({ 'opacity': '0.5' });

					// Position a div in a specific coordinates
					//var rect1 = document.getElementById('showMore');
					var rect2Top = _this.getBoundingClientRect().top;
					var rect2Left = _this.getBoundingClientRect().right;
					hiddenDiv[0].style.position = "absolute";
					hiddenDiv[0].style.top = rect2Top + 'px';
					hiddenDiv[0].style.left = rect2Left + 'px';
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
		$(".second-div").remove();
		$(".init-container").css({ 'opacity': '1' });
	}
}
