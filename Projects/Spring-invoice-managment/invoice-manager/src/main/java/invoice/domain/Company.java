package invoice.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String nip;

	@Column(nullable = false)
	private String name;

	@Column
	private String email;

	@Column(nullable = false)
	@OneToMany(mappedBy = "company")
	private List<Employee> employees;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Bank> banks;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	@Column(nullable = false)
	private List<Adress> adresses;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Phone> phones;

	@OneToMany(mappedBy = "company")
	private List<Invoice> invoices;

	public Company() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adresses == null) ? 0 : adresses.hashCode());
		result = prime * result + ((banks == null) ? 0 : banks.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((invoices == null) ? 0 : invoices.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nip == null) ? 0 : nip.hashCode());
		result = prime * result + ((phones == null) ? 0 : phones.hashCode());
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
		Company other = (Company) obj;
		if (adresses == null) {
			if (other.adresses != null)
				return false;
		} else if (!adresses.equals(other.adresses))
			return false;
		if (banks == null) {
			if (other.banks != null)
				return false;
		} else if (!banks.equals(other.banks))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoices == null) {
			if (other.invoices != null)
				return false;
		} else if (!invoices.equals(other.invoices))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nip == null) {
			if (other.nip != null)
				return false;
		} else if (!nip.equals(other.nip))
			return false;
		if (phones == null) {
			if (other.phones != null)
				return false;
		} else if (!phones.equals(other.phones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", nip=" + nip + ", name=" + name
				+ ", email=" + email + ", employees=" + employees + ", banks="
				+ banks + ", adresses=" + adresses + ", phones=" + phones
				+ ", invoices=" + invoices + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
