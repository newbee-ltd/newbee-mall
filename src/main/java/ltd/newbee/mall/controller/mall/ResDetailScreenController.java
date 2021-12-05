
package ltd.newbee.mall.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.entity.ResDetailScreen;
import ltd.newbee.mall.service.ResDetailScreenService;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class ResDetailScreenController {

	@Resource
	ResDetailScreenService resDetailScreenService;

//	@RequestMapping(value = "/followTotal", method = RequestMethod.GET)
//	@ResponseBody
//	public Result followTotal(long followResId) {
//		long followTotal = resDetailScreenService.getFollowTotal(followResId);
//		return ResultGenerator.genSuccessResult(followTotal);
//	}
//
//	@RequestMapping(value = "/resDetail", method = RequestMethod.GET)
//	@ResponseBody
//	public Result resDetail(long restaurantId) {
//		List<ResDetailScreen> resDetailList = resDetailScreenService.getResDetail(restaurantId);
//
//		if (CollectionUtils.isEmpty(resDetailList)) {
//			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
//		} else {
//			return ResultGenerator.genSuccessResult(resDetailList);
//		}
//	}

}
