package com.mehmetari.hrms.business.abstracts;

import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.entity.Seeker;
import com.mehmetari.hrms.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {

    Result addPhoto(MultipartFile file, int id) throws IOException;
    Result deletePhoto(MultipartFile file, int id);
    void photoTableSetter(Seeker seeker);


}
