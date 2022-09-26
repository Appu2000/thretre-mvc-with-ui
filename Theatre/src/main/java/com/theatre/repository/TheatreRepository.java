package com.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theatre.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre,Long>{

}
