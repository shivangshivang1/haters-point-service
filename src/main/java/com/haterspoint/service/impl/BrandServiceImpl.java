package com.haterspoint.service.impl;

import com.haterspoint.dto.BrandDTO;
import com.haterspoint.entity.Brand;
import com.haterspoint.enums.ReactionEnum;
import com.haterspoint.repository.ReactionRepository;
import com.haterspoint.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    ReactionRepository reactionRepository;
    @Override
    public List<BrandDTO> getBrands() {

        List<BrandDTO> brands = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            BrandDTO brand = new BrandDTO();

            brand.setId(i);
            brand.setName("brand" + i);
            brand.setNoOfAngry(i + 1);
            brand.setNoOFFrustrations(i + 5);

            brands.add(brand);

        }
        return brands;
    }

    private double getHateScore(Brand brand) {

        DecimalFormat dec = new DecimalFormat("#0.00");
        double correctionFactor = 2.5;

        int noOfDislikes = reactionRepository.findByReactionAndBrand(ReactionEnum.DISLIKE.toString(), brand.getId()).size();
        int noOfHate = reactionRepository.findByReactionAndBrand(ReactionEnum.HATE.toString(), brand.getId()).size();
        int noOfAngry = reactionRepository.findByReactionAndBrand(ReactionEnum.ANGRY.toString(), brand.getId()).size();
        int noOfFrustrations = reactionRepository.findByReactionAndBrand(ReactionEnum.FRUSTRATION.toString(), brand.getId()).size();

        double HateScore = (((noOfDislikes * 1)
                +(noOfHate * 2)
                +(noOfAngry * 3)
                +(noOfFrustrations * 4) )
                /noOfDislikes + noOfHate + noOfAngry + noOfFrustrations)
                * correctionFactor;

        return Double.parseDouble(dec.format(HateScore));
    }

}
