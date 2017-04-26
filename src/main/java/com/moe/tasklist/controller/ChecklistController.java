package com.moe.tasklist.controller;

import com.moe.tasklist.domain.Checklist;
import com.moe.tasklist.service.ChecklistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/checklists")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Checklist> getAllCustomers() {
        return checklistService.getAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody
    Checklist createChecklist(@RequestBody Checklist checklist) {
        log.debug("Converting JSON values to Checklist object: " + checklist.toString());
        checklistService.createChecklist(checklist);
        return checklist;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateChecklist( @PathVariable("id") String id, @RequestBody Checklist checklist) throws Exception {
        checklistService.updateChecklist(Long.parseLong(id), checklist);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteChecklist(@PathVariable("id") Long id) {
        checklistService.deleteChecklist(id);
    }

}
