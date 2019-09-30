package org.arpicoinsurance.groupit.complaint.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_sequence")
public class SequenceEntity {
	
	private String pid;
    private String name;
    private Integer startValue;
    private Integer incrementValue;
    private Integer currentValue;
    
    @Id
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStartValue() {
		return startValue;
	}
	public void setStartValue(Integer startValue) {
		this.startValue = startValue;
	}
	public Integer getIncrementValue() {
		return incrementValue;
	}
	public void setIncrementValue(Integer incrementValue) {
		this.incrementValue = incrementValue;
	}
	public Integer getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(Integer currentValue) {
		this.currentValue = currentValue;
	}
    
    

}
