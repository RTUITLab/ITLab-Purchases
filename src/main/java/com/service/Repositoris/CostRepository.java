package com.service.Repositoris;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.service.Items.CostName;
import org.springframework.data.repository.query.Param;

public interface CostRepository extends CrudRepository<CostName, Integer> {

    @Query("SELECT c.id FROM CostName c WHERE c.checkName = :checkName")
        Integer findId(@Param("checkName") String checkName);

}
