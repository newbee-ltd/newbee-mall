
function searchResult(){
	var keyword = $("#searchByKeyWord").val();
	
	$("#jqGrid").jqGrid({
		
	    
        url: '/admin/goodsCampaign/list?keyword=' + keyword,
        datatype: "json",
        colModel: [
            {label: '商品单号', name: 'goodsId', index: 'goodsId', width: 120,key: true},
            {label: '商品名称', name: 'goodsName', index: 'goodsName', width: 120},
            {label: 'campaignId', name: 'camId', index: 'camId', width: 120},
            {label: '促销内容', name: 'cal1', index: 'cal1', width: 120}
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
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
} 

function selectCam(){
	var cal1 = $('#cars :selected').text();
	var camId = $('#cars :selected').val();
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

	


