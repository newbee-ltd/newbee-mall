var editorD;

$(function () {

    //富文本编辑器 用于商品详情编辑
    const E = window.wangEditor;
    editorD = new E('#wangEditor')
    // 设置编辑区域高度为 750px
    editorD.config.height = 750
    //配置服务端图片上传地址
    editorD.config.uploadImgServer = '/admin/upload/files'
    editorD.config.uploadFileName = 'files'
    //限制图片大小 2M
    editorD.config.uploadImgMaxSize = 2 * 1024 * 1024
    //限制一次最多能传几张图片 一次最多上传 5 个图片
    editorD.config.uploadImgMaxLength = 5
    //隐藏插入网络图片的功能
    editorD.config.showLinkImg = false
    editorD.config.uploadImgHooks = {
        // 图片上传并返回了结果，图片插入已成功
        success: function (xhr) {
            console.log('success', xhr)
        },
        // 图片上传并返回了结果，但图片插入时出错了
        fail: function (xhr, editor, resData) {
            console.log('fail', resData)
        },
        // 上传图片出错，一般为 http 请求的错误
        error: function (xhr, editor, resData) {
            console.log('error', xhr, resData)
        },
        // 上传图片超时
        timeout: function (xhr) {
            console.log('timeout')
        },
        customInsert: function (insertImgFn, result) {
            if (result != null && result.resultCode == 200) {
                // insertImgFn 可把图片插入到编辑器，传入图片 src ，执行函数即可
                result.data.forEach(img => {
                    insertImgFn(img)
                });
            } else {
                alert("error");
            }
        }
    }
    editorD.create();

    //图片上传插件初始化 用于商品预览图上传
    new AjaxUpload('#uploadGoodsCoverImg', {
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
                $("#goodsCoverImg").attr("src", r.data);
                $("#goodsCoverImg").attr("style", "width: 128px;height: 128px;display:block;");
                return false;
            } else {
                alert("error");
            }
        }
    });
});

