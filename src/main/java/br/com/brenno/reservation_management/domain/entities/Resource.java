package br.com.brenno.reservation_management.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resources")

public class Resource {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String name;

  @Column
  private String description;

  @Column(nullable = false)
  private Integer capacity;

  public Resource() {
  }

  public Resource(String name, String description, int capacity) {
    this.name = name;
    this.description = description;
    this.capacity = capacity;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void updateInfo(String name, String description, Integer capacity) {
    this.name = name;
    this.description = description;
    this.capacity = capacity;
  }
}
