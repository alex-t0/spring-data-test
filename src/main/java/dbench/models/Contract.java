package dbench.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
public class Contract implements ApprovableEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
	
	@Column(nullable = false)
    String name;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name="curator")
    private User curator;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ReportData.class)
    @JoinColumn(name="zreport")
    private ReportData zreport;
	
	@Column
    private String status;
	
	@OneToMany(mappedBy = "entityId")
    @Where(clause = "entitytype = 'contract'")
    private List<Approval> approvals;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public User getCurator() {
		return curator;
	}

	public void setCurator(User curator) {
		this.curator = curator;
	}

	public ReportData getZreport() {
		return zreport;
	}

	public void setZreport(ReportData zreport) {
		this.zreport = zreport;
	}

	@Override
	public String getStatus() {
		return status;
	}
	
    public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(List<Approval> approvals) {
		this.approvals = approvals;
	}
}