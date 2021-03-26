package dev.tuzserik.business.logic.of.software.systems.lab1.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;
import java.util.Collection;

@AllArgsConstructor @Data
public class CartStatusResponse {
    private UUID cartId;
    private Collection<UUID> items;
}
