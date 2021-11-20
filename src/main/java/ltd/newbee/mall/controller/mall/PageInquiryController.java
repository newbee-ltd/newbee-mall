
package ltd.newbee.mall.controller.mall;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.entity.QuestionSannkou;
import ltd.newbee.mall.entity.ReviewSannkou;
import ltd.newbee.mall.service.PageInquiryService;
import ltd.newbee.mall.util.PageInquiryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller

public class PageInquiryController {

	@Resource
	PageInquiryService pageInquiryService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/QA/list", method = RequestMethod.POST)
	@ResponseBody
	public Result list(@RequestBody Map<String, Object> params) {
		if (StringUtils.isEmpty(params.get("currentPage").toString())
				|| StringUtils.isEmpty(params.get("limit").toString())
				|| StringUtils.isEmpty((String) params.get("orderByColumn"))
				|| StringUtils.isEmpty(params.get("goodsId").toString())) {
			return ResultGenerator.genFailResult("参数异常！");
		}
		PageInquiryUtil pageUtil = new PageInquiryUtil(params);
		return ResultGenerator.genSuccessResult(pageInquiryService.getQAPage(pageUtil));
	}

	@RequestMapping(value = "/QA/helpNum", method = RequestMethod.POST)
	@ResponseBody
	public Result helpNum(@RequestBody QuestionSannkou questionSannkou, HttpSession httpSession) {
		NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
		if (user != null) {
			questionSannkou.setUserId(user.getUserId());
		}
		

		List<QuestionSannkou> list= pageInquiryService.getQASannkouUserId(questionSannkou);
		if (!CollectionUtils.isEmpty(list)) {
			return ResultGenerator.genFailResult("押下したことがあるので、押下できない!");
		} else {
			boolean insertFlag = pageInquiryService.insertHelpNum(questionSannkou);
			if (insertFlag) {
				//boolean updateFlag = pageInquiryService.updateHelpNum(questionSannkou);
				//if (updateFlag) {
					long helpNum = pageInquiryService.getHelpNum(questionSannkou.getQuestionsId(),questionSannkou.getGoodsId());
					return ResultGenerator.genSuccessResult(helpNum);
			//	} else {
				//	return ResultGenerator.genFailResult("改修失敗！！");
				//}
			} else {
				return ResultGenerator.genFailResult("挿入失敗!");
			}
		}
	}
}
