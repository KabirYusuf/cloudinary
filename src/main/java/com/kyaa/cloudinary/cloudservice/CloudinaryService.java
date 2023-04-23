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
    private final String cloudName = System.getenv("CLOUD_NAME");
    private final String cloudApiKey = System.getenv("CLOUD_API_KEY");
    private final String cloudApiSecret = System.getenv("CLOUD_API_SECRET");

    public String uploadImage(MultipartFile image) throws IOException {
        Map<String, Object> config = new HashMap();
        config.put("cloud_name", cloudName);
        config.put("api_key", cloudApiKey);
        config.put("api_secret", cloudApiSecret);
        Cloudinary cloudinary = new Cloudinary(config);

        Transformation transformation = new Transformation<>();
        transformation.width(150)
                .height(150)
                .crop("fill")
                .gravity("face")
                .radius("max");

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("folder", "user_images");
        parameters.put("transformation",transformation);

        Map uploadResult = cloudinary.uploader().upload(image.getBytes(), parameters);

        return (String) uploadResult.get("url");

    }
}
