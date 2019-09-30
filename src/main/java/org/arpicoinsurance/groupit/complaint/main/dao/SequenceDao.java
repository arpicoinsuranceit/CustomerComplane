package org.arpicoinsurance.groupit.complaint.main.dao;

import org.arpicoinsurance.groupit.complaint.main.model.SequenceEntity;
import org.springframework.data.repository.CrudRepository;

public interface SequenceDao  extends CrudRepository<SequenceEntity, String>{
	
	public SequenceEntity  findFirstByNameOrderByCurrentValueDesc(String name)throws Exception;

}
