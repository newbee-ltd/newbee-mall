var newbeeSwiper = new Swiper('.swiper-container', {
    //设置自动播放
    autoplay: {
        delay: 2000,
        disableOnInteraction: false
    },
    //设置无限循环播放
    loop: true,
    //设置圆点指示器
    pagination: {
        el: '.swiper-pagination',
    },
    //设置上下页按钮
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    }
})

$('.all-sort-list > .item').hover(function () {
    var eq = $('.all-sort-list > .item').index(this),				//获取当前滑过是第几个元素
        h = $('.all-sort-list').offset().top,						//获取当前下拉菜单距离窗口多少像素
        s = $(window).scrollTop(),									//获取游览器滚动了多少高度
        i = $(this).offset().top,									//当前元素滑过距离窗口多少像素
        item = $(this).children('.item-list').height(),				//下拉菜单子类内容容器的高度
        sort = $('.all-sort-list').height();						//父类分类列表容器的高度

    if (item < sort) {												//如果子类的高度小于父类的高度
        if (eq == 0) {
            $(this).children('.item-list').css('top', (i - h));
        } else {
            $(this).children('.item-list').css('top', (i - h) + 1);
        }
    } else {
        if (s > h) {												//判断子类的显示位置，如果滚动的高度大于所有分类列表容器的高度
            if (i - s > 0) {											//则 继续判断当前滑过容器的位置 是否有一半超出窗口一半在窗口内显示的Bug,
                $(this).children('.item-list').css('top', (s - h) + 2);
            } else {
                $(this).children('.item-list').css('top', (s - h) - (-(i - s)) + 2);
            }
        } else {
            $(this).children('.item-list').css('top', 3);
        }
    }

    $(this).addClass('hover');
    $(this).children('.item-list').css('display', 'block');
}, function () {
    $(this).removeClass('hover');
    $(this).children('.item-list').css('display', 'none');
});