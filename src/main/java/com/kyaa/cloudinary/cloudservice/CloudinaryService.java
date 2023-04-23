package com.kyaa.cloudinary.cloudservice;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.kyaa.cloudinary.data.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
public class CloudinaryService {

    public String uploadImage(MultipartFile image) throws IOException {
        Map<String, Object> config = new HashMap();
        config.put("cloud_name", "diy0nupq2");
        config.put("api_key", "921181982415648");
        config.put("api_secret", "_lZxqJWNBSfV9QP4gXBB02ZaFSM");
        Cloudinary cloudinary = new Cloudinary(config);

        Transformation transformation = new Transformation<>();
        transformation.width(150)
                .height(150)
                .crop("fill")
                .gravity("face")
                .radius("max");

        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("public_id", "user_"+user.getId());
        parameters.put("folder", "user_images");
        parameters.put("transformation",transformation);

        Map uploadResult = cloudinary.uploader().upload(image.getBytes(), parameters);

        return (String) uploadResult.get("url");

    }
}
