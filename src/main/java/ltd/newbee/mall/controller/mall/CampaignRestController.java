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
import ltd.newbee.mall.entity.CampaignCategory;
import ltd.newbee.mall.entity.CampaignGoods;
import ltd.newbee.mall.service.CampaignService;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import ltd.newbee.mall.util.TimeFormartUtil;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

@Controller
public class CampaignRestController {

    @Resource
    private CampaignService campaignService;
    
    // campaign查询
    @RequestMapping(value = "/campaigns", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam long parentId) {
    	
    	ArrayList<CampaignGoods> goodsList = campaignService.getCampaignGoods(parentId);
    	if (goodsList != null && goodsList.size() > 0) {
    		return ResultGenerator.genSuccessResult(goodsList);
    	} else {
    		ArrayList<CampaignCategory> categoryList = campaignService.getCampaignCategory(parentId);
    		return ResultGenerator.genSuccessResult(categoryList);
    	}
    }
    
    // キャンペーン適用(商品)
    @RequestMapping(value = "/campaigns/goods", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCampaignGoods(@RequestBody CampaignGoods campaignGoods) {
    	
    	long count = campaignService.insertCampaignGoods(campaignGoods);
    	if (count <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.CAMPAIGNGOODS_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(Constants.CAMPAIGNINSERT_FETCH_SUCCESS_MESSAGE);
    	}
    }
    
    // キャンペーン適用(カテゴリー)
    @RequestMapping(value = "/campaigns/category", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCampaignCategory(@RequestBody CampaignCategory campaignCategory) {
    	
    	long count = campaignService.insertCampaignCategory(campaignCategory);
    	if (count <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.CAMPAIGNCATEGORY_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(Constants.CAMPAIGNINSERT_FETCH_SUCCESS_MESSAGE);
    	}
    }
    
    // キャンペーン削除(商品)
    @PutMapping(value = "/campaigns/goods")
    @ResponseBody
    public Result updateCampaignGoods(@RequestBody CampaignGoods campaignGoods) {
    	
    	long countUpdateCampaignGoods = campaignService.updateCampaignGoods(campaignGoods);
    	if (countUpdateCampaignGoods <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.CAMPAIGN_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(Constants.CAMPAIGNDELETE_FETCH_SUCCESS_MESSAGE);
    	}
    }
    
 	// キャンペーン削除(カテゴリー)
    @PutMapping(value = "/campaigns/category")
    @ResponseBody
    public Result updateCampaignCategory(@RequestBody CampaignCategory campaignCategory) {
    	
    	long countUpdateCampaignCategory = campaignService.updateCampaignCategory(campaignCategory);
    	if (countUpdateCampaignCategory <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.CAMPAIGN_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(Constants.CAMPAIGNDELETE_FETCH_SUCCESS_MESSAGE);
    	}
    }
    
    // キャンペーン情報のdropDownListのAPI
    @RequestMapping(value = "/campaigns/dropDownList", method = RequestMethod.GET)
    @ResponseBody
    public Result dropDownList(@RequestParam String campaignName) {
    	
    	List<CampaignGoods> goodsDropDownList = campaignService.getGoodsDropDownList(campaignName);
    	List<CampaignCategory> categoryDropDownList = campaignService.getCategoryDropDownList(campaignName);
    	if (CollectionUtils.isEmpty(goodsDropDownList) && CollectionUtils.isEmpty(categoryDropDownList)) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(goodsDropDownList.addAll(goodsDropDownList));
    	}
    }
    
    // csvファイル読み込み(商品)
    @RequestMapping(value = "/campaigns/cvsCampaignGoods", method = RequestMethod.POST)
    @ResponseBody
    public Result cvsCampaignGoods(@RequestParam String filePath) {
    	
    	  BufferedReader br = null;
    	  //String file_name = "cvsCampaignGoods.txt"; // 入力ファイル
    	  
    	  //declaration
    	  String line = null;// readLineで一行ずつ読み込む
    	  ArrayList<String> msgList = new ArrayList<String>();
    	  
    	  try {
    	      File file = new File(filePath);
    	      br = new BufferedReader(new FileReader(file));
    	      
    	      String[] data; // 分割後のデータを保持する配列
    	      int row = 1;
    	      while ((line = br.readLine()) != null) {
    	          // lineをカンマで分割し、配列dataに設定
    	          data = line.split(",");  
    	          
    	          row++;
    	          // goods_idは商品マスタに存在するかどうかをチェック
    	          long count = campaignService.checkGoodsIdExist(Long.parseLong(data[0]));
    	       	  if (count == 0) { 
        	   	      msgList.add(line + row + "行目: " + "good_id" + Long.parseLong(data[0]) + "は商品マスターに存在しない");
                  } 
    	       	  
    	       	  // campaign_idはキャンペーンマスタに存在するかどうかをチェック
    	      	  List<CampaignGoods> campaignIdList = campaignService.checkCampaignIdExist(Long.parseLong(data[1]));
                  if (campaignIdList == null || campaignIdList.isEmpty()) {
    	              msgList.add(line + row + "行目: " + "campaign_id" + Long.parseLong(data[1]) + "はキャンペーンマスターに存在しない");
                  }
                  
    	          //　日付の妥当性のチェック
            	  SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
    	          if ((date.parse(data[6])).before(date.parse(data[7])) == false) {
    	         	  msgList.add(line + row + "行目: " + "valid_date_from" + Long.parseLong(data[6]) + "は" + "valid_date_to" + Long.parseLong(data[7]) + "より遅い");
    	       	  }
    	         
    	          //　日付のフォーマットのチェック
    	          if (!TimeFormartUtil.isValidDate(data[2])) {
    	        	  msgList.add(line + row + "行目: " + "insert_date" + Long.parseLong(data[2]) + "は不正な日付である");
    	          }
    	          if (!TimeFormartUtil.isValidDate(data[4])) {
    	        	  msgList.add(line + row + "行目: " + "update_date" + Long.parseLong(data[4]) + "は不正な日付である");
    	          }
    	          if (!TimeFormartUtil.isValidDate(data[6])) {
    	        	  msgList.add(line + row + "行目: " + "valid_date_from" + Long.parseLong(data[6]) + "は不正な日付である");
    	          }
    	          if (!TimeFormartUtil.isValidDate(data[7])) {
    	        	  msgList.add(line + row + "行目: " + "valid_date_to" + Long.parseLong(data[7]) + "は不正な日付である");
    	          }
    	          
    	          // 1行分の読み込みデータを表示（データ間にスペース)
    	          CampaignGoods campaignGoods = new CampaignGoods();
    	          campaignGoods.setGoodsId(Long.parseLong(data[0]));
    	          campaignGoods.setCampaignId(Long.parseLong(data[1]));
    	          campaignGoods.setInsertDate(date.parse(data[2]));
    	          campaignGoods.setInsertUser(Long.parseLong(data[3]));
    	          campaignGoods.setUpdateDate(date.parse(data[4]));
    	          campaignGoods.setUpdateUser(Long.parseLong(data[5]));
    	          campaignGoods.setValidDateFrom(date.parse(data[6]));
    	          campaignGoods.setValidDateTo(date.parse(data[7]));
    	          campaignGoods.setDeleteFlg(Integer.parseInt(data[8]));
    	          campaignService.insertCampaignGoods(campaignGoods);
    	          
    	      }    
    	  } catch (Exception e) {
    	      System.out.println(e.getMessage());
    	      msgList.add(line + e.getMessage());
    	  } finally {
    	      try {
    	          br.close();
    	      } catch (Exception e) {
    	          System.out.println(e.getMessage());
    	      }
    	  }
		  
		  // 読み込みが失敗したデータの出力
//    	      File file = new File("/Users/administrator/Desktop/project/CampainGoodsFalse.txt");
		      try {
//		    	  if (!file.exists()) {
//		    		  file.createNewFile();
//		    	  }
		    	  
		      // 出力ファイルの作成
              FileWriter fw = new FileWriter("/Users/administrator/Desktop/project/CampainGoodsFalse.txt", false);
              // PrintWriterクラスのオブジェクトを生成
              PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

              // ヘッダーの指定
              pw.print("goods_id");
              pw.print(",");
              pw.print("campaign_id");
              pw.print(",");
              pw.print("insert_date");
              pw.print(",");
              pw.print("insert_user");
              pw.print(",");
              pw.print("update_date");
              pw.print(",");
              pw.print("update_user");
              pw.print(",");
              pw.print("valid_date_from");
              pw.print(",");
              pw.print("valid_date_to");
              pw.print(",");
              pw.print("delete_flg");
              pw.println();

              // データを書き込む
              for (String goods: msgList){
            	    pw.println(goods);   
              }

              // ファイルを閉じる
              pw.close();

              // 出力確認用のメッセージ
              System.out.println("csvファイルを出力しました");

              // 出力に失敗したときの処理
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
              return ResultGenerator.genSuccessResult(Constants.SUCCESS_MESSAGE);	
    }
    
    // campaignList
    @RequestMapping(value = "/campaigns/campaignList", method = RequestMethod.GET)
    @ResponseBody
    public Result list() {
    	
    	List<CampaignCategory> campaignList = campaignService.dropDownList();
    	if (CollectionUtils.isEmpty(campaignList)) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(campaignList);
    	}
    }
    
}	
