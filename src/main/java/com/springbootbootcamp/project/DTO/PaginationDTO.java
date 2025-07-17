package com.springbootbootcamp.project.DTO;

import java.util.List;

public class PaginationDTO<T> {

    List<T> entities;

    int matchedRecords;
    int totalRecords;

    public PaginationDTO(){}

    public PaginationDTO(List<T> entities, int matchedRecords, int totalRecords){
        this.entities = entities;
        this.matchedRecords = matchedRecords;
        this.totalRecords = totalRecords;
    }

    public List<T> getEntities(){
        return this.entities;
    }

    public int getMatchedRecords(){
        return this.matchedRecords;
    }

    public int getTotalRecords(){
        return this.totalRecords;
    }

    public void setEntities(List<T> entities){
        this.entities = entities;
    }

    public void setMatchedRecords(int matchedRecords){
        this.matchedRecords = matchedRecords;
    }

    public void setTotalRecords(int totalRecords){
        this.totalRecords = totalRecords;
    }
}
