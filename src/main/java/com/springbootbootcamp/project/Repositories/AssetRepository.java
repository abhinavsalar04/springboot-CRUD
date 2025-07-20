package com.springbootbootcamp.project.Repositories;

import com.springbootbootcamp.project.Models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

}
