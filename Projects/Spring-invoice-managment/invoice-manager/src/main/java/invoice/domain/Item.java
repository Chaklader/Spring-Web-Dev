package invoice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String pkwiuCode;

	@Column(nullable = false)
	private int quantity;

	@Column
	private double discount;

	@Column(nullable = false)
	private double priceTaxFree;

	@ManyToOne
	@JoinColumn(nullable = false)
	private ItemUnitOfMass itemUnitOfMass;

	@ManyToOne
	@JoinColumn(nullable = false)
	private TaxRatio taxRatio;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Invoice invoice;

	public Item() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		result = prime * result
				+ ((itemUnitOfMass == null) ? 0 : itemUnitOfMass.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((pkwiuCode == null) ? 0 : pkwiuCode.hashCode());
		temp = Double.doubleToLongBits(priceTaxFree);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result
				+ ((taxRatio == null) ? 0 : taxRatio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (Double.doubleToLongBits(discount) != Double
				.doubleToLongBits(other.discount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		if (itemUnitOfMass == null) {
			if (other.itemUnitOfMass != null)
				return false;
		} else if (!itemUnitOfMass.equals(other.itemUnitOfMass))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pkwiuCode == null) {
			if (other.pkwiuCode != null)
				return false;
		} else if (!pkwiuCode.equals(other.pkwiuCode))
			return false;
		if (Double.doubleToLongBits(priceTaxFree) != Double
				.doubleToLongBits(other.priceTaxFree))
			return false;
		if (quantity != other.quantity)
			return false;
		if (taxRatio == null) {
			if (other.taxRatio != null)
				return false;
		} else if (!taxRatio.equals(other.taxRatio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", pkwiuCode=" + pkwiuCode
				+ ", quantity=" + quantity + ", discount=" + discount
				+ ", priceTaxFree=" + priceTaxFree + ", itemUnitOfMass="
				+ itemUnitOfMass + ", taxRatio=" + taxRatio + ", invoice="
				+ invoice + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPkwiuCode() {
		return pkwiuCode;
	}

	public void setPkwiuCode(String pkwiuCode) {
		this.pkwiuCode = pkwiuCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPriceTaxFree() {
		return priceTaxFree;
	}

	public void setPriceTaxFree(double priceTaxFree) {
		this.priceTaxFree = priceTaxFree;
	}

	public ItemUnitOfMass getItemUnitOfMass() {
		return itemUnitOfMass;
	}

	public void setItemUnitOfMass(ItemUnitOfMass itemUnitOfMass) {
		this.itemUnitOfMass = itemUnitOfMass;
	}

	public TaxRatio getTaxRatio() {
		return taxRatio;
	}

	public void setTaxRatio(TaxRatio taxRatio) {
		this.taxRatio = taxRatio;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
