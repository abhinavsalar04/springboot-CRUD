package com.springbootbootcamp.project.Mapper;

import com.springbootbootcamp.project.DTO.PaginationDTO;

import java.util.List;

public class PaginationMapper<T> {

    public PaginationDTO<T> getMappedData(List<T> entitles, int matchedRecords, int totalRecords){
        return new PaginationDTO<>(entitles, matchedRecords, totalRecords);
    }
}
