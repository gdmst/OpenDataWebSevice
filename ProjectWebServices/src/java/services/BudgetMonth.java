/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.xml.bind.JAXB;

/**
 * REST Web Service
 *
 * @author bismuth
 */
@Path("BudgetMonth")
public class BudgetMonth {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BudgetMonth
     */
    public BudgetMonth() {
    }

    /**
     * Retrieves representation of an instance of services.BudgetMonth
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{year}/{dept_ID}")
    @Produces("application/json")
    public String getJson(@PathParam("year") String year,@PathParam("dept_ID") String dept_id) {
            String apiKey = "gZDm7sYi3CBvDRkcM7OBoQvojwEE4GDq";
        try {
            URL url = new URL("https://opend.data.go.th/govspending/gf_per_month?api-key="+apiKey+"&year="+year+"&dept_id="+dept_id);
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
            
            return response.toString();

        }
        catch (Exception e){
            StringWriter writer = new StringWriter();
            JAXB.marshal("error", writer);
            return "{'error': 'error'}";
        }
    }
    /**
     * PUT method for updating or creating an instance of BudgetMonth
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
