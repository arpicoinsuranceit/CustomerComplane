package org.arpicoinsurance.groupit.complaint.main.dao;

import org.arpicoinsurance.groupit.complaint.main.model.ComplaintModel;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintDao extends CrudRepository<ComplaintModel, Integer>{

}
