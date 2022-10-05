package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import dto.Producto;

@Service
public class ServicioProductoImpl implements ServicioProductoI {

	@Autowired
	Environment environment;
	
	@Value("${server.port}")
	private String port;
	
	@Value("${product.product-name}")
	private String productName;
	
	@GetMapping(path="/product-name")
	public String productName() {
		return this.productName;
	}

	
	@Override
	public Producto porGetProducto(Integer id) {
		Producto producto = new Producto();
		producto.setId(id);
		producto.setChannel("GET");
		producto.setPort(environment.getProperty("local.server.port"));
		producto.setNombreProducto(productName);
		return producto;
	}

	@Override
	public Producto porPostProduct(Integer id) {
		Producto producto = new Producto();
		producto.setId(id);
		producto.setChannel("GET");
		producto.setPort(environment.getProperty("local.server.port"));
		producto.setNombreProducto(productName);
		return producto;
	}

}
