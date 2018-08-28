package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
