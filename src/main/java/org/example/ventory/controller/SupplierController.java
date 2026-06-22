package org.example.ventory.controller;

import org.example.ventory.entity.Supplier;
import org.example.ventory.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getById(Long id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    public Supplier update(
        @PathVariable Long id,
        @RequestBody Supplier supplier) {

        return supplierService.updateSupplier(id, supplier);
    }

    public void delete(Long id) {
        supplierService.deleteSupplier(id);
    }

}
