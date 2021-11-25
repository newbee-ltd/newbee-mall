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
import ltd.newbee.mall.controller.vo.GoodsReviewVO;
import ltd.newbee.mall.controller.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.controller.vo.QuestionAndAnswerVO;
import ltd.newbee.mall.controller.vo.SearchPageCategoryVO;
import ltd.newbee.mall.entity.GoodsDetail;
import ltd.newbee.mall.entity.GoodsImg;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.service.GoodsPageService;
import ltd.newbee.mall.service.GoodsReviewService;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.GoodsReviewUtil;
import ltd.newbee.mall.util.NewBeeMallUtils;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class GoodsController {

    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;
    @Resource
    private GoodsPageService goodsPageService;
    @Resource
    private GoodsReviewService goodsReviewService;

    @GetMapping({"/search", "/search.html"})
    public String searchPage(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        if (StringUtils.isEmpty(params.get("page"))) {
            params.put("page", 1);
        }
        params.put("limit", Constants.GOODS_SEARCH_PAGE_LIMIT);
        //封装分类数据
        if (params.containsKey("goodsCategoryId") && !StringUtils.isEmpty(params.get("goodsCategoryId") + "")) {
            Long categoryId = Long.valueOf(params.get("goodsCategoryId") + "");
            SearchPageCategoryVO searchPageCategoryVO = newBeeMallCategoryService.getCategoriesForSearch(categoryId);
            if (searchPageCategoryVO != null) {
                request.setAttribute("goodsCategoryId", categoryId);
                request.setAttribute("searchPageCategoryVO", searchPageCategoryVO);
            }
        }
        //封装参数供前端回显
        if (params.containsKey("orderBy") && !StringUtils.isEmpty(params.get("orderBy") + "")) {
            request.setAttribute("orderBy", params.get("orderBy") + "");
        }
        String keyword = "";
        //对keyword做过滤 去掉空格
        if (params.containsKey("keyword") && !StringUtils.isEmpty((params.get("keyword") + "").trim())) {
            keyword = params.get("keyword") + "";
        }
        request.setAttribute("keyword", keyword);
        params.put("keyword", keyword);
        //搜索上架状态下的商品
        params.put("goodsSellStatus", Constants.SELL_STATUS_UP);
        //封装商品数据
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        request.setAttribute("pageResult", newBeeMallGoodsService.searchNewBeeMallGoods(pageUtil));
        return "mall/search";
    }

    @GetMapping("/goods/detail/{goodsId}")
    public String detailPage(@PathVariable("goodsId") Long goodsId, HttpServletRequest request) throws ParseException {
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
        
        // ①GoodsImg
        List<GoodsImg> goodsImgEntityList = newBeeMallGoodsService.getGoodsImgByGoodsId(goodsId);
        // Copy GoodsImgList
        List<GoodsImgVO> goodsImgVoList = BeanUtil.copyList(goodsImgEntityList, GoodsImgVO.class);
        
        // Set Cover Img
        GoodsImg g = new GoodsImg();
		g.setGoodsImgUrl(goods.getGoodsCoverImg());
        
        // 改变数据结构
        ArrayList<List> outterList = new ArrayList<List>();
        ArrayList<GoodsImg> innerList = new ArrayList<GoodsImg>();
        for (int i = 0; i < goodsImgEntityList.size(); i++) {
			innerList.add(goodsImgEntityList.get(i));
            if ((i + 1) % 8 == 0 || i == goodsImgEntityList.size() - 1) {
            	ArrayList<GoodsImg> tempList = (ArrayList<GoodsImg>) BeanUtil.copyList(innerList, GoodsImg.class);
            	outterList.add(tempList);
            	innerList.clear();
            }
        }
        
        // GoodsDetail
        List<GoodsDetail> goodsDetailList = newBeeMallGoodsService.getGoodsDetailByGoodsId(goodsId);
        // Copy GoodsDetailList
        List<GoodsDetail> detailList = (List<GoodsDetail>) BeanUtil.copyList(goodsDetailList, GoodsDetail.class);
        
        // QA
        Map<String, Object> params = new HashMap<String,Object>();
        int limit = 3;
        int page = 1;
        String orderByColumn = "help_num";
        params.put("page", page);
        params.put("limit", limit);
        params.put("orderByColumn", orderByColumn);
        
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        PageResult rs = goodsPageService.getQuestionAndAnswer(pageUtil);
        
        int qaCount = rs.getTotalCount();
        int qaTotalPage = rs.getTotalPage();
        int qaCurrentPage = rs.getCurrPage();
        List<QuestionAndAnswer> qaEntityList = (List<QuestionAndAnswer>) rs.getList();
        List<QuestionAndAnswerVO> qaList = new ArrayList<QuestionAndAnswerVO>();
        
        // Set QA Time Format
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < qaEntityList.size(); i++) {
        	QuestionAndAnswer qa = qaEntityList.get(i);
        	QuestionAndAnswerVO q = new QuestionAndAnswerVO();
        	
        	if (qa != null && qa.getAnswerDate() != null) {
            String dateString = format.format(qa.getAnswerDate());
            Date date = format.parse(dateString);
            q.setAnswerDate(dateString);
        	}
        	 
        	if (qa != null && qa.getSubmitDate() != null) {
                String dateString = format.format(qa.getSubmitDate());
                Date date = format.parse(dateString);
                q.setSubmitDate(dateString);
        	}
        	
            q.setGoodsId(qa.getGoodsId());
            q.setQuestionId(qa.getQuestionId());
            q.setQuestion(qa.getQuestion());
            q.setAnswer(qa.getAnswer());
            q.setUserId(qa.getUserId());
            q.setHelpNum(qa.getHelpNum());
            qaList.add(q);
        }
        
        // Goods Review
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("goodsId", goodsId);
    	long count = goodsReviewService.getCount(map);
//    	map.put("start", 3);
//    	map.put("limit", count - 3);
    	map.put("start", 0);
    	map.put("limit", 3);
        
        GoodsReviewUtil reviewPageUtil = new GoodsReviewUtil(map);
        PageResult goodsReview = goodsReviewService.getGoodsReview(reviewPageUtil);
        
        int reviewCount = goodsReview.getTotalCount();
        int reviewTotalPage = goodsReview.getTotalPage();
        int reviewCurrentPage = goodsReview.getCurrPage();
        List<GoodsReview> reviewEntityList = (List<GoodsReview>) goodsReview.getList();
        List<GoodsReviewVO> reviewList = new ArrayList<GoodsReviewVO>();
        
        // Set Goods Review Time Format
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < reviewEntityList.size(); i++) {
            GoodsReview rv = reviewEntityList.get(i);
            GoodsReviewVO r = new GoodsReviewVO();
            
        	if (rv != null && rv.getSubmitDate() != null) {
                String dateString = fm.format(rv.getSubmitDate());
                Date date = fm.parse(dateString);
                r.setSubmitDate(dateString);
        	}
        	
        	r.setGoodsId(rv.getGoodsId());
        	r.setReviewId(rv.getReviewId());
        	r.setReviewUserId(rv.getReviewUserId());
        	r.setSankouUserId(rv.getSankouUserId());
        	r.setStar(rv.getStar());
        	r.setReviewTitle(rv.getReviewTitle());
        	r.setReviewDetail(rv.getReviewDetail());
        	r.setImageUrl(rv.getImageUrl());
        	r.setHelpNum(rv.getHelpNum());
        	r.setLimit(rv.getLimit());
        	r.setAverageStar(rv.getAverageStar());
        	reviewList.add(r);
        }
        
        NewBeeMallGoodsDetailVO goodsDetailVO = new NewBeeMallGoodsDetailVO();
        BeanUtil.copyProperties(goods, goodsDetailVO);
        goodsDetailVO.setGoodsCarouselList(goods.getGoodsCarousel().split(","));
        request.setAttribute("goodsDetail", goodsDetailVO);
        // Set GoodsImgList
        request.setAttribute("goodsImgList", goodsImgVoList);
        request.setAttribute("outterList", outterList);
        // Set GoodsDetailList
        request.setAttribute("detailList", detailList);
        // Set QA
        request.setAttribute("qaList", qaList);
        request.setAttribute("qaCount", qaCount);
        request.setAttribute("qaTotalPage", qaTotalPage);
        request.setAttribute("qaCurrentPage", qaCurrentPage);
        // Set Goods Review
        request.setAttribute("reviewList", reviewList);
        request.setAttribute("reviewCount", reviewCount);
        request.setAttribute("reviewTotalPage", reviewTotalPage);
        request.setAttribute("reviewCurrentPage", reviewCurrentPage);
        
        return "mall/detail";
    }
    
    @PostMapping({"/upload/reviewModalPic"})
    @ResponseBody
    public Result reviewModalPic(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws URISyntaxException {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        File fileDirectory = new File(Constants.FILE_UPLOAD_DIC);
        //创建文件
        File destFile = new File(Constants.FILE_UPLOAD_DIC + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            Result resultSuccess = ResultGenerator.genSuccessResult();
            resultSuccess.setData(NewBeeMallUtils.getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/upload/" + newFileName);
            return resultSuccess;
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("文件上传失败");
        }
    }

}
    // GoodsImg
//  @RequestMapping(value = "/goodsImgs", method = RequestMethod.GET)
//  @ResponseBody
//  public Result goodsImgList(@RequestParam long goodsId) {
//  	
//  	List<GoodsImg> goodsImgList = newBeeMallGoodsService.getGoodsImgByGoodsId(goodsId);
//  	if (CollectionUtils.isEmpty(goodsImgList)) {
//  		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
//  	} else {
//  		return ResultGenerator.genSuccessResult(goodsImgList);
//  	}
//  }
    
      // GoodsDetail
//    @RequestMapping(value = "/goodsDetails", method = RequestMethod.GET)
//    @ResponseBody
//    public Result goodsDetailList(@RequestParam long goodsId) {
//    	
//    	List<GoodsDetail> goodsDetailList = newBeeMallGoodsService.getGoodsDetailByGoodsId(goodsId);
//    	if (CollectionUtils.isEmpty(goodsDetailList)) {
//    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
//    	} else {
//    		return ResultGenerator.genSuccessResult(goodsDetailList);
//    	}
//    }
