$(function () {
    $("#jqGrid").jqGrid({
	    
        url: '/admin/campaign/list',
        datatype: "json",
        colModel: [
            {label: 'campaignId', name: 'camId', index: 'camId', width: 120,key: true},
            {label: '促销名称', name: 'camName', index: 'camName', width: 120},
            {label: '促销类型', name: 'camKind', index: 'camKind', width: 120},
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
    })
    
function campaignAdd() {
    $('.modal-title').html('添加促销活动');
    $('#campaignModal').modal('show');
}

function insertCampaign(){
	var camName = $("#categoryRank").val();
	var cal1 = $("#camContent").val();
	var data = {
		"camName": camName,
		"cal1":cal1
	};
	$.ajax({
		type: 'POST',//方法类型
		url: '/admin/campaign/save',
		contentType: 'application/json',
		data: JSON.stringify(data),

		success: function(result) {

			if (result.resultCode == 200) {
				swal(result.message, {
					icon: "添加成功",
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

function campaignEdit() {
    $('.modal-title').html('修改促销活动');
    $('#editCampaignModal').modal('show');
    var camId = getSelectedRow();
	$("#campaignId").text(camId);
}

function editCampaign(){
	var camName = $("#camName").val();
	var cal1 = $("#newCampaign").val();
	var camId = getSelectedRow();
	$("#campaignId").text(camId);
	var data = {
		"camName": camName,
		"cal1":cal1,
		"camId":camId
	};
	$.ajax({
		type: 'POST',//方法类型
		url: '/admin/campaign/edit',
		contentType: 'application/json',
		data: JSON.stringify(data),

		success: function(result) {

			if (result.resultCode == 200) {
				swal(result.message, {
					icon: "修改成功",
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

function deleteCampaign() {

    var ids = getSelectedRows();
    console.log(ids.length);
    if (ids == null) {
        return;
    }
    swal({
        title: "确认弹框",
        text: "确认要删除数据吗?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((flag) => {
            if (flag) {
                $.ajax({
                    type: "POST",
                    url: "/admin/campaign/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.resultCode == 200) {
                            swal("删除成功", {
                                icon: "success",
                            });
                            $("#jqGrid").trigger("reloadGrid");
                        } else {
                            swal(r.message, {
                                icon: "error",
                            });
                        }
                    }
                });
            }
        }
    )
    ;
}