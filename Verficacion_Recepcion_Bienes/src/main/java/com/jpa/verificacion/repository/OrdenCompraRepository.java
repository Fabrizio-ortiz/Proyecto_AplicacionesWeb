package com.jpa.verificacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.verificacion.entity.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer>{

	@Query("Select e from OrdenCompra e where e.supervisor.codigo=?1")
	public List<OrdenCompra> listAllBySupervisor(int codOrd);
}
