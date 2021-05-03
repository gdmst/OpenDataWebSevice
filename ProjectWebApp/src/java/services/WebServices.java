/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import model.BudgetMonth;
import model.BudgetMothService;
import model.BudgetStrat;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebServices {
    public static void main(String args[]){
        System.out.println("HTTP Request Example ");
        //Making Get Request
        //sendGetRequest();
        //Making Post Request
        //sendPOSTRequest();
        //Parse Json Reponse
        //ParseJsonResponse();
        BudgetMothService bbmmSer = new BudgetMothService();
        List<BudgetMonth> bbmmList = bbmmSer.getData("2562", "01000");
        for(BudgetMonth bbmm: bbmmList){
            System.out.println(bbmm.getAmount());
        }
    }

    public static void sendGetRequest(){
        try {
            URL url = new URL("https://opend.data.go.th/govspending/gf_per_month?api-key=gZDm7sYi3CBvDRkcM7OBoQvojwEE4GDq&year=2562&dept_id=01000");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            //adding header
            /*
            httpURLConnection.setRequestProperty("api-key","gZDm7sYi3CBvDRkcM7OBoQvojwEE4GDq");
            
            httpURLConnection.setRequestProperty("year","2562");
            httpURLConnection.setRequestProperty("dept_id","01000");*/

            String line="";
            InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuilder response=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                response.append(line);
            }
            bufferedReader.close();
            System.out.println("Response : "+response.toString());

        }
        catch (Exception e){
            System.out.println("Error in Making Get Request");
        }
    }



    public static void sendPOSTRequest(){
        try {
            String post_data="key1=value1&key2=value2";

            URL url = new URL("https://opend.data.go.th/govspending/gf_per_month?api-key=gZDm7sYi3CBvDRkcM7OBoQvojwEE4GDq&year=2562&dept_id=01000");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            //adding header
            //httpURLConnection.setRequestProperty("Auth","Token");
            //httpURLConnection.setRequestProperty("Data1","Value1");
            httpURLConnection.setDoOutput(true);

            //Adding Post Data
            /*
            OutputStream outputStream=httpURLConnection.getOutputStream();
            outputStream.write(post_data.getBytes());
            outputStream.flush();
            outputStream.close();
            */


            System.out.println("Response Code "+httpURLConnection.getResponseCode());

            String line="";
            InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuilder response=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                response.append(line);
            }
            bufferedReader.close();
            System.out.println("Response : "+response.toString());



        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Error in Making POST Request");
        }
    }


    public static void ParseJsonResponse(){
        try {
            String apiKey = "gZDm7sYi3CBvDRkcM7OBoQvojwEE4GDq";
            String year = "2562";
            String deptId = "01000";
            URL url = new URL("https://opend.data.go.th/govspending/bb_stg?api-key="+apiKey+"&year="+year+"&dept_id="+deptId);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            //adding header
            
            String line="";
            InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuilder response=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                response.append(line);
            }
            bufferedReader.close();
            System.out.println("Response : "+response.toString());
            JSONObject jsonObject = new JSONObject(response.toString());
            System.out.println(jsonObject.get("time"));
            List<BudgetStrat> bgstList = new ArrayList<>();
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
        }
        catch (Exception e){
            System.out.println("Error in Making Get Request");
        }
    }
}