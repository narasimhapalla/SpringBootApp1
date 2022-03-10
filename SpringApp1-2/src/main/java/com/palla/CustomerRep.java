package com.palla;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface CustomerRep extends CrudRepository<Customers, Integer> {
public interface CustomerRep extends JpaRepository<Customers, Integer> {
}
