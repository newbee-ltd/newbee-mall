$(function() {


});

function show1(_this) {
	let cbox1 = $(_this).parent().find('#cbox1');
	//cbox1.attr("checked", !cbox1.attr("checked"));
	if ($(_this).hasClass('fa-plus-circle')) {
		$(_this).removeClass('fa-plus-circle');
		$(_this).addClass('fa-minus-circle');

		//let parentId = $(_this).parent().find('select option:selected');
		let parentId = parseInt(cbox1.val());
		let data = {
			'parentId': parentId
		};

		let campaign = {
			'0': '--キャンペーン--',
			'1': '1 每满200减30',
			'2': '2 买一送一',
			'3': '3 领券满199减20',
			'4': '4 25%折扣',
		}

		$.ajax({
			type: 'GET',
			url: "/applyCampaign",
			contentType: 'application/json',
			//data: JSON.stringify(data),
			data: data,
			success: function(result) {
				if (result.resultCode == 200) {
					//console.log(result.data);
					let s = $('<select />');
					//console.log(s);
					for (let val in campaign) {
						$('<option />', { value: val, text: campaign[val] }).appendTo(s);
					}
					//s.appendTo('#show1-opt');

					//if (result.data.length > 0) {
					//	$(".show1-div").remove();
					//}
					let se = $('<section />');

					let el;
					for (let i = 0; i < result.data.length; i++) {
						el = $('.hidden-show1').clone().removeClass("hidden-show1");
						if ('goodsId' in result.data[i]) {
							el.find('#show1-cbox').text(result.data[i].goodsName);
							el.find('#show1-cbox').val(result.data[i].goodsId);
							if (result.data[i].campaignId == 2) {
								el.find('.present').removeClass('present');
							}
						} else {
							el.find('#show1-cbox').text(result.data[i].categoryName);
							el.find('.plus2').addClass('plus2-1');
							el.find('.plus2').removeClass('plus2');
							if (result.data[i].campaignId == 2) {
								el.find('.present').removeClass('present');
							}
						}

						//s.find('option').val() == result.data[i].campaignId;
						//		let value;
						//		for (let j = 0; j < campaign.length; j++) {
						//			if (campaign[j].value == result.data[i].campaignId) {
						//				value = result.data[i].campaignId;
						//			}
						s.clone().val(result.data[i].campaignId).appendTo(el.find('#show1-opt'));
						//		}

						// const result =campaign.filter(cam=>cam.campaignId==result.data[i].campaignId)
						// s.clone().val(result[0]);

						if (result.data[i].campaignId != 0) {
							el.find('#cbox2').val(result.data[i].categoryId).prop('checked', true);
						} else {
							el.find('#cbox2').val(result.data[i].categoryId).prop('checked', false);
						}

						//el.find('#show1-opt').append(s);
						//$(_this).after(el);
						$(_this).after(se);
						se.addClass('show1-sec');
						el.appendTo(se);

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
	else {
		$(_this).removeClass('fa-minus-circle');
		$(_this).addClass('fa-plus-circle');
		$(_this).nextAll().remove();
	}
}

function show2(_this) {

	let cbox3 = $(_this).parent().parent().find('#cbox2');

	if ($(_this).hasClass('fa-plus-circle')) {
		$(_this).removeClass('fa-plus-circle');
		$(_this).addClass('fa-minus-circle');

		let parentId = parseInt(cbox3.val());
		let data = {
			'parentId': parentId
		};

		let campaign = {
			'0': '--キャンペーン--',
			'1': '1 每满200减30',
			'2': '2 买一送一',
			'3': '3 领券满199减20',
			'4': '4 25%折扣',
		}

		$.ajax({
			type: 'GET',
			url: "/applyCampaign",
			contentType: 'application/json',
			data: data,
			success: function(result) {
				if (result.resultCode == 200) {
					let s = $('<select />');

					for (let val in campaign) {
						$('<option />', { value: val, text: campaign[val] }).appendTo(s);
					}

					let se = $('<section />');

					let el;
					for (let i = 0; i < result.data.length; i++) {
						el = $('.hidden-show2').clone().removeClass("hidden-show2");
						if ('goodsId' in result.data[i]) {
							el.find('#show2-cbox').text(result.data[i].goodsName);
							if (result.data[i].campaignId == 2) {
								el.find('.present').removeClass('present');
							}
						} else {
							el.find('#show2-cbox').text(result.data[i].categoryName);
							el.find('.plus3').addClass('plus2-1');
							el.find('.plus3').removeClass('plus3');
						}

						s.clone().val(result.data[i].campaignId).appendTo(el.find('#show2-opt'));

						if (result.data[i].campaignId != 0) {
							el.find('#cbox3').val(result.data[i].categoryId).prop('checked', true);
						} else {
							el.find('#cbox3').val(result.data[i].categoryId).prop('checked', false);
						}

						$(_this).after(se);
						se.addClass('show2-sec');
						el.appendTo(se);
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
	else {
		$(_this).removeClass('fa-minus-circle');
		$(_this).addClass('fa-plus-circle');
		$(_this).nextAll().remove();
	}
}

function show3(_this) {

	let cbox4 = $(_this).parent().parent().find('#cbox3');

	if ($(_this).hasClass('fa-plus-circle')) {
		$(_this).removeClass('fa-plus-circle');
		$(_this).addClass('fa-minus-circle');

		let parentId = parseInt(cbox4.val());
		let data = {
			'parentId': parentId
		};

		//可以写一个隐藏的框吧campaign获取到后再遍历
		let campaign = {
			'0': '--キャンペーン--',
			'1': '1 每满200减30',
			'2': '2 买一送一',
			'3': '3 领券满199减20',
			'4': '4 25%折扣',
		}

		$.ajax({
			type: 'GET',
			url: "/applyCampaign",
			contentType: 'application/json',
			data: data,
			success: function(result) {
				if (result.resultCode == 200) {
					let s = $('<select />');

					for (let val in campaign) {
						$('<option />', { value: val, text: campaign[val] }).appendTo(s);
					}

					let se = $('<section />');

					let el;
					for (let i = 0; i < result.data.length; i++) {
						el = $('.hidden-show3').clone().removeClass("hidden-show3");
						if ('goodsId' in result.data[i]) {
							el.find('#show3-cbox').text(result.data[i].goodsName);
						} else {
							el.find('#show3-cbox').text(result.data[i].categoryName);
						}

						s.clone().val(result.data[i].campaignId).appendTo(el.find('#show3-opt'));

						if (result.data[i].campaignId != 0) {
							el.find('#cbox4').val(result.data[i].categoryId).prop('checked', true);
						} else {
							el.find('#cbox4').val(result.data[i].categoryId).prop('checked', false);
						}

						$(_this).after(se);
						se.addClass('show3-sec');
						el.appendTo(se);
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
	else {
		$(_this).removeClass('fa-minus-circle');
		$(_this).addClass('fa-plus-circle');
		$(_this).nextAll().remove();
	}
}

function present(_this) {
	$('.hidden-modal').css('display', "block");
	let mainName = $(_this).parent().parent().find('.show-cbox').text();
	let mainId = $(_this).parent().parent().find('.show-cbox').val();
	$('#mainName').val(mainId + " " + mainName);
	//console.log($('#present-opt').val())
}

function closeModal() {
	$('.hidden-modal').css('display', "none");
}

let hiddenModal = document.querySelector('.hidden-modal');
window.onclick = function(event) {
	if (event.target == hiddenModal) {
		$('.hidden-modal').css('display', "none");
	}
}

function changePresent(_this) {
	//console.log($(_this).find('option:selected').text())
}

function submitPresent() {
	let mainName = $('#mainName').val();
	let presentName;
	let presentVal = parseInt($('#present-sel').find('option:selected').val());
	if (presentVal !== 0) {
		presentName = $('#present-sel').find('option:selected').text();

		//let presentList = new Array();
		//presentList.push(mainName);
		//presentList.push(presentName);
		let goodId = mainName.substr(0, 5);
		let freeGoodsId = presentName.substr(0, 5);

		let data = {
			"buyGoodsId": goodId,
			"freeGoodsId": freeGoodsId
		}

		$.ajax({
			type: 'PUT',
			url: "/updateBGS",
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: function(result) {
				if (result.resultCode == 200) {

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


	} else {
		swal("请选择一个赠品", {
			icon: "error",
		});
	}

}