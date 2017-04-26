package com.moe.tasklist.service;

import com.moe.tasklist.domain.Checklist;
import com.moe.tasklist.domain.Item;
import com.moe.tasklist.repository.ChecklistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        linkItemsToChecklist(checklist);
        checklistRepository.save(checklist);
    }

    public void updateChecklist(Long id, Checklist checklist) throws Exception {
        Optional<Checklist> possibleChecklist = Optional.ofNullable(checklistRepository.findOne(id));
        if (!possibleChecklist.isPresent()) {
            log.error("Checklist sought for update not found.");
            throw new Exception("No such checklist to update.");
        }
        Checklist checkListToUpdate = possibleChecklist.get();
        checkListToUpdate = checklist;
        linkItemsToChecklist(checkListToUpdate);
        checklistRepository.save(checkListToUpdate);
    }

    public void deleteChecklist(Long id) {
        checklistRepository.delete(id);
    }

    /**
     * This function links a give checklist with its items. It seems necessary because otherwise items
     * don't have their foreign key set to be their owning checklist. This only seems to be a problem when
     * items are coming in via a nested JSON structure such as when testing with Postman.
     * @param checklist the Checklist to which the items should be linked.
     */
    private void linkItemsToChecklist(Checklist checklist) {
        for (Item item : checklist.getItems()) {
            checklist.addItem(item);
        }
    }
}
