package com.dev.frontend.panels.list;

import java.util.ArrayList;
import java.util.List;

import com.dev.frontend.services.Services;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ProductDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public ProductDataModel() 
	{
		super(new String[]{"Code","Description","Price","Quantity"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_PRODUCT;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		//TODO by the candidate
		/*
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
		//String[][] sampleData = new String [][]{{"01","Product 1","12.5","25"},{"02","Product 2","10","8"}};

        System.out.println("******LIST DATA: "+list.toString());
        JSONArray jsonList= (JSONArray) list;
        String[][] data = new String [jsonList.size()][4];
        for(int i = 0; i < jsonList.size(); i++){
            data[i][0]=((JSONObject)jsonList.get(i)).get("code").toString();
            data[i][1]=((JSONObject)jsonList.get(i)).get("description").toString();
            data[i][2]=((JSONObject)jsonList.get(i)).get("price").toString();
            data[i][3]=((JSONObject)jsonList.get(i)).get("quantity").toString();
        }
        return data;
	}
}
