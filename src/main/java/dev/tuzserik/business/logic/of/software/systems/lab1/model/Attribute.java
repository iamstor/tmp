package dev.tuzserik.business.logic.of.software.systems.lab1.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.UUID;
import java.util.Collection;

@AllArgsConstructor @NoArgsConstructor @Data @Entity @Table(name = "ATTRIBUTES")
public class Attribute {
    @Id @GeneratedValue
    private UUID id;
    @ManyToMany(mappedBy = "attributes")
    private Collection<Type> types;
}
