package com.dev.frontend.panels.list;

import com.dev.frontend.services.Services;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;


public class SalesOrderDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public SalesOrderDataModel() 
	{
		super(new String[]{"Order Number","Customer","Total Price"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_SALESORDER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		//TODO by the candidate
		/*
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
		//String[][] sampleData = new String [][]{{"22423","(01)Customer 1","122.5"},{"22424","(02)Customer 2","3242.5"}};
        System.out.println("******LIST DATA: "+list.toString());
        JSONArray jsonList= (JSONArray) list;
        String[][] data = new String [jsonList.size()][3];
        for(int i = 0; i < jsonList.size(); i++){
            JSONObject jsonObject=(JSONObject)jsonList.get(i);
            data[i][0]= jsonObject.get("orderNumber").toString();
//            data[i][1]="("+jsonObject.get("customer.code").toString()+")"+jsonObject.get("customer.name");
			Map customer = (Map)jsonObject.get("customer");
            data[i][1]="("+customer.get("code").toString()+")"+customer.get("name").toString();
            data[i][2]=jsonObject.get("totalPrice").toString();
        }
        return data;
	}
}
