package com.haterspoint.service.impl;


import com.haterspoint.dto.Brand;
import com.haterspoint.entity.Product;
import com.haterspoint.entity.Reaction;
import com.haterspoint.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Override
    public List<Brand> getBrands() {

        List<Brand> brands = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            Brand brand = new Brand();

            brand.setId(i);
            brand.setName("brand" + i);
            brand.setNoOfAngry(i + 1);
            brand.setNoOfHate(i + 2);
            brand.setNoOFFrustrations(i + 5);

            brands.add(brand);

        }
        return brands;
    }


    private double getHateScore(Product product, Brand brand) {
        double correctionFactor = 2.5;
        int dislikePoint = 1;
        int hatePoint = 2;
        int angryPoint = 3;
        int frustrationPoint = 4;
        double totalHateScore = 0;


        for (Reaction reaction : product.getReactions()){

            setReactionsNumbers(reaction, brand);
            totalHateScore = (((brand.getNoOfDislikes() * dislikePoint)
                    +(brand.getNoOfHate()* hatePoint)
                    +(brand.getNoOfAngry() * angryPoint)
                    +(brand.getNoOFFrustrations() * frustrationPoint) )
                    /brand.getNoOfDislikes() + brand.getNoOfHate()
                    +brand.getNoOfAngry() + brand.getNoOFFrustrations()) * correctionFactor;

        }
        return totalHateScore;
    }
    private void setReactionsNumbers( Reaction reaction, Brand brand){

        switch( reaction.getReaction()){
            case("dislike"): brand.setNoOfDislikes(brand.getNoOfHate()+1);
                             break;
            case("hate"): brand.setNoOfHate(brand.getNoOfHate()+1);
                            break;
            case ("angry"): brand.setNoOfAngry(brand.getNoOfAngry()+1);
                            break;

            default: brand.setNoOFFrustrations(brand.getNoOFFrustrations() + 1);
        }


    }

}
