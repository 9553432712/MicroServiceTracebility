package com.mahesh.Service1.repository;

import com.mahesh.Service1.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {
}
