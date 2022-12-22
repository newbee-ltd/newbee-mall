/**
 * jqGrid Chinese Translation
 * 咖啡兔 yanhonglei@gmail.com 
 * http://www.kafeitu.me 
 * 
 * 花岗岩 marbleqi@163.com
 * 
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html 
**/
/*global jQuery, define */
(function( factory ) {
	"use strict";
	if ( typeof define === "function" && define.amd ) {
		// AMD. Register as an anonymous module.
		define([
			"jquery",
			"../grid.base"
		], factory );
	} else {
		// Browser globals
		factory( jQuery );
	}
}(function( $ ) {

$.jgrid = $.jgrid || {};
if(!$.jgrid.hasOwnProperty("regional")) {
	$.jgrid.regional = [];
}
$.jgrid.regional["cn"] = {
    defaults : {
        recordtext: "第{0}到第{1}条\u3000共 {2} 条", // 共字前是全角空格
        emptyrecords: "没有记录！",
        loadtext: "读取中...",
	savetext: "保存中...",
        pgtext : "第{0}页\u3000共{1}页",
		pgfirst : "第一页",
		pglast : "最后一页",
		pgnext : "下一页",
		pgprev : "上一页",
		pgrecs : "每页记录数",
		showhide: "切换 展开 折叠 表格",
		// mobile
		pagerCaption : "表格::页面设置",
		pageText : "Page:",
		recordPage : "每页记录数",
		nomorerecs : "没有更多记录...",
		scrollPullup: "加载更多...",
		scrollPulldown : "刷新...",
		scrollRefresh : "滚动刷新..."
    },
    search : {
        caption: "搜索...",
        Find: "查找",
        Reset: "重置",
        odata: [{ oper:'eq', text:'等于\u3000\u3000'},{ oper:'ne', text:'不等于\u3000'},{ oper:'lt', text:'小于\u3000\u3000'},{ oper:'le', text:'小于等于'},{ oper:'gt', text:'大于\u3000\u3000'},{ oper:'ge', text:'大于等于'},{ oper:'bw', text:'开头是'},{ oper:'bn', text:'开头不是'},{ oper:'in', text:'属于\u3000\u3000'},{ oper:'ni', text:'不属于'},{ oper:'ew', text:'结尾是'},{ oper:'en', text:'结尾不是'},{ oper:'cn', text:'包含\u3000\u3000'},{ oper:'nc', text:'不包含'},{ oper:'nu', text:'为空'},{ oper:'nn', text:'不为空'}, {oper:'bt', text:'区间'}],
        groupOps: [ { op: "AND", text: "满足所有条件" },    { op: "OR",  text: "满足任一条件" } ],
		operandTitle : "单击进行搜索。",
		resetTitle : "重置搜索条件",
		addsubgrup : "添加条件组",
		addrule : "添加条件",
		delgroup : "删除条件组",
		delrule : "删除条件",
		Close : "Close",
		Operand : "Operand : ",
		Operation : "Oper : "
    },
    edit : {
        addCaption: "添加记录",
        editCaption: "编辑记录",
        bSubmit: "提交",
        bCancel: "取消",
        bClose: "关闭",
        saveData: "数据已修改，是否保存？",
        bYes : "是",
        bNo : "否",
        bExit : "取消",
        msg: {
            required:"此字段必需",
            number:"请输入有效数字",
            minValue:"输值必须大于等于 ",
            maxValue:"输值必须小于等于 ",
            email: "这不是有效的e-mail地址",
            integer: "请输入有效整数",
            date: "请输入有效时间",
            url: "无效网址。前缀必须为 ('http://' 或 'https://')",
            nodefined : " 未定义！",
            novalue : " 需要返回值！",
            customarray : "自定义函数需要返回数组！",
            customfcheck : "必须有自定义函数!"
        }
    },
    view : {
        caption: "查看记录",
        bClose: "关闭"
    },
    del : {
        caption: "删除",
        msg: "删除所选记录？",
        bSubmit: "删除",
        bCancel: "取消"
    },
    nav : {
        edittext: "",
        edittitle: "编辑所选记录",
        addtext:"",
        addtitle: "添加新记录",
        deltext: "",
        deltitle: "删除所选记录",
        searchtext: "",
        searchtitle: "查找",
        refreshtext: "",
        refreshtitle: "刷新表格",
        alertcap: "注意",
        alerttext: "请选择记录",
        viewtext: "",
        viewtitle: "查看所选记录",
		savetext: "",
		savetitle: "保存记录",
		canceltext: "",
		canceltitle : "取消编辑记录",
		selectcaption : "操作..."
    },
    col : {
        caption: "选择列",
        bSubmit: "确定",
        bCancel: "取消"
    },
    errors : {
        errcap : "错误",
        nourl : "没有设置url",
        norecords: "没有需要处理的记录",
        model : "colNames 和 colModel 长度不等！"
    },
    formatter : {
        integer : {thousandsSeparator: ",", defaultValue: '0'},
        number : {decimalSeparator:".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00'},
        currency : {decimalSeparator:".", thousandsSeparator: ",", decimalPlaces: 2, prefix: "", suffix:"", defaultValue: '0.00'},
        date : {
            dayNames:   [
                "日", "一", "二", "三", "四", "五", "六",
                "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六",
            ],
            monthNames: [
                "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二",
                "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"
            ],
            AmPm : ["am","pm","上午","下午"],
            S: function (j) {return j < 11 || j > 13 ? ['st', 'nd', 'rd', 'th'][Math.min((j - 1) % 10, 3)] : 'th';},
            srcformat: 'Y-m-d',
            newformat: 'Y-m-d',
            parseRe : /[#%\\\/:_;.,\t\s-]/,
            masks : {
                // see http://php.net/manual/en/function.date.php for PHP format used in jqGrid
                // and see http://docs.jquery.com/UI/Datepicker/formatDate
                // and https://github.com/jquery/globalize#dates for alternative formats used frequently
                // one can find on https://github.com/jquery/globalize/tree/master/lib/cultures many
                // information about date, time, numbers and currency formats used in different countries
                // one should just convert the information in PHP format
                ISO8601Long:"Y-m-d H:i:s",
                ISO8601Short:"Y-m-d",
                // short date:
                //    n - Numeric representation of a month, without leading zeros
                //    j - Day of the month without leading zeros
                //    Y - A full numeric representation of a year, 4 digits
                // example: 3/1/2012 which means 1 March 2012
                ShortDate: "n/j/Y", // in jQuery UI Datepicker: "M/d/yyyy"
                // long date:
                //    l - A full textual representation of the day of the week
                //    F - A full textual representation of a month
                //    d - Day of the month, 2 digits with leading zeros
                //    Y - A full numeric representation of a year, 4 digits
                LongDate: "l, F d, Y", // in jQuery UI Datepicker: "dddd, MMMM dd, yyyy"
                // long date with long time:
                //    l - A full textual representation of the day of the week
                //    F - A full textual representation of a month
                //    d - Day of the month, 2 digits with leading zeros
                //    Y - A full numeric representation of a year, 4 digits
                //    g - 12-hour format of an hour without leading zeros
                //    i - Minutes with leading zeros
                //    s - Seconds, with leading zeros
                //    A - Uppercase Ante meridiem and Post meridiem (AM or PM)
                FullDateTime: "l, F d, Y g:i:s A", // in jQuery UI Datepicker: "dddd, MMMM dd, yyyy h:mm:ss tt"
                // month day:
                //    F - A full textual representation of a month
                //    d - Day of the month, 2 digits with leading zeros
                MonthDay: "F d", // in jQuery UI Datepicker: "MMMM dd"
                // short time (without seconds)
                //    g - 12-hour format of an hour without leading zeros
                //    i - Minutes with leading zeros
                //    A - Uppercase Ante meridiem and Post meridiem (AM or PM)
                ShortTime: "g:i A", // in jQuery UI Datepicker: "h:mm tt"
                // long time (with seconds)
                //    g - 12-hour format of an hour without leading zeros
                //    i - Minutes with leading zeros
                //    s - Seconds, with leading zeros
                //    A - Uppercase Ante meridiem and Post meridiem (AM or PM)
                LongTime: "g:i:s A", // in jQuery UI Datepicker: "h:mm:ss tt"
                SortableDateTime: "Y-m-d\\TH:i:s",
                UniversalSortableDateTime: "Y-m-d H:i:sO",
                // month with year
                //    Y - A full numeric representation of a year, 4 digits
                //    F - A full textual representation of a month
                YearMonth: "F, Y" // in jQuery UI Datepicker: "MMMM, yyyy"
            },
            reformatAfterEdit : false,
			userLocalTime : false
        },
        baseLinkUrl: '',
        showAction: '',
        target: '',
        checkbox : {disabled:true},
        idName : 'id'
    },
	colmenu : {
		sortasc : "升序排序",
		sortdesc : "降序排序",
		columns : "列",
		filter : "筛选",
		grouping : "分类",
		ungrouping : "取消分类",
		searchTitle : "查找:",
		freeze : "冻结",
		unfreeze : "取消冻结",
		reorder : "重新排序",
		hovermenu: "Click for column quick actions"
	}
};
}));
