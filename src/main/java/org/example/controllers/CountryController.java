package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.data.dto.country.CountryCreateDTO;
import org.example.data.dto.country.CountryItemDTO;
import org.example.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Tag(name = "Categories", description = "Категорії товарів")
public class CountryController {

    private final CountryService countryService;

    @Operation(summary = "Створити нову категорію")
    @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CountryItemDTO> create(@RequestBody CountryCreateDTO dto) {
        return ResponseEntity.ok(countryService.create(dto));
    }

    @Operation(summary = "Отримати список всіх категорій")
    @GetMapping
    public ResponseEntity<List<CountryItemDTO>> getAll() {
        return ResponseEntity.ok(countryService.getAll());
    }

    @Operation(summary = "Отримати категорію за slug")
    @GetMapping("/{slug}")
    public ResponseEntity<CountryItemDTO> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(countryService.getBySlug(slug));
    }
}
