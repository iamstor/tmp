package dev.tuzserik.business.logic.of.software.systems.lab1.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.UUID;
import java.util.Collection;
import java.util.HashSet;

@AllArgsConstructor @NoArgsConstructor @Data @Entity @Table(name = "TYPES")
public class Type {
    @Id @GeneratedValue
    private UUID id;
    @ManyToMany
    private Collection<Attribute> attributes = new HashSet<>();
}
