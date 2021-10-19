/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.service.GoodsPageService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.Map;

@Controller
public class TestGoodsPageRestController {

    @Resource
    private GoodsPageService goodsPageService;

    // 分页
    @RequestMapping(value = "/questionAndAnswer/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
    	
    	if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
    		return ResultGenerator.genErrorResult(300, "Error!");
    	}
    	PageQueryUtil pageUtil = new PageQueryUtil(params);
    		return ResultGenerator.genSuccessResult(goodsPageService.getQuestionAndAnswer(pageUtil));
    }
    
    // 質問を投稿
    @RequestMapping(value = "/insertQuestion", method = RequestMethod.POST)
    @ResponseBody
    public Result insertQuestion(@RequestBody QuestionAndAnswer question) {
    	
    	long count = goodsPageService.insertQuestion(question);
    	if (count <= 0) {
    		return ResultGenerator.genErrorResult(300, "Error!");
    	} else {
    		return ResultGenerator.genSuccessResult("挿入できました.");
    	}
    }
    
}
