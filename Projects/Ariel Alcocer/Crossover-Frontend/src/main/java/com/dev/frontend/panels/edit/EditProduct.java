package com.dev.frontend.panels.edit;

import com.dev.frontend.services.Services;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;

public class EditProduct extends EditContentPanel
{
	private static final long serialVersionUID = -8971249970444644844L;
	private JTextField txtCode = new JTextField();
	private JTextField txtDescription = new JTextField();
	private JTextField txtQuantity = new JTextField();
	private JTextField txtPrice = new JTextField();

    private JSONObject product=new JSONObject();

	public EditProduct()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Code"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(txtCode, gbc);
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		txtCode.setColumns(10);
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Description"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtDescription, gbc);
		txtDescription.setColumns(28);
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Price"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtPrice, gbc);
		txtPrice.setColumns(10);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(new JLabel("Quantity"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 15);
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtQuantity, gbc);
		txtQuantity.setColumns(10);
	}

	public boolean bindToGUI(Object o) 
	{
		// TODO by the candidate
        System.out.println("*********bindToGUI PRODUCT"+o);
        product=(JSONObject)o;
        txtCode.setText(product.get("code").toString());
        txtDescription.setText(product.get("description").toString());
        txtPrice.setText(product.get("price").toString());
        txtQuantity.setText(product.get("quantity").toString());
		return false;
	}

	public Object guiToObject() 
	{
		// TODO by the candidate
        System.out.println("******* GUI TO OBJECT PRODUCT "+product);
        product.put("code",txtCode.getText());
        product.put("description",txtDescription.getText());
        product.put("price",txtPrice.getText());
        product.put("quantity",txtQuantity.getText());
		return product;
	}

	public int getObjectType()
	{
		return Services.TYPE_PRODUCT;
	}

	@Override
	public String getCurrentCode()
	{
		return txtCode.getText();
	}

	public void clear()
	{
		txtCode.setText("");
		txtDescription.setText("");
		txtPrice.setText("");
		txtQuantity.setText("");
        if(product!=null){
            product.clear();
        }

	}

	public void onInit()
	{
        /*TEST CLIENT
        System.out.println("***************************EDITPRODUCT!!!!!!!");
        JSONObject getResult=MyRestClient.getRequest("http://date.jsontest.com");
        System.out.println("RESULT: "+getResult.toString());

        System.out.println("POST!!!!!!!!!!!!!!!!!!!");
        JSONObject postResult=MyRestClient.postRequest("https://posttestserver.com/post.php","{\"Nombre\":\"Lagarto\"}");
        System.out.println("RESULT: "+postResult.toString());*/
    }
}
