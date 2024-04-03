package kr.co.farmstory.service;

import kr.co.farmstory.dto.ImgDTO;
import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.repository.ImgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ImgService {


    @Value("${img.upload.path}")
    private String imgUploadPath;

    public List<ImgDTO> imgUpload(ProductDTO productDTO) {

        // 파일 업로드 시스템 경로 구하기
        log.info(imgUploadPath);
        String path = new File(imgUploadPath).getAbsolutePath();

        // 파일 정보 리턴을 위한 리스트
        List<ImgDTO> imgs = new ArrayList<>();

        log.info("fileUpload...1");

        // 첨부한 파일 갯수만큼 반복 처리
        for (MultipartFile mf : productDTO.getImgs()) {
            log.info("fileUpload...2");

            //파일 첨부 안하면 에러나기 때문에 if문으로 isEmpty()로 첨부여부 먼저 확인
            if (!mf.isEmpty()) {

                log.info("fileUpload...3");
                String oName = mf.getOriginalFilename();

                log.info("fileUpload...4 : " + oName);

                 String ext = oName.substring(oName.lastIndexOf("."));
                String sName = UUID.randomUUID().toString() + ext;

                log.info("oName : " + oName);

                try {
                    // 저장
                    mf.transferTo(new File(path, sName));

                    // 파일 정보 생성
                    ImgDTO imgDTO = ImgDTO.builder()
                            .img1(sName)
                            .img2(sName)
                            .img3(sName)
                            .build();

                    // 리스트 저장
                    imgs.add(imgDTO);

                } catch (IOException e) {
                    log.error("fileUpload : " + e.getMessage());
                }
            }
        }

        // 저장한 파일 정보 리스트 반환
        return imgs;
    }
}
