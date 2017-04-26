package com.moe.tasklist;

import com.moe.tasklist.domain.Checklist;
import com.moe.tasklist.domain.Item;
import com.moe.tasklist.repository.ChecklistRepository;
import com.moe.tasklist.service.ChecklistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

	// Bootstrap database. todo: move this into own bean's work.
	@Bean
	public CommandLineRunner demo(ChecklistService checklistService) {
		return (args) -> {
			// Trip checklist
			Item item0 = new Item();
			item0.setName("Take cell phone");
			Item item1 = new Item();
			item1.setName("Take map.");
			Checklist tripChecklist = new Checklist();
			tripChecklist.setName("Trip");
			tripChecklist.addItem(item0);
			tripChecklist.addItem(item1);

			// Night checklist
			Item item2 = new Item();
			item2.setName("Turn off lights.");
			Checklist nightChecklist = new Checklist();
			nightChecklist.setName("Night");
			nightChecklist.addItem(item2);

			checklistService.createChecklist(tripChecklist);
			checklistService.createChecklist(nightChecklist);
		};
	}
}
