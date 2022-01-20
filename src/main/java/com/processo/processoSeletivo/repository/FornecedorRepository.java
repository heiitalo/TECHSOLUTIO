package com.processo.processoSeletivo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.processo.processoSeletivo.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	public List<Fornecedor> findAllByFornecedorContainingIgnoreCase(String fornecedor);
}
