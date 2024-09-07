package com.msk.db_sequencer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sequence_generator")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SequenceGenerator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "current_value", nullable = false)
    private Long currentValue;
}
