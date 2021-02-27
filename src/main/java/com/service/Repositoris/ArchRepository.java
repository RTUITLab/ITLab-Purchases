package com.service.Repositoris;

import com.service.Items.ArchiveDB;
import org.springframework.data.repository.CrudRepository;

public interface ArchRepository extends CrudRepository<ArchiveDB, Integer> {
}
