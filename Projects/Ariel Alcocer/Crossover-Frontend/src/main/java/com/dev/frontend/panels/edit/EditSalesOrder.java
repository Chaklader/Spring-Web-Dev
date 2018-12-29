package com.dev.frontend.panels.edit;

import com.dev.frontend.panels.ComboBoxItem;
import com.dev.frontend.services.Services;
import com.dev.frontend.services.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class EditSalesOrder extends EditContentPanel
{
	private static final long serialVersionUID = -8971249970444644844L;
	private JTextField txtOrderNum = new JTextField();
	private JTextField txtTotalPrice = new JTextField();
	private JComboBox<ComboBoxItem> txtCustomer = new JComboBox<ComboBoxItem>();
	private JTextField txtQuantity = new JTextField();
	private JButton btnAddLine = new JButton("Add");
	private JComboBox<ComboBoxItem> txtProduct = new JComboBox<ComboBoxItem>();
	private DefaultTableModel defaultTableModel = new DefaultTableModel(new String[] { "Product", "Qty", "Price", "Total" }, 0)
	{

		private static final long serialVersionUID = 7058518092777538239L;

		@Override
		public boolean isCellEditable(int row, int column)
		{
			return false;
		}
	};
	private JTable lines = new JTable(defaultTableModel);
    private JSONObject salesOrder=new JSONObject();
    private JSONArray orderLines=new JSONArray();

	public EditSalesOrder()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Order Number"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.weightx = 0.5;
		add(txtOrderNum, gbc);

		txtOrderNum.setColumns(10);
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 3;
		gbc.gridy = 0;
		add(new JLabel("Customer"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		txtCustomer.setSelectedItem("Select a Customer");
		add(txtCustomer, gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Total Price"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.weightx = 0.5;
		add(txtTotalPrice, gbc);
		txtTotalPrice.setColumns(10);
		txtTotalPrice.setEditable(false);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(new JLabel("Details"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 6;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(10, 1));
		gbc.fill = GridBagConstraints.BOTH;
		add(separator, gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(new JLabel("Product"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		txtProduct.setSelectedItem("Select a Product");
		add(txtProduct, gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 3;
		gbc.gridy = 3;
		add(new JLabel("Quantity"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		add(txtQuantity, gbc);
		txtQuantity.setColumns(10);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 5, 2, 5);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(btnAddLine, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 7;
		gbc.gridheight = 8;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.ipady = 40;
		gbc.fill = GridBagConstraints.BOTH;
		JScrollPane scrollPane = new JScrollPane(lines, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		lines.setFillsViewportHeight(true);
		add(scrollPane, gbc);
		btnAddLine.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addRow();
			}
		});

	}

	public void addRow()
	{
		ComboBoxItem comboBoxItem = (ComboBoxItem) txtProduct.getSelectedItem();
		if (comboBoxItem == null)
		{
			JOptionPane.showMessageDialog(this, "You must select a product");
			return;

		}
		String productCode = comboBoxItem.getKey();
		double price = Services.getProductPrice(productCode);
		Integer qty = 0;
		try
		{
			qty = Integer.parseInt(txtQuantity.getText());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Invalid number format in Qty field");
			return;
		}
		double totalPrice = qty * price;
		defaultTableModel.addRow(new String[] { productCode, "" + qty, "" + price, "" + totalPrice });
		double currentValue = Utils.parseDouble(txtTotalPrice.getText());
		currentValue += totalPrice;
		txtTotalPrice.setText("" + currentValue);

        JSONObject orderLine=new JSONObject();
        orderLine.put("product",productCode);
        orderLine.put("quantity",qty);
        orderLine.put("price",price);
        orderLine.put("total",totalPrice);

        orderLines.add(orderLine);
	}
	
	public boolean bindToGUI(Object o) {
		// TODO by the candidate
        System.out.println("*********bindToGUI SALESORDER" + o);
        salesOrder=(JSONObject)o;
        txtOrderNum.setText(salesOrder.get("orderNumber").toString());
        txtTotalPrice.setText(salesOrder.get("totalPrice").toString());
		Map customerMap = (Map)salesOrder.get("customer");
        txtCustomer.setSelectedItem(customerMap.get("code"));
        orderLines= (JSONArray) salesOrder.get("orderLines");

        for (Object orderLineObject : orderLines) {
            JSONObject orderLine= (JSONObject) orderLineObject;
			Map productMap = (Map)orderLine.get("product");
            defaultTableModel.addRow(new String[] {
					productMap.get("code").toString(),
                    orderLine.get("quantity").toString(),
                    orderLine.get("unitPrice").toString(),
                    orderLine.get("totalPrice").toString() });
        }

        return false;
	}

	public Object guiToObject() {
		// TODO by the candidate
        System.out.println("******* GUI TO OBJECT SALESORDER "+salesOrder);
        salesOrder.put("orderNumber", txtOrderNum.getText());
        salesOrder.put("totalPrice", new Double(txtTotalPrice.getText()));
        ComboBoxItem selectedItem= (ComboBoxItem) txtCustomer.getSelectedItem();
        salesOrder.put("customer",selectedItem.getKey());
        salesOrder.put("orderLines",orderLines);

        return salesOrder;
	}

	public int getObjectType()
	{
		return Services.TYPE_SALESORDER;
	}

	public String getCurrentCode()
	{
		return txtOrderNum.getText();
	}

	public void clear()
	{
		txtOrderNum.setText("");
		txtCustomer.removeAllItems();
		txtProduct.removeAllItems();
		txtQuantity.setText("");
		txtTotalPrice.setText("");
		defaultTableModel.setRowCount(0);
		salesOrder.clear();
		orderLines.clear();
	}

	public void onInit()
	{
		List<ComboBoxItem> customers = Services.listCurrentRecordRefernces(Services.TYPE_CUSTOMER);
		for (ComboBoxItem item : customers)
			txtCustomer.addItem(item);

		List<ComboBoxItem> products = Services.listCurrentRecordRefernces(Services.TYPE_PRODUCT);
		for (ComboBoxItem item : products)
			txtProduct.addItem(item);
	}
}
