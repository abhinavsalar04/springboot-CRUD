package com.springbootbootcamp.project.Controllers;

import com.springbootbootcamp.project.Models.Asset;
import com.springbootbootcamp.project.Services.implementation.AssetServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/asset")
public class AssetController {
    @Autowired
    private AssetServiceImplementation assetService;

    @PostMapping
    public Asset addAsset(@RequestBody Asset asset){
        System.out.println(asset.getName() + " - " + asset.getType());
        return assetService.addAsset(asset);
    }

    @GetMapping("/assets")
    public List<Asset> getAssets(){
        return assetService.getAssets();
    }

    @GetMapping("{assetId}")
    public Asset getAssetById(@PathVariable int assetId){
        return assetService.getAssetById(assetId);
    }

    @PutMapping("/assign/{assetId}/user/{userId}")
    public String assignAssetToUser(@PathVariable int assetId, @PathVariable int userId){
        return assetService.assignAssetToUser(assetId, userId);
    }

    @DeleteMapping("{assetId}")
    public String removeAsset(@PathVariable int assetId){
        return assetService.removeAsset(assetId);
    }
}