$('#saveButton').click(function () {
    var goodsId = $('#goodsId').val();
    var goodsCategoryId = $('#levelThree option:selected').val();
    var goodsName = $('#goodsName').val();
    var tag = $('#tag').val();
    var originalPrice = $('#originalPrice').val();
    var sellingPrice = $('#sellingPrice').val();
    var goodsIntro = $('#goodsIntro').val();
    var stockNum = $('#stockNum').val();
    var goodsSellStatus = $("input[name='goodsSellStatus']:checked").val();
    var goodsDetailContent = editorD.txt.html();
    var goodsCoverImg = $('#goodsCoverImg')[0].src;
    if (isNull(goodsCategoryId)) {
        swal("请选择分类", {
            icon: "error",
        });
        return;
    }
    if (isNull(goodsName)) {
        swal("请输入商品名称", {
            icon: "error",
        });
        return;
    }
    if (!validLength(goodsName, 100)) {
        swal("请输入商品名称", {
            icon: "error",
        });
        return;
    }
    if (isNull(tag)) {
        swal("请输入商品小标签", {
            icon: "error",
        });
        return;
    }
    if (!validLength(tag, 100)) {
        swal("标签过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(goodsIntro)) {
        swal("请输入商品简介", {
            icon: "error",
        });
        return;
    }
    if (!validLength(goodsIntro, 100)) {
        swal("简介过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(originalPrice) || originalPrice < 1) {
        swal("请输入商品价格", {
            icon: "error",
        });
        return;
    }
    if (isNull(sellingPrice) || sellingPrice < 1) {
        swal("请输入商品售卖价", {
            icon: "error",
        });
        return;
    }
    if (isNull(stockNum) || sellingPrice < 0) {
        swal("请输入商品库存数", {
            icon: "error",
        });
        return;
    }
    if (isNull(goodsSellStatus)) {
        swal("请选择上架状态", {
            icon: "error",
        });
        return;
    }
    if (isNull(goodsDetailContent)) {
        swal("请输入商品介绍", {
            icon: "error",
        });
        return;
    }
    if (!validLength(goodsDetailContent, 50000)) {
        swal("商品介绍内容过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(goodsCoverImg) || goodsCoverImg.indexOf('img-upload') != -1) {
        swal("封面图片不能为空", {
            icon: "error",
        });
        return;
    }
    var url = '/admin/goods/save';
    var swlMessage = '保存成功';
    var data = {
        "goodsName": goodsName,
        "goodsIntro": goodsIntro,
        "goodsCategoryId": goodsCategoryId,
        "tag": tag,
        "originalPrice": originalPrice,
        "sellingPrice": sellingPrice,
        "stockNum": stockNum,
        "goodsDetailContent": goodsDetailContent,
        "goodsCoverImg": goodsCoverImg,
        "goodsCarousel": goodsCoverImg,
        "goodsSellStatus": goodsSellStatus
    };
    if (goodsId > 0) {
        url = '/admin/goods/update';
        swlMessage = '修改成功';
        data = {
            "goodsId": goodsId,
            "goodsName": goodsName,
            "goodsIntro": goodsIntro,
            "goodsCategoryId": goodsCategoryId,
            "tag": tag,
            "originalPrice": originalPrice,
            "sellingPrice": sellingPrice,
            "stockNum": stockNum,
            "goodsDetailContent": goodsDetailContent,
            "goodsCoverImg": goodsCoverImg,
            "goodsCarousel": goodsCoverImg,
            "goodsSellStatus": goodsSellStatus
        };
    }
    console.log(data);
    $.ajax({
        type: 'POST',//方法类型
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            if (result.resultCode == 200) {
                swal({
                    title: swlMessage,
                    type: 'success',
                    showCancelButton: false,
                    confirmButtonColor: '#1baeae',
                    confirmButtonText: '返回商品列表',
                    confirmButtonClass: 'btn btn-success',
                    buttonsStyling: false
                }).then(function () {
                    window.location.href = "/admin/goods";
                })
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
});

$('#cancelButton').click(function () {
    window.location.href = "/admin/goods";
});

$('#levelOne').on('change', function () {
    $.ajax({
        url: '/admin/categories/listForSelect?categoryId=' + $(this).val(),
        type: 'GET',
        success: function (result) {
            if (result.resultCode == 200) {
                var levelTwoSelect = '';
                var secondLevelCategories = result.data.secondLevelCategories;
                var length2 = secondLevelCategories.length;
                for (var i = 0; i < length2; i++) {
                    levelTwoSelect += '<option value=\"' + secondLevelCategories[i].categoryId + '\">' + secondLevelCategories[i].categoryName + '</option>';
                }
                $('#levelTwo').html(levelTwoSelect);
                var levelThreeSelect = '';
                var thirdLevelCategories = result.data.thirdLevelCategories;
                var length3 = thirdLevelCategories.length;
                for (var i = 0; i < length3; i++) {
                    levelThreeSelect += '<option value=\"' + thirdLevelCategories[i].categoryId + '\">' + thirdLevelCategories[i].categoryName + '</option>';
                }
                $('#levelThree').html(levelThreeSelect);
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
});

$('#levelTwo').on('change', function () {
    $.ajax({
        url: '/admin/categories/listForSelect?categoryId=' + $(this).val(),
        type: 'GET',
        success: function (result) {
            if (result.resultCode == 200) {
                var levelThreeSelect = '';
                var thirdLevelCategories = result.data.thirdLevelCategories;
                var length = thirdLevelCategories.length;
                for (var i = 0; i < length; i++) {
                    levelThreeSelect += '<option value=\"' + thirdLevelCategories[i].categoryId + '\">' + thirdLevelCategories[i].categoryName + '</option>';
                }
                $('#levelThree').html(levelThreeSelect);
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
});
