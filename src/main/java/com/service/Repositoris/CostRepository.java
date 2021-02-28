package com.service.Repositoris;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.service.Items.CostName;
import org.springframework.data.repository.query.Param;

public interface CostRepository extends CrudRepository<CostName, Integer> {

    CostName findFirstById(int id);

    @Query("SELECT c FROM CostName c WHERE c.checkName = :checkName")
        CostName find(@Param("checkName") String checkName);

}
