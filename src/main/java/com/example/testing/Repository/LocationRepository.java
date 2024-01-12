package com.example.testing.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.testing.Dto.Location;

public interface LocationRepository extends MongoRepository<Location, String> {
}
