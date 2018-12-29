package invoice.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String number;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(nullable = false)
	private String createdCity;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date soldDate;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date paymentExpirationDate;

	@ManyToOne
	@JoinColumn(nullable = false)
	private PaymentType paymentType;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Company company;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Customer customer;

	@Column(nullable = false)
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	private List<Item> items;

	public Invoice() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((createdCity == null) ? 0 : createdCity.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime
				* result
				+ ((paymentExpirationDate == null) ? 0 : paymentExpirationDate
						.hashCode());
		result = prime * result
				+ ((paymentType == null) ? 0 : paymentType.hashCode());
		result = prime * result
				+ ((soldDate == null) ? 0 : soldDate.hashCode());
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
		Invoice other = (Invoice) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (createdCity == null) {
			if (other.createdCity != null)
				return false;
		} else if (!createdCity.equals(other.createdCity))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (paymentExpirationDate == null) {
			if (other.paymentExpirationDate != null)
				return false;
		} else if (!paymentExpirationDate.equals(other.paymentExpirationDate))
			return false;
		if (paymentType == null) {
			if (other.paymentType != null)
				return false;
		} else if (!paymentType.equals(other.paymentType))
			return false;
		if (soldDate == null) {
			if (other.soldDate != null)
				return false;
		} else if (!soldDate.equals(other.soldDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", number=" + number + ", createdDate="
				+ createdDate + ", createdCity=" + createdCity + ", soldDate="
				+ soldDate + ", paymentExpirationDate=" + paymentExpirationDate
				+ ", paymentType=" + paymentType + ", company=" + company
				+ ", customer=" + customer + ", items=" + items + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedCity() {
		return createdCity;
	}

	public void setCreatedCity(String createdCity) {
		this.createdCity = createdCity;
	}

	public Date getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}

	public Date getPaymentExpirationDate() {
		return paymentExpirationDate;
	}

	public void setPaymentExpirationDate(Date paymentExpirationDate) {
		this.paymentExpirationDate = paymentExpirationDate;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
