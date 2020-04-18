package com.haterspoint.service.impl;


import com.haterspoint.dto.Brand;
import com.haterspoint.service.BrandService;
import org.springframework.stereotype.Service;

        import java.util.ArrayList;
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
                       brand.setNoOFFrustrations(i + 5);

                              brands.add(brand);

                           }
                        return brands;
            }
}

