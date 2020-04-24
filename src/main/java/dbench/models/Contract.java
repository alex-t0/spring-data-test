package dbench.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contract {
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
}