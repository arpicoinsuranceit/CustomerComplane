package org.arpicoinsurance.groupit.complaint.main.dao;

import org.arpicoinsurance.groupit.complaint.main.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<CustomerModel, Integer>{

}
