package org.example.ventory.controller;

import org.example.ventory.entity.Supplier;
import org.example.ventory.service.SupplierService;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("supplier")
>>>>>>> 0f19e7ebd1a9829a8d1800228ecbbcb868f255f4
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
<<<<<<< HEAD
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

=======
    public ResponseEntity<List<Supplier>> getAll() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("{id}")
    public ResponseEntity<Supplier> getById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping
    public ResponseEntity<Supplier> create(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupplier);
    }

    @PutMapping("{id}")
    public ResponseEntity<Supplier> update(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    public ResponseEntity<Void> delete(Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
>>>>>>> 0f19e7ebd1a9829a8d1800228ecbbcb868f255f4
}
