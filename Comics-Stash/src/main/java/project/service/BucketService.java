package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.BucketRepository;
import project.domain.Bucket;

import java.util.List;

@Service
public class BucketService {

    @Autowired
    private BucketRepository bucketRepository;

    public List<Bucket> getAll() {
        return bucketRepository.findAll();
    }

    public void delete(Bucket bucket) {
        bucketRepository.delete(bucket);
    }

    public Bucket add(Bucket bucket) {
        return bucketRepository.save(bucket);
    }
}
