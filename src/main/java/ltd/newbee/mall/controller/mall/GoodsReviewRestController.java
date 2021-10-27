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
import ltd.newbee.mall.controller.vo.NewBeeMallOrderDetailVO;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.service.GoodsReviewService;
import ltd.newbee.mall.util.GoodsReviewUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class GoodsReviewRestController {

    @Resource
    private GoodsReviewService goodsReviewService;
    
    // review查询部分
    @RequestMapping(value = "/goodsReview/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
    	if (StringUtils.isEmpty(params.get("goodsId"))) {
    		return ResultGenerator.genErrorResult(300, "Error!");
    	}
    	long count = goodsReviewService.getCount(params);
    	if (params.get("callTimes").equals("1")) {
    		params.put("start", 0);
    		params.put("limit", 3);
    	} else {
    		params.put("start", 3);
    		params.put("limit", count - 3);
    	}
    	GoodsReviewUtil pageUtil = new GoodsReviewUtil(params);
		return ResultGenerator.genSuccessResult(goodsReviewService.getGoodsReview(pageUtil));
    }
    
    // insert
    @RequestMapping(value = "/insertGoodsReview", method = RequestMethod.POST)
    @ResponseBody
    public Result insertGoodsReview(@RequestBody GoodsReview goodsReview) {
    	
    	long count = goodsReviewService.insertGoodsReview(goodsReview);
    	if (count <= 0) {
    		return ResultGenerator.genErrorResult(300, "Error!");
    	} else {
    		return ResultGenerator.genSuccessResult("挿入できました.");
    	}
    }
    
    // 参考になった
    @RequestMapping(value = "/insertReviewHelpNum", method = RequestMethod.GET)
    @ResponseBody
    public Result getHelpNum(GoodsReview goodsReviewHelpNum, HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        if (user != null) {
        	goodsReviewHelpNum.setSankouUserId(6);
        }
        
        List<GoodsReview> list = goodsReviewService.getSankouUserId(goodsReviewHelpNum);
        if (!CollectionUtils.isEmpty(list)) {
    		return ResultGenerator.genFailResult("押下したことがありますので、押下できません。");
    	} else {
        	boolean insertFlag = goodsReviewService.insertHelpNum(goodsReviewHelpNum);
            if (insertFlag) {
            	boolean updateFlag = goodsReviewService.updateReviewNum(goodsReviewHelpNum);
            	if (updateFlag) {
            		long helpNum = goodsReviewService.getHelpNum(goodsReviewHelpNum.getReviewId());
            		return ResultGenerator.genSuccessResult(helpNum);
            	} else {
                    return ResultGenerator.genErrorResult(300, "改修失敗！");           
                } 
            }
    	}
		return ResultGenerator.genFailResult("改修失敗！");  
    }

//    @RequestMapping(value = "/insertReviewHelpNum", method = RequestMethod.GET)
//    @ResponseBody
//    public Result getHelpNum(GoodsReview goodsReviewHelpNum, long reviewId, HttpSession httpSession) {
//        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
//        if (user != null) {
//        	goodsReviewHelpNum.setSankouUserId(6);
//        }
//        
//        long count = goodsReviewService.getHelpNumTwice(reviewId);
//        if (count > 0) {
//        	ResultGenerator.genFailResult("押下したことがありますので、押下できません。");
//        } else {
//        	long insertCount = goodsReviewService.insertHelpNum(goodsReviewHelpNum);
//        	if (insertCount > 0) {
//        		return ResultGenerator.genSuccessResult(insertCount);
//        	} else {
//        		return ResultGenerator.genErrorResult(300, "改修失敗！");
//        	}
//        }
//		return ResultGenerator.genErrorResult(300, "改修失敗！");
//    }
    
    // レビュー平均評価x.xの情報
    @RequestMapping(value = "/goodsReview/averageStar", method = RequestMethod.GET)
    @ResponseBody
    public Result averageStar(@RequestParam long goodsId) {
    	
    	double averageStar = goodsReviewService.getAverageStarByGoodsId(goodsId);
    	if (averageStar <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(averageStar);
    	}
    }
//    @RequestMapping(value = "/goodsReview/averageStar", method = RequestMethod.GET)
//    @ResponseBody
//    public Result averageStar(@RequestParam long goodsId) {
//    	
//    	List<GoodsReview> averageStar = goodsReviewService.getAverageStarByGoodsId(goodsId);
//    	if (CollectionUtils.isEmpty(averageStar)) {
//    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
//    	} else {
//    		return ResultGenerator.genSuccessResult(averageStar);
//    	}
//    }
    
    // 参考になったを押下した後、「参考になった（125人）」人数を計算
    @RequestMapping(value = "/goodsReview/reviewHelpNum", method = RequestMethod.GET)
    @ResponseBody
    public Result reviewHelpNum(@RequestParam long goodsId, long reviewId) {
    	
    	long reviewHelpNum = goodsReviewService.getReviewHelpNum(goodsId, reviewId);
    	if (reviewHelpNum <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(reviewHelpNum);
    	}
    }
//    @RequestMapping(value = "/goodsReview/reviewHelpNum", method = RequestMethod.GET)
//    @ResponseBody
//    public Result reviewHelpNum(@RequestParam long goodsId, long reviewId) {
//    	
//    	List<GoodsReview> reviewHelpNum = goodsReviewService.getReviewHelpNum(goodsId, reviewId);
//    	if (CollectionUtils.isEmpty(reviewHelpNum)) {
//    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
//    	} else {
//    		return ResultGenerator.genSuccessResult(reviewHelpNum);
//    	}
//    }
    
}   
	
    /*
    @RequestMapping(value = "/insertReviewHelpNum", method = RequestMethod.GET)
    @ResponseBody
    public Result getHelpNum(GoodsReview goodsReviewHelpNum, HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        if (user != null) {
        	goodsReviewHelpNum.setSankouUserId(6);
        }
        try {
        	boolean insertFlag = goodsReviewService.insertHelpNum(goodsReviewHelpNum);
            if (insertFlag) {
            	boolean updateFlag = goodsReviewService.updateReivewNum(goodsReviewHelpNum);
                if (updateFlag) {
                	long helpNum = goodsReviewService.getHelpNum(goodsReviewHelpNum.getReviewId());
                    return ResultGenerator.genSuccessResult(helpNum);
                    } else {
                    	return ResultGenerator.genErrorResult(300, "改修失敗！");
                    }
                }
        } catch (Exception e) {
        	return ResultGenerator.genFailResult("押下したことがありますので、押下できません。");
        }
        return ResultGenerator.genFailResult("yichang");    
    }
    */


    