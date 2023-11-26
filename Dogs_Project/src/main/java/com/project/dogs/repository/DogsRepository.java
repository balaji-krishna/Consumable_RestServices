package com.project.dogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dogs.entity.Dogs;

public interface DogsRepository extends JpaRepository<Dogs, Long> {

}
