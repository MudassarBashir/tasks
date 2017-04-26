package com.moe.tasklist.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * A class representing an item that would be on a checklist.
 *
 * @author  Mudassar "Moe" Bashir
 */
@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    @NotNull
    private String name;

    @NotNull
    private boolean applicable = false;

    @NotNull
    private boolean onboard = false;
}
