package com.gg.mlg.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

@Component
public class MyFileUtils {

    @Value("${spring.servlet.multipart.location}")
    private String uploadImagePath; //"D:/springImg"

    //폴더 만들기
    public void makeFolders(String path) {
        File folder = new File(path);
        folder.mkdirs();
    }
    public boolean isFolders(String path) {
        File folder = new File(path);
        return folder.exists();
    }
    public void delFolders(String path) {
        File folder = new File(path);
        File[] deleteFolderList = folder.listFiles();
        for (int j = 0; j < deleteFolderList.length; j++ ) {
            deleteFolderList[j].delete();
        }
        folder.delete();
    }

    //저장 경로 만들기
    public String getSavePath(String path) {
        return uploadImagePath + "/" + path;
    }

    //랜덤 파일명 만들기
    public String getRandomFileNm() {
        return UUID.randomUUID().toString();
    }

    //랜덤 파일명 만들기 (with 확장자)
    public String getRandomFileNm(String originFileNm) {
        return getRandomFileNm() + "." + getExt(originFileNm);
    }
    //랜덤 파일명 만들기
    public String getRandomFileNm(MultipartFile file) {
        return getRandomFileNm(file.getOriginalFilename());
    }
    //확장자 얻기
    public String getExt(String fileNm) {
        return fileNm.substring(fileNm.lastIndexOf(".") + 1);
    }
    //파일 저장 & 랜덤파일명 리턴
    public String transferTo(MultipartFile mf, String target) {
        String fileNm = getRandomFileNm(mf);
        if(fileNm.lastIndexOf(".")==(fileNm.length()-1)){
            return null;
        }
        String basePath = getSavePath(target); //이미지를 저장할 절대경로값을 만든다. "D:/springImg/profile/10"
        makeFolders(basePath); //(폴더가 없을 수 있기 때문에)폴더를 만들어준다.
        File saveFile = new File(basePath, fileNm);
        try {
            mf.transferTo(saveFile);
            return fileNm;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
