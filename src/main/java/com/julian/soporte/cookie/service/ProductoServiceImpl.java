package com.julian.soporte.cookie.service;

import com.julian.soporte.cookie.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 175000),
                new Producto(2L, "mouse", "accesorios", 250000),
                new Producto(3L, "pantalla pc", "accesorios", 300000));
    }
}
