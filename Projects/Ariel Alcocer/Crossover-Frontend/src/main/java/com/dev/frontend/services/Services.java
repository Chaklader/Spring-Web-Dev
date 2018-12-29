package com.dev.frontend.services;

import com.dev.frontend.client.MyRestClient;
import com.dev.frontend.panels.ComboBoxItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Services 
{
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;

    private static final Map<Integer, String> urlMap;
    static
    {
        urlMap = new HashMap<>();
        urlMap.put(TYPE_PRODUCT, MyRestClient.BASEURL+"backend/product");
        urlMap.put(TYPE_CUSTOMER, MyRestClient.BASEURL+"backend/customer");
        urlMap.put(TYPE_SALESORDER, MyRestClient.BASEURL+"backend/salesorder");
    }
        public static Object save(Object object,int objectType)
	{
		//TODO by the candidate 
		/*
		 * This method is called eventually after you click save on any edit screen
		 * object parameter is the return object from calling method guiToObject on edit screen
		 * and the type is identifier of the object type and may be TYPE_PRODUCT ,
		 * TYPE_CUSTOMER or TYPE_SALESORDER 
		 */
        System.out.println("***********************SAVE " + object.toString());
        return MyRestClient.postRequest(
                Services.urlMap.get(objectType),
                object.toString());
	}
	public static Object readRecordByCode(String code,int objectType)
	{
		//TODO by the candidate
		/*
		 * This method is called when you select record in list view of any entity
		 * and also called after you save a record to re-bind the record again
		 * the code parameter is the first column of the row you have selected
		 * and the type is identifier of the object type and may be TYPE_PRODUCT ,
		 * TYPE_CUSTOMER or TYPE_SALESORDER */

        System.out.println("***********************READ " + code);
        return MyRestClient.getRequest(
                Services.urlMap.get(objectType)+"/" + code);
	}
	public static boolean deleteRecordByCode(String code,int objectType)
	{
		//TODO by the candidate
		/*
		 * This method is called when you click delete button on an edit view
		 * the code parameter is the code of (Customer - PRoduct ) or order number of Sales Order
		 * and the type is identifier of the object type and may be TYPE_PRODUCT ,
		 * TYPE_CUSTOMER or TYPE_SALESORDER
		 */
        MyRestClient.deleteRequest(
                 Services.urlMap.get(objectType)+"/"+ code);

		return true;
	}
	
	public static List<Object> listCurrentRecords(int objectType)
	{
		//TODO by the candidate
		/*
		 * This method is called when you open any list screen and should return all records of the specified type
		 */
        System.out.println("***********************LIST ");
        return MyRestClient.getRequestForArray(
                Services.urlMap.get(objectType));
	}
	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) 
	{	
		//TODO by the candidate
		/*
		 * This method is called when a Combo Box need to be initialized and should
		 * return list of ComboBoxItem which contains code and description/name for all records of specified type
		 */
        JSONArray items= MyRestClient.getRequestForArray(
                Services.urlMap.get(objectType));
        ArrayList<ComboBoxItem> comboBoxItems=new ArrayList<>();
        for (Object item : items) {
            JSONObject itemObject=(JSONObject)item;
            String value=itemObject.get("code").toString();
            String label=itemObject.get("code").toString();
            if(objectType==TYPE_CUSTOMER){
                label=itemObject.get("name").toString();
            }
            else if(objectType==TYPE_PRODUCT){
                label=itemObject.get("description").toString();
            }
            System.out.println("******%%%%%%%%%%%%%%%%%%%%%% item: "+item.toString());
            comboBoxItems.add(new ComboBoxItem(value,label));
        }

		return comboBoxItems;
	}
	public static double getProductPrice(String productCode) {
		//TODO by the candidate
		/*
		 * This method is used to get unit price of product with the code passed as a parameter
		 */
        System.out.println("***********************READ " + productCode);
        JSONObject product = MyRestClient.getRequest(
                Services.urlMap.get(1) + "/" + productCode);
        return Double.parseDouble(product.get("price").toString());
	}
}
