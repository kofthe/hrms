package com.mehmetari.hrms.core.cloudinary;

import com.mehmetari.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {

    DataResult<Map<String, String>> upload(MultipartFile multipartFile);
    DataResult<Map> delete(String id) throws IOException;

}
