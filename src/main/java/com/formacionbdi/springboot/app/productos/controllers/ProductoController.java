package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoSevice;

@RestController
public class ProductoController {

    @Autowired
    private Environment env; //La clase envireonment permite acceder a las propiedades del archivo application.properties al usar feign en el servicio que lo invoca; sirve para mas abajo obtener el puerto

    @Value("${server.port}") //se invoca con RestTemplate en el otro servicio
    private Integer port;

    @Autowired
    private IProductoSevice productoService;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(producto -> {
          //  producto.setPort(Integer.parseInt(env.getProperty("local.server.port"))); //esta linea se usa con Feign
            producto.setPort(port); //con restTemplate
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
     //   producto.setPort(Integer.parseInt(env.getProperty("local.server.port"))); //esta linea se usa con Feign
        producto.setPort(port); //con restTemplate
        return producto;
    }

}
