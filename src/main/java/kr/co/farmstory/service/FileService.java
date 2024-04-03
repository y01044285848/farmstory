package kr.co.farmstory.service;

import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.dto.FileDTO;
import kr.co.farmstory.repository.FileRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j @Service @RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    @Value("uploads/")
    private String fileUploadPath;

    public List<FileDTO> fileUpload(ArticleDTO articleDTO){
        
        // 파일 업로드 경로
        String path = new File(fileUploadPath).getAbsolutePath();
        
        // 파일 정보 리턴 리스트
        List<FileDTO> files = new ArrayList<>();
        log.info("fileUpload...1");

        for(MultipartFile mf : articleDTO.getFiles()){
            log.info("fileUpload...2");

            if(!mf.isEmpty()){
                log.info("fileUpload...3");
                String oName = mf.getOriginalFilename();

                log.info("fileUpload...4 : "+ oName);

                // 확장자
                String ext = oName.substring(oName.lastIndexOf("."));
                String sName = UUID.randomUUID().toString() + ext;

                log.info("fileUpload...5 : " + sName);

                try {
                    mf.transferTo(new File(path, sName));

                    FileDTO fileDTO = FileDTO.builder()
                                            .oName(oName)
                                            .sName(sName).build();

                    files.add(fileDTO);

                }catch (IOException e){
                    log.error("fileUpload : " + e.getMessage());
                }
            }
        }

        return files;
    }
}
