package com.example.crudwithgoodfrontend.repository;

import com.example.crudwithgoodfrontend.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Example, Long> {
}
