package io.github.manoelpiovesan.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "cbo")
public class Cbo extends PanacheEntity {

    @Column(name = "code")
    public String code;
    @Column(name = "description")
    public String description;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        if (id != null) {
            map.put("id", id);
        }

        map.put("code", code);
        map.put("description", description);
        return map;
    }

}
