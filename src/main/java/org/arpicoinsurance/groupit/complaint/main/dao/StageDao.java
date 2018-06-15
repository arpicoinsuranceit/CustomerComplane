package org.arpicoinsurance.groupit.complaint.main.dao;

import org.arpicoinsurance.groupit.complaint.main.model.StageModel;
import org.springframework.data.repository.CrudRepository;

public interface StageDao extends CrudRepository<StageModel, Integer>{
	public StageModel findByStageName(String stageName)throws Exception;
}
