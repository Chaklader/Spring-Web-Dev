package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.services.Services;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CustomerDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747613655L;

	public CustomerDataModel()
	{
		super(new String[] { "Code", "Name", "Phone", "Current Credit" }, 0);
	}

	@Override
	public int getObjectType()
	{
		return Services.TYPE_CUSTOMER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list)
	{
		//TODO by the candidate
		/*
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
		//String[][] sampleData = new String [][]{{"01","Customer 1","+201011121314","23.4"},{"02","Customer 2","+201112131415","1.4"}};
        System.out.println("******LIST DATA: "+list.toString());
        JSONArray jsonList= (JSONArray) list;
        String[][] data = new String [jsonList.size()][4];
        for(int i = 0; i < jsonList.size(); i++){
            data[i][0]=((JSONObject)jsonList.get(i)).get("code").toString();
            data[i][1]=((JSONObject)jsonList.get(i)).get("name").toString();
            data[i][2]=((JSONObject)jsonList.get(i)).get("phone1").toString();
            data[i][3]=((JSONObject)jsonList.get(i)).get("currentCredit").toString();
        }
        return data;
	}
}
