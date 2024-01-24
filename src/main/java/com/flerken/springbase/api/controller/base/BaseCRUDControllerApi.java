package com.flerken.springbase.api.controller.base;


import com.flerken.springbase.api.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
public interface BaseCRUDControllerApi<D> {
    @GetMapping("/{id}")
    ResponseEntity<ResponseDto<D>> retrieve(@PathVariable Long id);

    @GetMapping
    ResponseEntity<ResponseDto<List<D>>> retrieveAll();

    @PostMapping
    ResponseEntity<ResponseDto<D>> create(@RequestBody D dto);

    @PostMapping("/edit/{id}")
    ResponseEntity<ResponseDto<D>> edit(@PathVariable Long id, @RequestBody D dto);

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseDto<D>> delete(@PathVariable Long id);
}