package invoice.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;

	@Column(nullable = false)
	private int orderBy;

	@Column(nullable = false)
	private Date createdByDate;

	@ManyToOne
	@JoinColumn(nullable = false)
	private PhoneType phoneType;

	@ManyToOne
	@JoinColumn(unique = true)
	private Employee employee;

	@ManyToOne
	private Company company;

	public Phone() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((createdByDate == null) ? 0 : createdByDate.hashCode());
		result = prime * result
				+ ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + orderBy;
		result = prime * result
				+ ((phoneType == null) ? 0 : phoneType.hashCode());
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
		Phone other = (Phone) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (createdByDate == null) {
			if (other.createdByDate != null)
				return false;
		} else if (!createdByDate.equals(other.createdByDate))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (orderBy != other.orderBy)
			return false;
		if (phoneType == null) {
			if (other.phoneType != null)
				return false;
		} else if (!phoneType.equals(other.phoneType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + ", orderBy="
				+ orderBy + ", createdByDate=" + createdByDate + ", phoneType="
				+ phoneType + ", employee=" + employee + ", company=" + company
				+ "]";
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

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public Date getCreatedByDate() {
		return createdByDate;
	}

	public void setCreatedByDate(Date createdByDate) {
		this.createdByDate = createdByDate;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
