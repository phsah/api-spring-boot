package org.example.data.mappers;

import org.example.data.dto.country.CountryCreateDTO;
import org.example.data.dto.country.CountryItemDTO;
import org.example.entities.location.CountryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryItemDTO toDto(CountryEntity country);

    CountryEntity fromCreateDTO(CountryCreateDTO dto);
}
