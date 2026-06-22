package org.example.ventory.service;

import org.example.ventory.entity.Supplier;
import org.example.ventory.exception.SupplierNotFoundException;
import org.example.ventory.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(
                    () -> new SupplierNotFoundException(
                        "Supplier with id " + id + " not found"
                    )
                );
    }

    public Supplier updateSupplier(Long id,Supplier updateSupplier) {
        Supplier existingSupplier = this.getSupplierById(id);

        existingSupplier.setName(updateSupplier.getName());
        existingSupplier.setEmail(updateSupplier.getEmail());
        existingSupplier.setPhone(updateSupplier.getPhone());

        return supplierRepository.save(existingSupplier);
    }
}
