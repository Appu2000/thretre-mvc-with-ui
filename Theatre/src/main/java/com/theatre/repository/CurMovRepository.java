package com.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theatre.entity.CurMov;

public interface CurMovRepository extends JpaRepository<CurMov,Long> {

}
