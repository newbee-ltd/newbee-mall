var editor;

$(function () {

    //富文本编辑器 用于商品详情编辑
    const E = window.wangEditor;

    const editorConfig = { MENU_CONF: {} }
    editorConfig.MENU_CONF['uploadImage'] = {
          //配置服务端图片上传地址
          server: '/admin/upload/files',
          // 超时时间5s
          timeout: 5 * 1000,
          fieldName: 'files',
          // 选择文件时的类型限制，默认为 ['image/*']
          allowedFileTypes: ['image/*'],
          // 限制图片大小 4M
          maxFileSize: 4 * 1024 * 1024,
          base64LimitSize: 5 * 1024,

          onBeforeUpload(file) {
            console.log('onBeforeUpload', file)

            return file // will upload this file
            // return false // prevent upload
          },
          onProgress(progress) {
            console.log('onProgress', progress)
          },
          onSuccess(file, res) {
            console.log('onSuccess', file, res)
          },
          onFailed(file, res) {
            alert(res.message)
            console.log('onFailed', file, res)
          },
          onError(file, err, res) {
            alert(err.message)
            console.error('onError', file, err, res)
          },
          customInsert: function (result,insertImgFn) {
            if (result != null && result.resultCode == 200) {
                // insertImgFn 可把图片插入到编辑器，传入图片 src ，执行函数即可
                result.data.forEach(img => {
                    insertImgFn(img)
                });
            } else if (result != null && result.resultCode != 200) {
                Swal.fire({
                    text: result.message,
                    icon: "error",iconColor:"#f05b72",
                });
            } else {
                Swal.fire({
                    text: "error",
                    icon: "error",iconColor:"#f05b72",
                });
            }
          }
    }

    editor = E.createEditor({
      selector: '#editor-text-area',
      html: $(".editor-text").val(),
      config: editorConfig
    })

    const toolbar = E.createToolbar({
      editor,
      selector: '#editor-toolbar',
    })

    //图片上传插件初始化 用于商品预览图上传
    new AjaxUpload('#uploadGoodsCoverImg', {
        action: '/admin/upload/file',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                Swal.fire({
                    text: "只支持jpg、png、gif格式的文件！",
                    icon: "error",iconColor:"#f05b72",
                });
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r != null && r.resultCode == 200) {
                $("#goodsCoverImg").attr("src", r.data);
                $("#goodsCoverImg").attr("style", "width: 128px;height: 128px;display:block;");
                return false;
            } else if (r != null && r.resultCode != 200) {
                Swal.fire({
                    text: r.message,
                    icon: "error",iconColor:"#f05b72",
                });
                return false;
            }
            else {
                Swal.fire({
                    text: "error",
                    icon: "error",iconColor:"#f05b72",
                });
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
    var goodsDetailContent = editor.getHtml();
    var goodsCoverImg = $('#goodsCoverImg')[0].src;
    if (isNull(goodsCategoryId)) {
        Swal.fire({
            text: "请选择分类",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (isNull(goodsName)) {
        Swal.fire({
            text: "请输入商品名称",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (!validLength(goodsName, 100)) {
        Swal.fire({
            text: "商品名称过长",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (isNull(tag)) {
        Swal.fire({
            text: "请输入商品小标签",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (!validLength(tag, 100)) {
        Swal.fire({
            text: "标签过长",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (isNull(goodsIntro)) {
        Swal.fire({
            text: "请输入商品简介",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (!validLength(goodsIntro, 100)) {
        Swal.fire({
            text: "简介过长",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (isNull(originalPrice) || originalPrice < 1) {
        Swal.fire({
            text: "请输入商品价格",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (isNull(sellingPrice) || sellingPrice < 1) {
        Swal.fire({
            text: "请输入商品售卖价",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (isNull(stockNum) || sellingPrice < 0) {
        Swal.fire({
            text: "请输入商品库存数",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (isNull(goodsSellStatus)) {
        Swal.fire({
            text: "请选择上架状态",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (isNull(goodsDetailContent)) {
        Swal.fire({
            text: "请输入商品介绍",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
        if (!validLength(goodsDetailContent, 50000)) {
        Swal.fire({
            text: "商品介绍内容过长",
            icon: "error",iconColor:"#f05b72",
        });
        return;
    }
    if (isNull(goodsCoverImg) || goodsCoverImg.indexOf('img-upload') != -1) {
        Swal.fire({
            text: "封面图片不能为空",
            icon: "error",iconColor:"#f05b72",
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
                Swal.fire({
                    text: swlMessage,
                    icon: "success",iconColor:"#1d953f",
                    showCancelButton: false,
                    confirmButtonColor: '#1baeae',
                    confirmButtonText: '返回商品列表',
                    confirmButtonClass: 'btn btn-success',
                    buttonsStyling: false
                }).then(function () {
                    window.location.href = "/admin/goods";
                })
            } else {
                Swal.fire({
                    text: result.message,
                    icon: "error",iconColor:"#f05b72",
                });
            }
            ;
        },
        error: function () {
            Swal.fire({
                text: "操作失败",
                icon: "error",iconColor:"#f05b72",
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
                Swal.fire({
                    text: result.message,
                    icon: "error",iconColor:"#f05b72",
                });
            }
            ;
        },
        error: function () {
            Swal.fire({
                text: "操作失败",
                icon: "error",iconColor:"#f05b72",
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
                Swal.fire({
                    text: result.message,
                    icon: "error",iconColor:"#f05b72",
                });
            }
            ;
        },
        error: function () {
            Swal.fire({
                text: "操作失败",
                icon: "error",iconColor:"#f05b72",
            });
        }
    });
});
