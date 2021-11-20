/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.GoodsImgVO;
import ltd.newbee.mall.controller.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.controller.vo.ReviewVO;
import ltd.newbee.mall.controller.vo.SearchPageCategoryVO;
import ltd.newbee.mall.entity.GoodsDetail;
import ltd.newbee.mall.entity.GoodsImg;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.service.GoodsDetailService;
import ltd.newbee.mall.service.GoodsImgService;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.service.PageInquiryService;
import ltd.newbee.mall.service.ReviewService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageInquiryResult;
import ltd.newbee.mall.util.PageInquiryUtil;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {

	@Resource
	private NewBeeMallGoodsService newBeeMallGoodsService;
	@Resource
	private NewBeeMallCategoryService newBeeMallCategoryService;

	@Resource
	private GoodsImgService goodsImgService;
	@Resource
	private GoodsDetailService goodsDetailService;
	@Resource
	private PageInquiryService pageInquiryService;
	@Resource
	private ReviewService reviewService;

	@GetMapping({ "/search", "/search.html" })
	public String searchPage(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		if (StringUtils.isEmpty(params.get("page"))) {
			params.put("page", 1);
		}
		params.put("limit", Constants.GOODS_SEARCH_PAGE_LIMIT);
		// 封装分类数据
		if (params.containsKey("goodsCategoryId") && !StringUtils.isEmpty(params.get("goodsCategoryId") + "")) {
			Long categoryId = Long.valueOf(params.get("goodsCategoryId") + "");
			SearchPageCategoryVO searchPageCategoryVO = newBeeMallCategoryService.getCategoriesForSearch(categoryId);
			if (searchPageCategoryVO != null) {
				request.setAttribute("goodsCategoryId", categoryId);
				request.setAttribute("searchPageCategoryVO", searchPageCategoryVO);
			}
		}
		// 封装参数供前端回显
		if (params.containsKey("orderBy") && !StringUtils.isEmpty(params.get("orderBy") + "")) {
			request.setAttribute("orderBy", params.get("orderBy") + "");
		}
		String keyword = "";
		// 对keyword做过滤 去掉空格
		if (params.containsKey("keyword") && !StringUtils.isEmpty((params.get("keyword") + "").trim())) {
			keyword = params.get("keyword") + "";
		}
		request.setAttribute("keyword", keyword);
		params.put("keyword", keyword);
		// 搜索上架状态下的商品
		params.put("goodsSellStatus", Constants.SELL_STATUS_UP);
		// 封装商品数据
		PageQueryUtil pageUtil = new PageQueryUtil(params);
		request.setAttribute("pageResult", newBeeMallGoodsService.searchNewBeeMallGoods(pageUtil));
		return "mall/search";

	}

	@GetMapping("/goods/detail/{goodsId}")
	public String detailPage(@PathVariable("goodsId") Long goodsId, HttpServletRequest request) throws ParseException {

		// 0.原始代码
		if (goodsId < 1) {
			return "error/error_5xx";
		}
		NewBeeMallGoods goods = newBeeMallGoodsService.getNewBeeMallGoodsById(goodsId);
		if (goods == null) {
			NewBeeMallException.fail(ServiceResultEnum.GOODS_NOT_EXIST.getResult());
		}
		if (Constants.SELL_STATUS_UP != goods.getGoodsSellStatus()) {
			NewBeeMallException.fail(ServiceResultEnum.GOODS_PUT_DOWN.getResult());
		}

		NewBeeMallGoodsDetailVO goodsDetailVO = new NewBeeMallGoodsDetailVO();
		BeanUtil.copyProperties(goods, goodsDetailVO);
		goodsDetailVO.setGoodsCarouselList(goods.getGoodsCarousel().split(","));
		request.setAttribute("goodsDetail", goodsDetailVO);

		// 1.手顺: GoodsController > detailPage 你调用之前的service 然后imgList设置到request
		// Get GoodsImg List
		List<GoodsImg> imgList = goodsImgService.getGoodsImgList(goodsId);
		// Copy GoodsImglist
		// List<GoodsImgVO> imgVOList = BeanUtil.copyList(imgList, GoodsImgVO.class);
		// Set GoodsImglist
		// request.setAttribute("imgList", imgVOList);

//		List<String> imgUrlList = new ArrayList<>();
//		for (GoodsImg img : imgList) {
//			imgUrlList.add(img.getGoodsImgUrl());
//		}

		// 1[0 1 2 3] 1*4-1 2[4 5 6 7] 3[8 9 10 11] 数组最后一位i=n*4-1 => n=(i+1)%4
		List<List<GoodsImg>> outterList = new ArrayList<>();
		List<GoodsImg> innerList = new ArrayList<>();

		GoodsImg g = new GoodsImg();
		g.setGoodsImgUrl(goods.getGoodsCoverImg());

		imgList.add(0, g);
		for (int i = 0; i < imgList.size(); i++) {
			innerList.add(imgList.get(i));
			if ((i + 1) % 8 == 0 || i == imgList.size() - 1) {
				ArrayList<GoodsImg> tempList = (ArrayList<GoodsImg>) BeanUtil.copyList(innerList, GoodsImg.class);
				outterList.add(tempList);
				innerList.clear();
			}
		}
		request.setAttribute("outterList", outterList);

		// 根据slide个数生成dot
		List<Long> slideDot = new ArrayList<>();
		for (long i = 0; i < outterList.size(); i++) {
			slideDot.add(i);
		}
		request.setAttribute("slideDot", slideDot);

//		//List<List<T>> lists = new ArrayList<List<T>>(); 
//		int listSize = imgList.size(); // 原集合长度
//		int listCount = listSize / 8; // 可直接拆分集合数量
//		// 按量拆分
//		for (int i = 0; i < listCount; i++)
//			outterList.add(imgList.subList(i * 8, (i + 1) * 8));
//		// 如果按量拆分后还有剩余, 收尾
//		int remainder = listSize % 8;
//		if (remainder > 0)
//			outterList.add(imgList.subList(listSize - remainder, listSize));

		// 2.goods size
		ArrayList<GoodsDetail> goodsDetail = goodsDetailService.getGoodsDetailList(goodsId);
		ArrayList<GoodsDetail> sizeList = (ArrayList<GoodsDetail>) BeanUtil.copyList(goodsDetail, GoodsDetail.class);
		request.setAttribute("size", sizeList.get(0));

// 3 获取分页的参数
		Map<String, Object> params = new HashMap<>();
		int limit = 3;
		int currentPage = 1;
		String orderByColumn = "help_num";
		String ascOrDesc = "desc";

		params.put("limit", limit);
		params.put("currentPage", currentPage);
		params.put("orderByColumn", orderByColumn);
		params.put("ascOrDesc", ascOrDesc);
		PageInquiryUtil pageUtil = new PageInquiryUtil(params);
		PageInquiryResult pageResult = pageInquiryService.getQAPage(pageUtil);

		int totalCount = pageResult.getTotalCount();
		int totalPage = pageResult.getTotalPage();
		int currPage = pageResult.getCurrPage();
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currPage", currPage);

		List<QuestionAndAnswer> QAList = (List<QuestionAndAnswer>) pageResult.getList();
		request.setAttribute("QA", QAList);

//		// 格式化时间，先将entity的时间换成String
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		for (int i = 0; i < QAList.size(); i++) {
//			QuestionAndAnswer qa = QAList.get(i);
//			String dateStr = format.format(qa.getSubmitDate());
//			Date date = format.parse(dateStr);
//		//	qa.setSubmitDate(date);
//		}

		// 4.Review
		List<Review> reviewList = reviewService.getGoodsReview(goodsId);
		List<ReviewVO> reviewVOList = BeanUtil.copyList(reviewList, ReviewVO.class);
		List<ReviewVO> hpReviewList = reviewVOList.subList(0, 3);
		List<ReviewVO> subReviewList = reviewVOList.subList(3, reviewVOList.size());
		request.setAttribute("reviewHP", hpReviewList);
		request.setAttribute("reviewMore", subReviewList);

		double averageStar = reviewService.getAverageStar(goodsId);
		long totalReview = reviewService.getCount(goodsId);
		request.setAttribute("avgStar", averageStar);
		request.setAttribute("totalReview", totalReview);

		List<Review> starNumList = reviewService.getStarNum(goodsId);
		List<ReviewVO> starNumVOList = BeanUtil.copyList(starNumList, ReviewVO.class);
		request.setAttribute("star", starNumVOList);

		return "mall/detail";
	}

}
