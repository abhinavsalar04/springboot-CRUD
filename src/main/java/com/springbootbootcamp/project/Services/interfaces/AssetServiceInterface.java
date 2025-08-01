package com.springbootbootcamp.project.Services.interfaces;
import com.springbootbootcamp.project.Models.Asset;
import java.util.List;

public interface AssetServiceInterface {
    public Asset addAsset(Asset asset);

    public List<Asset> getAssets();

    public Asset getAssetById(int assetId);

    public String assignAssetToUser(int assetId, int userId);

    public String removeAsset(int assetId);
}
