package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
