package com.mehmetari.hrms.business.concretes;

import com.mehmetari.hrms.business.abstracts.PhotoService;
import com.mehmetari.hrms.business.abstracts.SeekerService;
import com.mehmetari.hrms.core.cloudinary.CloudinaryService;
import com.mehmetari.hrms.core.utilities.results.ErrorDataResult;
import com.mehmetari.hrms.core.utilities.results.ErrorResult;
import com.mehmetari.hrms.core.utilities.results.Result;
import com.mehmetari.hrms.core.utilities.results.SuccessResult;
import com.mehmetari.hrms.entity.Photo;
import com.mehmetari.hrms.entity.Seeker;
import com.mehmetari.hrms.entity.User;
import com.mehmetari.hrms.repository.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class PhotoManager implements PhotoService {

    private CloudinaryService cloudinaryService;
    private PhotoRepository photoRepository;
    private SeekerService seekerService;

    public PhotoManager(CloudinaryService cloudinaryService, PhotoRepository photoRepository, SeekerService seekerService) {
        this.cloudinaryService = cloudinaryService;
        this.photoRepository = photoRepository;
        this.seekerService = seekerService;
    }

    @Override
    public Result addPhoto(MultipartFile file, int id) throws IOException {

        var result = cloudinaryService.upload(file);
        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }
        var seeker = seekerService.findSeekerById(id);
        Photo photo = new Photo();
        photo.setSeeker(seeker);
        photo.setPhotoUrl(result.getData().get("url"));
        photoRepository.save(photo);
        return new SuccessResult("Fotoğraf başarıyla eklendi.");
    }

    @Override
    public Result deletePhoto(MultipartFile file, int id) {
        return null;
    }

    @Override
    public void photoTableSetter(Seeker seeker) {
        Photo photo = new Photo();
        photo.setSeeker(seeker);
        photoRepository.save(photo);
    }
}
