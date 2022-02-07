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
import ltd.newbee.mall.controller.vo.GoodsImageVO;
import ltd.newbee.mall.controller.vo.GoodsInfoVO;
import ltd.newbee.mall.controller.vo.GoodsQaVO;
import ltd.newbee.mall.controller.vo.GoodsReviewVO;
import ltd.newbee.mall.controller.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.controller.vo.NewBeeMallOrderDetailVO;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.controller.vo.SearchPageCategoryVO;
import ltd.newbee.mall.entity.Carousel;
import ltd.newbee.mall.entity.GoodsImageEntity;
import ltd.newbee.mall.entity.GoodsInfo;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import ltd.newbee.mall.util.SearchPageParams;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {

	@Resource
	private NewBeeMallGoodsService newBeeMallGoodsService;
	@Resource
	private NewBeeMallCategoryService newBeeMallCategoryService;

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
	public String detailPage(@PathVariable("goodsId") Long goodsId, HttpServletRequest request) {
		if (goodsId < 1) {
			return "error/error_5xx";
		}
		// 获取商品信息
		GoodsInfo goodsInfo = newBeeMallGoodsService.getGoodsInfoByPK(10700l);
		GoodsInfoVO goodsInfoVO = new GoodsInfoVO();
		BeanUtil.copyProperties(goodsInfo, goodsInfoVO);
		request.setAttribute("goodsInfo", goodsInfoVO);

		// 获取商品图片

		List<GoodsImageEntity> goodsImageList = newBeeMallGoodsService.getGoodsImageByPk(10700l);
		List<GoodsImageVO> goodsImageVOList = BeanUtil.copyList(goodsImageList, GoodsImageVO.class);

		List<List<GoodsImageVO>> outerList = new ArrayList<List<GoodsImageVO>>();
		List<GoodsImageVO> innerList = new ArrayList<GoodsImageVO>();

		for (int i = 0; i < goodsImageVOList.size(); i++) {
			innerList.add(goodsImageVOList.get(i));

			if (i != 0 && (i+1) % 8 == 0) {
				List innerListCopy = new ArrayList();
				for (int j = 0; j < innerList.size(); j++) {
					innerListCopy.add(innerList.get(j));
				}

				outerList.add(innerListCopy);
				innerList.clear();
			}
			if (i == goodsImageVOList.size()-1 && (i +1)% 8 != 0) {
				List innerListCopy2 = new ArrayList();
				for (int j = 0; j < innerList.size(); j++) {
					innerListCopy2.add(innerList.get(j));
				}
				outerList.add(innerListCopy2);
			}

		}
		request.setAttribute("outerList", outerList);

		// 获取商品QA
		Map<String, Object> goodsQa = new HashMap<String, Object>();
		goodsQa.put("goodsId", goodsId);
		
		
		List<GoodsQa> goodsQaList = newBeeMallGoodsService.getGoodsQa(goodsQa);
		List<GoodsQaVO> goodsQaVOList = BeanUtil.copyList(goodsQaList, GoodsQaVO.class);
		request.setAttribute("goodsQa", goodsQaVOList);
		/* request.setAttribute("totalPage", 5); */
		
		//获取QA总数
		Long goodsQaCount = newBeeMallGoodsService.getGoodsQaCount(goodsId);
		Long totalPage =(long) Math.ceil(goodsQaCount/3.0);
		request.setAttribute("goodsQaCount", goodsQaCount);
		request.setAttribute("totalPage", totalPage);

		// 获取商品评论
		Map<String, Object> goodsReview = new HashMap<String, Object>();
		goodsReview.put("reviewMore", 0);// 显示前三条
		goodsReview.put("reviewType", 1);// 显示全部星级的前三条
		goodsReview.put("reviewRate", 5);
		goodsReview.put("goodsId", goodsId);
		ArrayList<GoodsReview> goodsReviewList = newBeeMallGoodsService.getGoodsReview(goodsReview);
		List<GoodsReviewVO> GoodsReviewVOList = BeanUtil.copyList(goodsReviewList, GoodsReviewVO.class);
		request.setAttribute("goodsReview", GoodsReviewVOList);

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
		return "mall/detail";
	}
	
	@RequestMapping(value = "/goods/qaList", method = RequestMethod.POST)
    @ResponseBody
    public Result goodsQa(@RequestBody Map<String, Object> params) {
		ArrayList<GoodsQa> qaList = newBeeMallGoodsService.getGoodsQa(params);
		
		Long goodsId = Long.parseLong(params.get("goodsId").toString());
		Long qaCount = newBeeMallGoodsService.getGoodsQaCount(goodsId);
		Long pageNo = Long.parseLong(params.get("pageNo").toString());
		
		Map<String, Object> goodsQa = new HashMap<String, Object>();
		goodsQa.put("qaList", qaList);
		goodsQa.put("qaCount", qaCount);
		goodsQa.put("pageNo", pageNo);
		goodsQa.put("totalPageNo",Math.ceil(qaCount/3.0));
		return ResultGenerator.genSuccessResult(goodsQa);
	}
	
	@RequestMapping(value = "/goods/userId", method = RequestMethod.POST)
    @ResponseBody
    @GetMapping("/orders/{orderNo}")
        public String goodsQaPage(HttpServletRequest request, @PathVariable("qaId") Long qaId, HttpSession httpSession) {
            NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
    		Map<String, Object> goodsQa = new HashMap<String, Object>();
    		goodsQa.put("qaId", qaId);
    		goodsQa.put("userId", user.getUserId());
    		List<GoodsQa> goodsQaList = newBeeMallGoodsService.getGoodsQa(goodsQa);
    		List<GoodsQaVO> goodsQaVOList = BeanUtil.copyList(goodsQaList, GoodsQaVO.class);
            if (goodsQaVOList == null) {
                return "error/error_5xx";
            }
            request.setAttribute("goodsQalVO", goodsQaVOList);
            return "mall/goodsQa-detail";
        }

    }



