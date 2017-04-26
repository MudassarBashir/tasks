package com.moe.tasklist.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * A class representing a task checklist.
 *
 * @author  Mudassar "Moe" Bashir
  */
@Data
@Entity
@Table(name = "checklist")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    @NotNull
    private String name;

    /**
     * Items belonging to this checklist.
     */
    @OneToMany(mappedBy = "checklist", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();

    public void addItem(Item item) {
        item.setChecklist(this);
        getItems().add(item);
    }

    public void removeItem(Item item) {
        getItems().remove(item);
    }
}
