$(function () {
    // 加载统计数据
    loadStatistics();
    
    // 初始化所有收藏表格
    initAllFavoritesGrid();
    
    // 初始化商品收藏统计表格
    initGoodsStatsGrid();
    
    // 初始化用户收藏统计表格
    initUserStatsGrid();
    
    // 标签页切换事件
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        var target = $(e.target).attr("href");
        if (target === "#allFavorites") {
            $("#allFavoritesGrid").setGridWidth($('.card-body').width());
        } else if (target === "#goodsStats") {
            $("#goodsStatsGrid").setGridWidth($('.card-body').width());
        } else if (target === "#userStats") {
            $("#userStatsGrid").setGridWidth($('.card-body').width());
        }
    });
});

function loadStatistics() {
    $.ajax({
        type: 'GET',
        url: '/admin/favorites/statistics',
        success: function (result) {
            if (result.resultCode == 200) {
                $('#totalFavorites').text(result.data.totalFavorites);
                $('#totalUsers').text(result.data.totalUsers);
                $('#totalGoods').text(result.data.totalGoods);
            } else {
                swal(result.message, {
                    icon: "error",
                });
            }
        },
        error: function () {
            swal("操作失败", {
                icon: "error",
            });
        }
    });
}

function initAllFavoritesGrid() {
    $("#allFavoritesGrid").jqGrid({
        url: '/admin/favorites/list',
        datatype: "json",
        colModel: [
            {label: '收藏ID', name: 'favoriteId', index: 'favoriteId', width: 60, key: true},
            {label: '用户ID', name: 'userId', index: 'userId', width: 60},
            {label: '用户名', name: 'loginName', index: 'loginName', width: 120},
            {label: '商品ID', name: 'goodsId', index: 'goodsId', width: 60},
            {label: '商品名称', name: 'goodsName', index: 'goodsName', width: 200},
            {label: '收藏时间', name: 'createTime', index: 'createTime', width: 150, formatter: timeFormatter}
        ],
        height: 400,
        rowNum: 10,
        rowList: [10, 30, 50],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: false,
        rownumWidth: 20,
        autowidth: true,
        multiselect: true,
        pager: "#allFavoritesPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        }
    });
}

function initGoodsStatsGrid() {
    $("#goodsStatsGrid").jqGrid({
        url: '/admin/favorites/goodsStats',
        datatype: "json",
        colModel: [
            {label: '商品ID', name: 'goodsId', index: 'goodsId', width: 60, key: true},
            {label: '商品名称', name: 'goodsName', index: 'goodsName', width: 200},
            {label: '收藏数量', name: 'favoriteCount', index: 'favoriteCount', width: 80},
            {label: '最新收藏时间', name: 'latestFavoriteTime', index: 'latestFavoriteTime', width: 150, formatter: timeFormatter}
        ],
        height: 400,
        rowNum: 10,
        rowList: [10, 30, 50],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: false,
        rownumWidth: 20,
        autowidth: true,
        multiselect: false,
        pager: "#goodsStatsPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        }
    });
}

function initUserStatsGrid() {
    $("#userStatsGrid").jqGrid({
        url: '/admin/favorites/userStats',
        datatype: "json",
        colModel: [
            {label: '用户ID', name: 'userId', index: 'userId', width: 60, key: true},
            {label: '用户名', name: 'loginName', index: 'loginName', width: 120},
            {label: '昵称', name: 'nickName', index: 'nickName', width: 120},
            {label: '收藏数量', name: 'favoriteCount', index: 'favoriteCount', width: 80},
            {label: '最新收藏时间', name: 'latestFavoriteTime', index: 'latestFavoriteTime', width: 150, formatter: timeFormatter}
        ],
        height: 400,
        rowNum: 10,
        rowList: [10, 30, 50],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: false,
        rownumWidth: 20,
        autowidth: true,
        multiselect: false,
        pager: "#userStatsPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        }
    });
}

function timeFormatter(cellValue) {
    if (cellValue == null || cellValue == '') {
        return '';
    }
    return new Date(cellValue).Format('yyyy-MM-dd hh:mm:ss');
}