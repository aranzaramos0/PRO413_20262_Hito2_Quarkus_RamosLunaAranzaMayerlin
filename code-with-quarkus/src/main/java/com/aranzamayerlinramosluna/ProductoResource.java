package com.aranzamayerlinramosluna;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.jboss.logging.Logger;

@Path("/api/productos")
public class ProductoResource {

    private static final Logger LOG = Logger.getLogger(ProductoResource.class);
    private static final List<Producto> productos = new ArrayList<>();
    private static final AtomicLong contador = new AtomicLong(1);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listar() {
        LOG.info("GET /api/productos - devolviendo " + productos.size() + " productos");
        return productos;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Producto crear(Producto producto) {
        producto.id = contador.getAndIncrement();
        productos.add(producto);
        LOG.info("POST /api/productos - producto creado: " + producto.nombre);
        return producto;
    }
}