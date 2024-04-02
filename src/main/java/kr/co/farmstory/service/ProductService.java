package kr.co.farmstory.service;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.entity.Product;
import kr.co.farmstory.mapper.AdminMapper;
import kr.co.farmstory.mapper.UserMapper;
import kr.co.farmstory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j @Service @RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final AdminMapper adminMapper;

    private final ModelMapper modelMapper;

    public ResponseEntity<List<ProductDTO>> selectProducts(){

        log.info("selectProduct...1");
        List<Product> productList = productRepository.findAll();

        List<ProductDTO> productDTOS = productList.stream()
                .map(entity-> modelMapper.map(entity, ProductDTO.class))
                .toList();

        return ResponseEntity.ok().body(productDTOS);
    }

    public void insertProduct(ProductDTO productDTO){

        adminMapper.insertProduct(productDTO);

    }

}
