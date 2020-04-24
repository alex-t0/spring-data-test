package dbench.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
public class Tender implements ApprovableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@OneToMany(mappedBy = "entityId")
	@Where(clause = "entitytype = 'tender'")
	private List<Approval> approvals;

	@Column(nullable = false)
	String name;

	@Column
	String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(List<Approval> approvals) {
		this.approvals = approvals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
