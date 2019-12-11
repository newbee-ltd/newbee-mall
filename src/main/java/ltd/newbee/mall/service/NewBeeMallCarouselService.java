package ltd.newbee.mall.service;

import ltd.newbee.mall.controller.vo.NewBeeMallIndexCarouselVO;
import ltd.newbee.mall.entity.Carousel;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import java.util.List;

/**
 * 轮播图操作方法接口
 */
public interface NewBeeMallCarouselService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCarouselPage(PageQueryUtil pageUtil);

    String saveCarousel(Carousel carousel);

    String updateCarousel(Carousel carousel);

    Carousel getCarouselById(Integer id);

    /** 删除轮播图 */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回固定数量的轮播图对象(首页调用)
     * @param number 多少张轮播图
     * @return
     */
    List<NewBeeMallIndexCarouselVO> getCarouselsForIndex(int number);
}
