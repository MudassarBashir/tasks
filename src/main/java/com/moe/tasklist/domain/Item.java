package com.moe.tasklist.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * A class representing an item that would be on a check list.
 *
 * @author  Mudassar "Moe" Bashir
 */
@Data
/*
The next two annotations avoid a stack overflow error which is caused by Lombok's @Data annotation. This is caused
by toString and hashCode methods from both classes calling each other recursively.
*/
@ToString(exclude = "checklist")
@EqualsAndHashCode(exclude = "checklist")
@RequiredArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    private boolean applicable = false;

    private boolean onboard = false;

    /**
     * The checklist that owns this item, or that this item belongs to.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CHECKLIST_ID")
    private Checklist checklist;

}
