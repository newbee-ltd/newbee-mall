
function searchResult(){
	var keyword = $("#searchByKeyWord").val();
	jQuery("#jqGrid").jqGrid("clearGridData");
	
	$("#jqGrid").jqGrid({
		
	    
        url: '/admin/goodsCampaign/list?keyword=' + keyword,
        datatype: "json",
        colModel: [
            {label: '商品单号', name: 'goodsId', index: 'goodsId', width: 120},
            {label: '商品名称', name: 'goodsName', index: 'goodsName', width: 120},
            {label: 'campaignId', name: 'camId', index: 'camId', width: 120,key: true},
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
	var cam = $('#cars :selected').text();
	var camId = $('#cars :selected').val();
}

