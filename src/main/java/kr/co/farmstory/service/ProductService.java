package kr.co.farmstory.service;

import kr.co.farmstory.dto.ProductDTO;


import kr.co.farmstory.entity.Product;

import kr.co.farmstory.mapper.ProductMapper;
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
    private final ProductMapper productMapper;
    private final ModelMapper modelMapper;

    // 상품 전체 리스트 출력
    public List<ProductDTO> selectProducts() {
        return productMapper.selectProducts();
    }


    //등록상품 view 보기
    public ProductDTO findById(int pno){

        return productMapper.selectProduct(pno);
    }

    //상품 등록
    public Product insertProduct(ProductDTO productDTO) {

        Product product = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }



}
