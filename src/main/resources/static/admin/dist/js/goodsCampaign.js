function customSelectboxRenderer(){
	var rs = "<select name='selections' id='selections'>";
	$.ajax({
            type: 'POST',//方法类型
            url: '/admin/goodsCampaign/campaignList',
            contentType: 'application/json',
            /*data: JSON.stringify(data),*/
            async: false,
            success: function (result) {
                if (result.resultCode == 200) {
					var data = result.data;
					
					for(var i=0;i<data.length;i++){
						rs = rs + "<option value='" + data[i].camId + "'>"+data[i].cal1+"</option>";
					}
				rs = rs + "</select>";
				
                }    
            },
        });
    return rs;	
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
            {label: '当前促销', name: 'cal1', index: 'cal1', width: 120, formatter: customSelectboxRenderer}
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
	    $('#jqGrid').find('input[type="checkbox"]').hide();
        var dataArr = $("#jqGrid").jqGrid('getRowData');
        var dataIDs = jQuery("#jqGrid").getDataIDs();
        for(var i = 0;i<dataArr.length;i++){
			var camId = dataArr[i].camId;
			if(camId!=0){
				/*$("#jqGrid").jqGrid('setSelection',dataIDs[i],true);*/
				$("#"+dataArr[i].goodsId).find("#selections").val(dataArr[i].camId);
			}
			}      
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
}

function selectCam(){
	var dataArr = $("#jqGrid").jqGrid('getRowData');
	var flag = null;
	var dataIDs = jQuery("#jqGrid").getDataIDs();
	var data =[];
	for(var i = 0;i<dataArr.length;i++){
		flag = null;
		var camId = dataArr[i].camId;
		var selectedVal = $("#"+dataArr[i].goodsId).find("#selections").val();
		var goodsId = dataIDs[i];
		if (camId !=0&&camId!=selectedVal&&selectedVal!=0) {
			flag = 0;
			camId = selectedVal;
		}
		if(camId ==0&&selectedVal!=0){
			flag = 1;
			camId = selectedVal;
		}
		if(camId!=0&&selectedVal==0){
			flag = 2;
			camId = 0;
		}
			
		data.push({
		"flag":flag,
		"camId":camId,
		"goodsId":goodsId
	    })
	        
	}
			
			
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
            };
            },
     error: function () {
            swal("操作失败", {
                icon: "error",
             });
         }
        });
			


    }

	


