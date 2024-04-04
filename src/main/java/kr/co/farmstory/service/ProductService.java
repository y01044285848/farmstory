package kr.co.farmstory.service;

import kr.co.farmstory.dto.ProductDTO;


import kr.co.farmstory.entity.Product;

import kr.co.farmstory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j @Service @RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    // 상품 전체 리스트 출력
    public List<ProductDTO> selectProducts() {

        log.info("selectProduct...1");
        List<Product> productList = productRepository.findAll();
        log.info("selectProduct...2");

        List<ProductDTO> productDTOS = productList.stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class))
                .toList();
        log.info("selectProduct...3" + productDTOS);

        return productDTOS;
    }


    //등록상품 view 보기
    public ProductDTO findById(Integer pno){

        Optional<Product> optProduct = productRepository.findById(pno);
        log.info("findById...1");

        ProductDTO productDTO = null;

        if(optProduct.isPresent()){
            log.info("findById...2");
            Product product = optProduct.get();

            log.info("findById...3 : " +product.toString());
            productDTO = modelMapper.map(product, ProductDTO.class);
            log.info("findById...4");

        }

        log.info("productDTO : " +productDTO.toString());

        return productDTO;
    }

    //상품 등록
    public Product insertProduct(ProductDTO productDTO) {

        Product product = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }



}
