package com.geobyte_assement.Geobyte_Assement.repositories;

import com.geobyte_assement.Geobyte_Assement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long > {
}
