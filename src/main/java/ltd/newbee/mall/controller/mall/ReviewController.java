
package ltd.newbee.mall.controller.mall;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.controller.vo.NewBeeMallOrderDetailVO;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.controller.vo.ReviewVO;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.entity.ReviewSannkou;
import ltd.newbee.mall.service.ReviewService;
import ltd.newbee.mall.util.PageInquiryUtil;
import ltd.newbee.mall.util.PageInquiryUtil2;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class ReviewController {

	@Resource
	ReviewService reviewService;

	// 分页列表
	@RequestMapping(value = "/review/list", method = RequestMethod.GET)
	@ResponseBody
	public Result list(@RequestParam Map<String, Object> params) {

		if (StringUtils.isEmpty((String) params.get("currentPage")) || StringUtils.isEmpty((String) params.get("limit"))
				|| StringUtils.isEmpty((String) params.get("orderByColumn"))
				|| StringUtils.isEmpty((String) params.get("goodsId"))) {
			return ResultGenerator.genFailResult("参数异常！");
		}
		PageInquiryUtil pageUtil = new PageInquiryUtil(params);
		return ResultGenerator.genSuccessResult(reviewService.getReviewPage(pageUtil));
	}

	// 展开评论方法2
	@RequestMapping(value = "/review/list2", method = RequestMethod.GET)
	@ResponseBody
	public Result list2(@RequestParam Map<String, Object> params) {

		if (StringUtils.isEmpty((String) params.get("goodsId"))) {
			return ResultGenerator.genFailResult("参数异常！");
		}

		Long count = reviewService.getCount(params);
		if (params.get("callTimes").equals("1")) {
			params.put("start", 0);
			params.put("limit", 3);
		} else {
			params.put("start", 3);
			params.put("limit", count - 3);
		}
		PageInquiryUtil2 pageUtil = new PageInquiryUtil2(params);
		return ResultGenerator.genSuccessResult(reviewService.getMoreReview(pageUtil));
	}

	@RequestMapping(value = "/insertReview", method = RequestMethod.POST)
	@ResponseBody
	public Result insertReview(@RequestBody Review review) {

		long count = reviewService.insertReview(review);

		Long reviewId = reviewService.getMaxReviewId(review.getReviewId());
		review.setReviewId(reviewId);

		Date submitDate = new Date();
		review.setSubmitDate(submitDate);

		if (count <= 0) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult("挿入した");
		}
	}

	// 默认显示第一页的三条数据，剩余为折叠的部分。 最初のページの三つのデータがデフォルトで表示され、残りは折りたたんだ部分になる。
	@RequestMapping(value = "/showMoreReviews", method = RequestMethod.GET)
	@ResponseBody
	public Result showMoreRevies(@RequestParam Long goodsId) {

		List<ReviewVO> reviewList = reviewService.getGoodsReviews(goodsId);
		List<ReviewVO> subReviewList = reviewList.subList(3, reviewList.size());
		// limit是3，显示0 1 2
		// 子字符串，折叠3—size（因为左闭右开，不用-1）
		return ResultGenerator.genSuccessResult(subReviewList);

	}

//	@RequestMapping(value = "/review/{reviewId}", method = RequestMethod.GET)
//	@ResponseBody
//	public Result orderDetailPage(HttpServletRequest request, @PathVariable("reviewId") long reviewId,
//			HttpSession httpSession) {
//		NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
//		ReviewVO reviewVO = reviewService.getReviewDetail(reviewId, user.getUserId());
//		if (reviewVO == null) {
//			return ResultGenerator.genFailResult("error/error_5xx");
//		} else {
//			httpSession.setAttribute("orderDetailVO", reviewVO);
//			return ResultGenerator.genSuccessResult("mall/order-detail");
//		}
//	}

	@RequestMapping(value = "/review/helpNum", method = RequestMethod.POST)
	@ResponseBody
	public Result helpNum(@RequestBody ReviewSannkou reviewSannkou, HttpSession httpSession) {
		NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
		if (user != null) {
			reviewSannkou.setSannkouUserId(2001);
		}
		boolean insertFlag = reviewService.insertHelpNum(reviewSannkou);
		if (insertFlag) {
			boolean updateFlag = reviewService.updateReviewNum(reviewSannkou);
			if (updateFlag) {
				long helpNum = reviewService.getHelpNum(reviewSannkou.getReviewId());
				return ResultGenerator.genSuccessResult(helpNum);
				
			} else {
				return ResultGenerator.genFailResult("改修失敗！！");
			}
		} else {
			return ResultGenerator.genFailResult("押下したことがあるので、押下できない!");
		}

	}

}
