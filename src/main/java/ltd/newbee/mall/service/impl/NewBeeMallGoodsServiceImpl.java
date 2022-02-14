/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.common.NewBeeMallCategoryLevelEnum;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.NewBeeMallSearchGoodsVO;
import ltd.newbee.mall.dao.GoodsCategoryMapper;
import ltd.newbee.mall.dao.NewBeeMallGoodsMapper;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.entity.GoodsImageEntity;
import ltd.newbee.mall.entity.GoodsInfo;

import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.InsertGoodsQaLike;
import ltd.newbee.mall.entity.InsertGoodsReview;
import ltd.newbee.mall.entity.InsertGoodsReviewLike;
import ltd.newbee.mall.entity.InsertSearchHistoryEntity;

import ltd.newbee.mall.entity.GoodsPageEntity;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;

import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.RecentChkHistory;
import ltd.newbee.mall.entity.SearchHistoryEntity;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import ltd.newbee.mall.util.SearchPageParams;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewBeeMallGoodsServiceImpl implements NewBeeMallGoodsService {

    @Autowired
    private NewBeeMallGoodsMapper goodsMapper;
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public PageResult getNewBeeMallGoodsPage(PageQueryUtil pageUtil) {
        List<NewBeeMallGoods> goodsList = goodsMapper.findNewBeeMallGoodsList(pageUtil);
        int total = goodsMapper.getTotalNewBeeMallGoods(pageUtil);
        PageResult pageResult = new PageResult(goodsList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveNewBeeMallGoods(NewBeeMallGoods goods) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(goods.getGoodsCategoryId());
        // 分类不存在或者不是三级分类，则该参数字段异常
        if (goodsCategory == null || goodsCategory.getCategoryLevel().intValue() != NewBeeMallCategoryLevelEnum.LEVEL_THREE.getLevel()) {
            return ServiceResultEnum.GOODS_CATEGORY_ERROR.getResult();
        }
        if (goodsMapper.selectByCategoryIdAndName(goods.getGoodsName(), goods.getGoodsCategoryId()) != null) {
            return ServiceResultEnum.SAME_GOODS_EXIST.getResult();
        }
        if (goodsMapper.insertSelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public void batchSaveNewBeeMallGoods(List<NewBeeMallGoods> newBeeMallGoodsList) {
        if (!CollectionUtils.isEmpty(newBeeMallGoodsList)) {
            goodsMapper.batchInsert(newBeeMallGoodsList);
        }
    }

    @Override
    public String updateNewBeeMallGoods(NewBeeMallGoods goods) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(goods.getGoodsCategoryId());
        // 分类不存在或者不是三级分类，则该参数字段异常
        if (goodsCategory == null || goodsCategory.getCategoryLevel().intValue() != NewBeeMallCategoryLevelEnum.LEVEL_THREE.getLevel()) {
            return ServiceResultEnum.GOODS_CATEGORY_ERROR.getResult();
        }
        NewBeeMallGoods temp = goodsMapper.selectByPrimaryKey(goods.getGoodsId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        NewBeeMallGoods temp2 = goodsMapper.selectByCategoryIdAndName(goods.getGoodsName(), goods.getGoodsCategoryId());
        if (temp2 != null && !temp2.getGoodsId().equals(goods.getGoodsId())) {
            //name和分类id相同且不同id 不能继续修改
            return ServiceResultEnum.SAME_GOODS_EXIST.getResult();
        }
        goods.setUpdateTime(new Date());
        if (goodsMapper.updateByPrimaryKeySelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public NewBeeMallGoods getNewBeeMallGoodsById(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public Boolean batchUpdateSellStatus(Long[] ids, int sellStatus) {
        return goodsMapper.batchUpdateSellStatus(ids, sellStatus) > 0;
    }

    @Override
    public PageResult searchNewBeeMallGoods(PageQueryUtil pageUtil) {
        List<NewBeeMallGoods> goodsList = goodsMapper.findNewBeeMallGoodsListBySearch(pageUtil);
        int total = goodsMapper.getTotalNewBeeMallGoodsBySearch(pageUtil);
        List<NewBeeMallSearchGoodsVO> newBeeMallSearchGoodsVOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(goodsList)) {
            newBeeMallSearchGoodsVOS = BeanUtil.copyList(goodsList, NewBeeMallSearchGoodsVO.class);
            for (NewBeeMallSearchGoodsVO newBeeMallSearchGoodsVO : newBeeMallSearchGoodsVOS) {
                String goodsName = newBeeMallSearchGoodsVO.getGoodsName();
                String goodsIntro = newBeeMallSearchGoodsVO.getGoodsIntro();
                // 字符串过长导致文字超出的问题
                if (goodsName.length() > 28) {
                    goodsName = goodsName.substring(0, 28) + "...";
                    newBeeMallSearchGoodsVO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 30) {
                    goodsIntro = goodsIntro.substring(0, 30) + "...";
                    newBeeMallSearchGoodsVO.setGoodsIntro(goodsIntro);
                }
            }
        }
        PageResult pageResult = new PageResult(newBeeMallSearchGoodsVOS, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

	@Override
	public GoodsInfo getGoodsInfoByPK(Long id) {
		
		return goodsMapper.getGoodsInfoByPK(id);
	}

	@Override
	public ArrayList<GoodsImageEntity> getGoodsImageByPk(Long id) {
		
		return goodsMapper.getGoodsImageByPk(id);
	}

	@Override
	public ArrayList<NewBeeMallGoods> getGoodsPage(Map<String,Object>params2) {

			return goodsMapper.getGoodsPage(params2);
		}

	@Override

	public ArrayList<GoodsQa> getGoodsQa(Map<String,Object>params) {
		
		return goodsMapper.getGoodsQa(params);
    }

	@Override
	public GoodsQa getGoodsQaPage(Long count2) {
		
		return getGoodsQaPage(count2);
	}

	@Override
	public ArrayList<GoodsReview> getGoodsReview(Map<String, Object> params) {
		
		return goodsMapper.getGoodsReview(params);
	}

	@Override
	public Double getRateAvg(Long goodsId) {
		
		return goodsMapper.getRateAvg(goodsId);
	}

	@Override
	public Long getReviewCount(Long goodsId) {
	
		return goodsMapper.getReviewCount(goodsId);
	}

	@Override
	public Long[] getRateCount(Long goodsId) {
		
		return goodsMapper.getRateCount(goodsId);
	}


	@Override
	public int insertGoodsReview(GoodsReview review) {
		
		return goodsMapper.insertGoodsReview(review);
	}

	@Override
	public ArrayList<String> getSearchHistory() {
	
		return goodsMapper.getSearchHistory();
	}

	@Override
	public int insertSearchHistory(InsertSearchHistoryEntity history) {
		
		return goodsMapper.insertSearchHistory(history);
	}

	@Override
	public ArrayList<String> getGoodsName(String keyword) {
		
		return goodsMapper.getGoodsName(keyword);
	}

	@Override
	public ArrayList<RecentChkHistory> getRecentChkHistory() {
		
		return goodsMapper.getRecentChkHistory();
	}

	@Override
	public Long getGoodsQaCount(Long goodsId) {
		
		return goodsMapper.getGoodsQaCount(goodsId);
	}

	@Override
	public int insertGoodsQa(GoodsQa goodsQa) {
		
		return goodsMapper.insertGoodsQa(goodsQa);
	}

	@Override
	public Long getMaxQaId(Long goodsId) {
		
		return goodsMapper.getMaxQaId(goodsId);
	}

	@Override
	public int getQaLikeUserId(Map<String, Object> params) {
		
		return goodsMapper.getQaLikeUserId(params);
	}

	@Override
	public int insertGoodsQaLike(InsertGoodsQaLike qa) {
		
		return goodsMapper.insertGoodsQaLike(qa);
	}

	@Override
	public int insertGoodsReviewLike(InsertGoodsReviewLike reviewLike) {
		
		return goodsMapper.insertGoodsReviewLike(reviewLike);
	}

	@Override
	public int getReviewLikeUserId(Map<String, Object> params) {
		
		return goodsMapper.getReviewLikeUserId(params);
	}

	@Override
	public Long getMaxReviewId(Long goodsId) {
		
		return goodsMapper.getMaxReviewId(goodsId);
	}






	}
	

	

	



	

