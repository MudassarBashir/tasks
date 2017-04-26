package com.moe.tasklist.service;

import com.moe.tasklist.domain.Checklist;
import com.moe.tasklist.repository.ChecklistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public List<Checklist> getAll() {
        List<Checklist> checklists = new ArrayList<>();
        checklistRepository.findAll().forEach(checklists::add);
        return checklists;
    }
    
    public void createChecklist(Checklist checklist) {
        checklistRepository.save(checklist);
    }
}
