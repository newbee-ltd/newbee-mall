function customSelectboxRenderer(){
	
	$.ajax({
            type: 'POST',//方法类型
            url: '/admin/goodsCampaign/campaignList',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                if (result.resultCode == 200) {
					var data = result.data.goodsCampaignVOList;
					var rs = "<select name='cars' id='cars'>";
					for(var i=0;i<data.length;i++){
						rs = rs + "option value='" + data[i].calId + "'>"+data[i].cal1+"</option>";
					}
					rs = rs + "</select>";
					return rs;	
                } 
                
            },
        });
}

function searchResult(){
	var keyword = $("#searchByKeyWord").val();
	
	$("#jqGrid").jqGrid({
  
        url: '/admin/goodsCampaign/list?keyword=' + keyword,
        datatype: "json",
        colModel: [
            {label: '商品单号', name: 'goodsId', index: 'goodsId', width: 120,key: true},
            {label: '商品名称', name: 'goodsName', index: 'goodsName', width: 120},
            {label: 'campaignId', name: 'camId', index: 'camId', width: 120},
            {label: '促销内容', name: 'cal1', index: 'cal1', width: 120,formatter: customSelectboxRenderer}
        ],
        height: 560,
        rowNum: 10,
        rowList: [10, 20, 50],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: false,
        rownumWidth: 20,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order",
        },
        loadComplete: function() {
        var dataArr = $("#jqGrid").jqGrid('getRowData');
        var dataIDs = jQuery("#jqGrid").getDataIDs();
        for(var i = 0;i<dataArr.length;i++){
			var camId = dataArr[i]['camId'];
			if(camId!=0){
				$("#jqGrid").jqGrid('setSelection',dataIDs[i],true);
			}
			}      
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
}
/*function getAllSelectOptions(){
 var campaigns = { '1': '30%割引', '2': '满3000减100', '3': '返回20%积分', 
               '4': '满200减10元', '5': '满2000免运费', '6': '10%割引', '7': '20%割引', '8': '满1000减10', 
               '9': '返还5%积分', '10': '满3000减50', '11': '满500减15', '12': '满550免运费', '13': '满1500减50'};

  return campaigns;

} */

function selectCam(){
	var cal1 = $('#selectCam :selected').text();
	var camId = $('#selectCam :selected').val();
	var goodsId =getSelectedRow();
	var data = {
            "cal1": cal1,
            "camId": camId,
            "goodsId": goodsId
        };
        $.ajax({
            type: 'POST',//方法类型
            url: '/admin/goodsCampaign/update',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                if (result.resultCode == 200) {
					$(".btn-info").click();
                    swal("更新成功", {
                        icon: "success",
                    });
                } else {
                    swal(result.message, {
                        icon: "error",
                    });
                }
                ;
            },
            error: function () {
                swal("操作失败", {
                    icon: "error",
                });
            }
        });
    }

	


