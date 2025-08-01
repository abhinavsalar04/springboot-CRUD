package com.springbootbootcamp.project.Services.implementation;

import com.springbootbootcamp.project.Models.Asset;
import com.springbootbootcamp.project.Models.User;
import com.springbootbootcamp.project.Repositories.AssetRepository;
import com.springbootbootcamp.project.Repositories.UserRepository;
import com.springbootbootcamp.project.Services.interfaces.AssetServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImplementation implements AssetServiceInterface {
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

    public Asset getAssetById(int assetId){
        return assetRepository.findById(assetId).get();
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
