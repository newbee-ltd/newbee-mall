package ltd.newbee.mall.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.entity.GoodsImg;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.service.GoodsImgService;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class GoodsImgController {

	@Resource
    private GoodsImgService goodsImgService;
	
	
	@RequestMapping(value = "/goodsImg", method = RequestMethod.GET)
	@ResponseBody
	public Result goodsImg(long goodsId) {
		List<GoodsImg> list = goodsImgService.getGoodsImgList(goodsId);   
		if (CollectionUtils.isEmpty(list)) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(list);
		}

	}
	
	
}
