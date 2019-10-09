$(function () {
    $("#jqGrid").jqGrid({
        url: '/admin/carousels/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'carouselId', index: 'carouselId', width: 50, key: true, hidden: true},
            {label: '轮播图', name: 'carouselUrl', index: 'carouselUrl', width: 180, formatter: coverImageFormatter},
            {label: '跳转链接', name: 'redirectUrl', index: 'redirectUrl', width: 120},
            {label: '排序值', name: 'carouselRank', index: 'carouselRank', width: 120},
            {label: '添加时间', name: 'createTime', index: 'createTime', width: 120}
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

    function coverImageFormatter(cellvalue) {
        return "<img src='" + cellvalue + "' height=\"120\" width=\"160\" alt='coverImage'/>";
    }

    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });

    new AjaxUpload('#uploadCarouselImage', {
        action: '/admin/upload/file',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                alert('只支持jpg、png、gif格式的文件！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r != null && r.resultCode == 200) {
                $("#carouselImg").attr("src", r.data);
                $("#carouselImg").attr("style", "width: 128px;height: 128px;display:block;");
                return false;
            } else {
                alert("error");
            }
        }
    });
});

/**
 * jqGrid重新加载
 */
function reload() {
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        page: page
    }).trigger("reloadGrid");
}

function carouselAdd() {
    reset();
    $('.modal-title').html('轮播图添加');
    $('#carouselModal').modal('show');
}

//绑定modal上的保存按钮
$('#saveButton').click(function () {
    var redirectUrl = $("#redirectUrl").val();
    var carouselRank = $("#carouselRank").val();
    var carouselUrl = $('#carouselImg')[0].src;
    var data = {
        "carouselUrl": carouselUrl,
        "carouselRank": carouselRank,
        "redirectUrl": redirectUrl
    };
    var url = '/admin/carousels/save';
    var id = getSelectedRowWithoutAlert();
    if (id != null) {
        url = '/admin/carousels/update';
        data = {
            "carouselId": id,
            "carouselUrl": carouselUrl,
            "carouselRank": carouselRank,
            "redirectUrl": redirectUrl
        };
    }
    $.ajax({
        type: 'POST',//方法类型
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            if (result.resultCode == 200) {
                $('#carouselModal').modal('hide');
                swal("保存成功", {
                    icon: "success",
                });
                reload();
            } else {
                $('#carouselModal').modal('hide');
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
});

function carouselEdit() {
    reset();
    var id = getSelectedRow();
    if (id == null) {
        return;
    }
    reset();
    //请求数据
    $.get("/admin/carousels/info/" + id, function (r) {
        if (r.resultCode == 200 && r.data != null) {
            //填充数据至modal
            $("#carouselImg").attr("src", r.data.carouselUrl);
            $("#carouselImg").attr("style", "height: 64px;width: 64px;display:block;");
            $("#redirectUrl").val(r.data.redirectUrl);
            $("#carouselRank").val(r.data.carouselRank);
        }
    });
    $('.modal-title').html('轮播图编辑');
    $('#carouselModal').modal('show');
}

function deleteCarousel() {
    var ids = getSelectedRows();
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
                    url: "/admin/carousels/delete",
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


function reset() {
    $("#redirectUrl").val('##');
    $("#carouselRank").val(0);
    $("#carouselImg").attr("src", '/admin/dist/img/img-upload.png');
    $("#carouselImg").attr("style", "height: 64px;width: 64px;display:block;");
    $('#edit-error-msg').css("display", "none");
}