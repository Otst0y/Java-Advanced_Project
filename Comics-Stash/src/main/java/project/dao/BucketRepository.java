package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Integer> {
}
