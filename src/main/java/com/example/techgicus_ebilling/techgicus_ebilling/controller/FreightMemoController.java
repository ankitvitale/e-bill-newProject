package com.example.techgicus_ebilling.techgicus_ebilling.controller;


import com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity.FreightMemo;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.freightmemoDto.FreightMemoRequestDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.freightmemoDto.FreightMemoResponseDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.service.FreightMemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import java.util.List;

@RestController
@RequestMapping("/api/freight")
@PreAuthorize("hasAnyAuthority('ADMIN','SALEEMPLOYEE')")
public class FreightMemoController {
    @Autowired
    private FreightMemoService service;

    @PostMapping
    public FreightMemoResponseDTO create(@RequestBody FreightMemoRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public Page<FreightMemoResponseDTO> getAll(
            @PageableDefault(page = 0, size = 10) Pageable pageable) {

        return service.getAll(pageable);
    }
    @GetMapping("/{id}")
    public FreightMemoResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public FreightMemoResponseDTO update(@PathVariable Long id,
                                         @RequestBody FreightMemoRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}
