package com.haterspoint.service.impl;


import com.haterspoint.dto.BrandDTO;
import com.haterspoint.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
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
}
