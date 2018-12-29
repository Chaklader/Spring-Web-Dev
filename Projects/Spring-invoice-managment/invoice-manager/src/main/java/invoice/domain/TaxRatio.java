package invoice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TaxRatio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private int ratio;

	public TaxRatio() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ratio;
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
		TaxRatio other = (TaxRatio) obj;
		if (id != other.id)
			return false;
		if (ratio != other.ratio)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaxRatio [id=" + id + ", ratio=" + ratio + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}
