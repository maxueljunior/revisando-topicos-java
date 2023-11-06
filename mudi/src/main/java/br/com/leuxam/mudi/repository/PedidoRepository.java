package br.com.leuxam.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.leuxam.mudi.model.Pedido;
import br.com.leuxam.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	List<Pedido> findByStatus(StatusPedido status);
	
}
