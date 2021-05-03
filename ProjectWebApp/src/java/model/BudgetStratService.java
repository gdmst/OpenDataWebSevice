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
import util.BG_Strat;

/**
 *
 * @author bismuth
 */
public class BudgetStratService {
    public static List<BudgetStrat> getData(String year, String dept_id){
        
        BG_Strat bb_m = new BG_Strat();
        String response = bb_m.getJson(year, dept_id);
        JSONObject jsonObject = new JSONObject(response.toString());
        List<BudgetStrat> bgstList = new ArrayList<BudgetStrat>();
        JSONArray jsonArray=jsonObject.getJSONArray("result");
                //System.out.println("Title : "+jsonArray.getJSONObject(0));
                //JSONArray jsonArray=new JSONArray(response.toString());

        BudgetStrat bgst = null;
        for (int i=0;i<jsonArray.length();i++){
            bgst = new BudgetStrat();
            bgst.setStg_name(jsonArray.getJSONObject(i).getString("stg_name"));
            bgst.setAmount(jsonArray.getJSONObject(i).getDouble("amount"));
            bgst.setPercent(jsonArray.getJSONObject(i).getDouble("percent"));
            bgstList.add(bgst);
        }
        return bgstList;
    }
}
