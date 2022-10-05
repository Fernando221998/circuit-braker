package service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.Precio;
import dto.Producto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServicioProductoRemote implements ServicioProductoI{

	private RestTemplate restTemplate;

	@Override
	@CircuitBreaker(name ="producto", fallbackMethod = "fallBack")
	public Producto porGetProducto(Integer id) {
		if(id != null) {
			Producto producto = new Producto();
			Precio response = this.restTemplate.getForObject("http://localhost:8080/porGetProducto/" + null, Precio.class, id);
			producto.setId(response.getId());
			producto.setChannel(response.getDescription());
			producto.setPort(response.getCode_product());
			return producto;
		}else {
			return null;	
		}
	}

	@Override
	@CircuitBreaker(name ="producto", fallbackMethod = "fallBack")
	public Producto porPostProduct(Integer id) {
		if(id != null) {
			Producto producto = new Producto();
			Precio response = this.restTemplate.postForObject("http://localhost:8080/porPostProduct/" + id, null, Precio.class, id);
			producto.setId(response.getId());
			producto.setChannel(response.getDescription());
			producto.setPort(response.getCode_product());
			return producto;
		}else {
			return null;	
		}
	}
	
	public Producto fallBack(String id, Throwable a) {
		Producto producto = new Producto();
		producto.setId(null);
		producto.setChannel("vacio");
		producto.setPort("vacio");
		return producto;
	}

}
