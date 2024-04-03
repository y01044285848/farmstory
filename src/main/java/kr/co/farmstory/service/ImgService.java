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

    public List<ImgDTO> imgUpload(ImgDTO imgDTO) {

        // 파일 업로드 시스템 경로 구하기
        log.info(imgUploadPath);

        MultipartFile mf = imgDTO.getImg1();

        String path = new File(imgUploadPath).getAbsolutePath();
        String oName = mf.getOriginalFilename();
        String ext = oName.substring(oName.lastIndexOf("."));

        String sName = UUID.randomUUID().toString() + ext;

        try {
            mf.transferTo(new File(path, sName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 저장한 파일 정보 리스트 반환
        return null;
    }
}
