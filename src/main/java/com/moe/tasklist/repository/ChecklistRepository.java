package com.moe.tasklist.repository;

import com.moe.tasklist.domain.Checklist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ChecklistRepository extends CrudRepository<Checklist, Long> {

    Checklist findByName(String name);

}