package com.emrekirman.glaceon.inventory.product.service;

import com.emrekirman.glaceon.inventory.product.entity.Product;

public interface IProductApi {

    Product getById(Integer id);
}
