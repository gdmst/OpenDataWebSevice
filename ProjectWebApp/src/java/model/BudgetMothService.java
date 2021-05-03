/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import util.BG_Month;
import util.BG_Strat;

/**
 *
 * @author bismuth
 */
public class BudgetMothService {
    public static List<BudgetMonth> getData(String year, String dept_id){
        
        BG_Month bb_m = new BG_Month();
        String response = bb_m.getJson(year, dept_id);
        //System.out.println(response);
        JSONObject jsonObject = new JSONObject(response);
        List<BudgetMonth> bgmmList = new ArrayList<>();
        JSONArray jsonArray=jsonObject.getJSONArray("result");
                //System.out.println("Title : "+jsonArray.getJSONObject(0));
                //JSONArray jsonArray=new JSONArray(response.toString());

        BudgetMonth bgmm = null;
        for (int i=0;i<jsonArray.length();i++){
            bgmm = new BudgetMonth();
            bgmm.setMonth(jsonArray.getJSONObject(i).getInt("month"));
            bgmm.setAmount(jsonArray.getJSONObject(i).getDouble("amount"));
            bgmm.setYear(jsonArray.getJSONObject(i).getInt("year"));
            bgmmList.add(bgmm);
        }
        return bgmmList;
    }
}
