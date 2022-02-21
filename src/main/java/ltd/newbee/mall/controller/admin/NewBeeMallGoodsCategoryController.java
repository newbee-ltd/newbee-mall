/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.admin;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import ltd.newbee.mall.common.NewBeeMallCategoryLevelEnum;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.GoodsCampaignVO;
import ltd.newbee.mall.entity.Campaign;
import ltd.newbee.mall.entity.GoodsCampaign;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 */
@Controller
@RequestMapping("/admin")
public class NewBeeMallGoodsCategoryController {

    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;

    @GetMapping("/categories")
    public String categoriesPage(HttpServletRequest request, @RequestParam("categoryLevel") Byte categoryLevel, @RequestParam("parentId") Long parentId, @RequestParam("backParentId") Long backParentId) {
        if (categoryLevel == null || categoryLevel < 1 || categoryLevel > 3) {
            return "error/error_5xx";
        }
        request.setAttribute("path", "newbee_mall_category");
        request.setAttribute("parentId", parentId);
        request.setAttribute("backParentId", backParentId);
        request.setAttribute("categoryLevel", categoryLevel);
        return "admin/newbee_mall_category";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/categories/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit")) || StringUtils.isEmpty(params.get("categoryLevel")) || StringUtils.isEmpty(params.get("parentId"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(newBeeMallCategoryService.getCategorisPage(pageUtil));
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/categories/listForSelect", method = RequestMethod.GET)
    @ResponseBody
    public Result listForSelect(@RequestParam("categoryId") Long categoryId) {
        if (categoryId == null || categoryId < 1) {
            return ResultGenerator.genFailResult("缺少参数！");
        }
        GoodsCategory category = newBeeMallCategoryService.getGoodsCategoryById(categoryId);
        //既不是一级分类也不是二级分类则为不返回数据
        if (category == null || category.getCategoryLevel() == NewBeeMallCategoryLevelEnum.LEVEL_THREE.getLevel()) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Map categoryResult = new HashMap(4);
        if (category.getCategoryLevel() == NewBeeMallCategoryLevelEnum.LEVEL_ONE.getLevel()) {
            //如果是一级分类则返回当前一级分类下的所有二级分类，以及二级分类列表中第一条数据下的所有三级分类列表
            //查询一级分类列表中第一个实体的所有二级分类
            List<GoodsCategory> secondLevelCategories = newBeeMallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(categoryId), NewBeeMallCategoryLevelEnum.LEVEL_TWO.getLevel());
            if (!CollectionUtils.isEmpty(secondLevelCategories)) {
                //查询二级分类列表中第一个实体的所有三级分类
                List<GoodsCategory> thirdLevelCategories = newBeeMallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(secondLevelCategories.get(0).getCategoryId()), NewBeeMallCategoryLevelEnum.LEVEL_THREE.getLevel());
                categoryResult.put("secondLevelCategories", secondLevelCategories);
                categoryResult.put("thirdLevelCategories", thirdLevelCategories);
            }
        }
        if (category.getCategoryLevel() == NewBeeMallCategoryLevelEnum.LEVEL_TWO.getLevel()) {
            //如果是二级分类则返回当前分类下的所有三级分类列表
            List<GoodsCategory> thirdLevelCategories = newBeeMallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(categoryId), NewBeeMallCategoryLevelEnum.LEVEL_THREE.getLevel());
            categoryResult.put("thirdLevelCategories", thirdLevelCategories);
        }
        return ResultGenerator.genSuccessResult(categoryResult);
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/categories/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody GoodsCategory goodsCategory) {
        if (Objects.isNull(goodsCategory.getCategoryLevel())
                || StringUtils.isEmpty(goodsCategory.getCategoryName())
                || Objects.isNull(goodsCategory.getParentId())
                || Objects.isNull(goodsCategory.getCategoryRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = newBeeMallCategoryService.saveCategory(goodsCategory);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }


    /**
     * 修改
     */
    @RequestMapping(value = "/categories/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody GoodsCategory goodsCategory) {
        if (Objects.isNull(goodsCategory.getCategoryId())
                || Objects.isNull(goodsCategory.getCategoryLevel())
                || StringUtils.isEmpty(goodsCategory.getCategoryName())
                || Objects.isNull(goodsCategory.getParentId())
                || Objects.isNull(goodsCategory.getCategoryRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = newBeeMallCategoryService.updateGoodsCategory(goodsCategory);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 详情
     */
    @GetMapping("/categories/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Long id) {
        GoodsCategory goodsCategory = newBeeMallCategoryService.getGoodsCategoryById(id);
        if (goodsCategory == null) {
            return ResultGenerator.genFailResult("未查询到数据");
        }
        return ResultGenerator.genSuccessResult(goodsCategory);
    }

    /**
     * 分类删除
     */
    @RequestMapping(value = "/categories/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (newBeeMallCategoryService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    @GetMapping("/campaign")
    public String campaignPage(HttpServletRequest request) {
        
        request.setAttribute("path", "campaign");
        return "admin/campaign";
    }
    
    @RequestMapping(value = "/campaign/list", method = RequestMethod.GET)
    @ResponseBody
    public Result campaignList(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(newBeeMallCategoryService.getCampaignPage(pageUtil));
    }
    
    
	@RequestMapping(value = "/campaign/save", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCampaign(@RequestBody Campaign campaign,HttpServletRequest request) {
		
		String loginUserId =  request.getSession().getAttribute("loginUserId").toString();
		 
		Long camId = newBeeMallCategoryService.getMaxCampaignId();
		Long newCamId = camId+1;
		Date insertDate = new Date();
		String camName = campaign.getCamName();
		Campaign camInfo = newBeeMallCategoryService.getCampaignInfo(camName);
		
		
		campaign.setCreateUser(loginUserId); 
		campaign.setCamId(newCamId);
		campaign.setTimeStamp(insertDate);
		campaign.setCamKind(camInfo.getCamKind());
		campaign.setPriority(camInfo.getPriority());
		
		int row = newBeeMallCategoryService.insertNewCampaign(campaign);
		if(row>0) {
			 return ResultGenerator.genSuccessResult("添加成功");
			 }
		else {
			 return ResultGenerator.genErrorResult(404,"添加失败");
		 }
		
	}
	
	@RequestMapping(value = "/campaign/edit", method = RequestMethod.POST)
    @ResponseBody
    public Result editCampaign(@RequestBody Map<String,Object>params,HttpServletRequest request) {
		
		String loginUserId =  request.getSession().getAttribute("loginUserId").toString();
		Long camId = Long.parseLong(params.get("camId").toString());
		String camName = params.get("camName").toString();
		Campaign camInfo = newBeeMallCategoryService.getCampaignInfo(camName);
		String camKind = camInfo.getCamKind();
		int priority = camInfo.getPriority();
		Date editDate = new Date();
	
		
		Campaign newCam = newBeeMallCategoryService.getCampaignById(camId);
		newCam.setCamId(camId);
		newCam.setCal1(params.get("cal1").toString());
		newCam.setCamKind(camKind);
		newCam.setPriority(priority);
		newCam.setTimeStamp(editDate);
		newCam.setCamName(camName);
		newCam.setCreateUser(loginUserId);
		
		int row = newBeeMallCategoryService.updateByCamId(newCam);
		
		if(row>0) {
			 return ResultGenerator.genSuccessResult("修改成功");
			 }
		else {
			 return ResultGenerator.genErrorResult(404,"修改失败");
		 
		
		}
		}
	
    @RequestMapping(value = "/campaign/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCampaign(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (newBeeMallCategoryService.deleteCampaign(ids)) { 
        	return ResultGenerator.genSuccessResult();
            
        } else {
        	return ResultGenerator.genFailResult("删除失败");
        }
    }
    
    @GetMapping("/goodsCampaign")
    public String goodsCampaignPage(HttpServletRequest request) {
    	List<GoodsCampaign>goodsCampaignList = newBeeMallCategoryService.getGoodsCampaignContent();
    	List<GoodsCampaignVO> goodsCampaignVOList = BeanUtil.copyList(goodsCampaignList, GoodsCampaignVO.class);
    	request.setAttribute("path", "goodsCampaign");
		request.setAttribute("goodsCampaign", goodsCampaignVOList);
		return "admin/goodsCampaign";
    }
    
    @RequestMapping(value = "/goodsCampaign/list", method = RequestMethod.GET)
    @ResponseBody
    public Result goodsCampaignList(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(newBeeMallCategoryService.getGoodsCampaignPage(pageUtil));
    }
    
    @RequestMapping(value = "/goodsCampaign/update", method = RequestMethod.POST)
    @ResponseBody
    public Result updateGoodsCam(@RequestBody Object[] values) {
    	ObjectMapper oMapper = new ObjectMapper();
    	Object obj = Array.get(values, 0);
    	Map<String, Object> map = oMapper.convertValue(obj, Map.class);
    	Long newCamId = Long.parseLong(map.get("camId").toString());
    	int flag = Integer.parseInt(map.get("flag").toString());
        Long goodsId = Long.parseLong(map.get("goodsId").toString());
        Date starDate = new Date();
        Date endDate = new Date();
        GoodsCampaign goodsCam = newBeeMallCategoryService.getGoodsCampaignByGoodsId(goodsId);
        goodsCam.setCamId(newCamId);
        goodsCam.setStartDate(starDate);
        goodsCam.setEndDate(endDate);
        int row = 0;
        if(flag == 0) {
        	row = newBeeMallCategoryService.setNewGoodsCam(goodsCam);
        }
        if(flag == 1) {
        	row = newBeeMallCategoryService.insertNewGoodsCampaign(goodsCam);
        }
        if(flag == 2) {
        	row = newBeeMallCategoryService.deleteGoodsCam(goodsCam);
        }
        if (row>0) { 
        	return ResultGenerator.genSuccessResult("更新成功");
            
        } else {
        	return ResultGenerator.genFailResult("更新失败"); 
        }
    }
    
    @RequestMapping(value = "/goodsCampaign/campaignList", method = RequestMethod.POST)
    @ResponseBody
    public Result camList() {
    	List<GoodsCampaign>goodsCampaignList = newBeeMallCategoryService.getGoodsCampaignContent();
    	List<GoodsCampaignVO> goodsCampaignVOList = BeanUtil.copyList(goodsCampaignList, GoodsCampaignVO.class);
    	
        return ResultGenerator.genSuccessResult(goodsCampaignVOList); 
        
    }

}