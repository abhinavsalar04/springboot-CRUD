package com.springbootbootcamp.project.Services;

import com.springbootbootcamp.project.Models.Asset;
import com.springbootbootcamp.project.Models.User;
import com.springbootbootcamp.project.Repositories.AssetRepository;
import com.springbootbootcamp.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private UserRepository userRepository;

    public Asset addAsset(Asset asset){
        return assetRepository.save(asset);
    }

    public List<Asset> getAssets(){
        return assetRepository.findAll();
    }

    public Asset getAssetById(int asset_id){
        return assetRepository.findById(asset_id).get();
    }

    public String assignAssetToUser(int assetId, int userId){
        User user = userRepository.findById(userId).get();
        Asset asset = assetRepository.findById(assetId).get();

        user.setAsset(asset);
        userRepository.save(user);
        assetRepository.save(asset);
        return "Asset assigned successfully";
    }

    public String removeAsset(int assetId){
        try{
            List<User> users = userRepository.findAll();
            for(User user: users){
                if(user != null && user.getAsset().getId() == assetId){
                    user.setAsset(null);
                    userRepository.save(user);
                    break;
                }
            }
            assetRepository.deleteById(assetId);
            return "Asset removed!";
        } catch (Exception exp){
            System.out.println(exp.getMessage());
        }
        return "Unable to removed asset";
    }
}
