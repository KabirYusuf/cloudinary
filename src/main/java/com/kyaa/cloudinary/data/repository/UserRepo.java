package com.kyaa.cloudinary.data.repository;

import com.kyaa.cloudinary.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
