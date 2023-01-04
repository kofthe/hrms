package com.mehmetari.hrms.core.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mehmetari.hrms.core.utilities.results.DataResult;
import com.mehmetari.hrms.core.utilities.results.ErrorDataResult;
import com.mehmetari.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CloudinaryManager implements CloudinaryService {

    private Cloudinary cloudinary;


    public CloudinaryManager() {
        Map<String, String> valuesMap = new HashMap<>();

        valuesMap.put("cloud_name", "dk141mwje");
        valuesMap.put("api_key", "992622136187696");
        valuesMap.put("api_secret", "IF4QZsLTzHotYrdrG0mIIOKVUJo");
        cloudinary = new Cloudinary(valuesMap);

    }

//    @Override
//    public DataResult<?> save(MultipartFile file) throws IOException {
//        try{
//            Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
//            return new SuccessDataResult<Map>(cloudinaryUploader);
//        }catch (IOException e){
//            System.out.println(e);
//        }
//        return new ErrorDataResult<Map>("Resim Yüklerken Hata Meydana Geldi.");
//    }

    public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
        File file;
        try {
            file = convert(multipartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<>(result);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>("Dosya yuklenmedi.");
        }
    }

    @Override
    public DataResult<Map> delete(String id) throws IOException {
        Map<String, Boolean> options = new HashMap<>();
        options.put("invalidate", true);
        Map result = cloudinary.uploader().destroy(id, options);
        return new SuccessDataResult<>(result);
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;

    }
}
