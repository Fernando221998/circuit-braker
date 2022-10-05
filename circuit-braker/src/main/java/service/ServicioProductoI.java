package service;

import dto.Producto;

public interface ServicioProductoI {
	
	public Producto porGetProducto(Integer id);
	
	public Producto porPostProduct(Integer id);

}
