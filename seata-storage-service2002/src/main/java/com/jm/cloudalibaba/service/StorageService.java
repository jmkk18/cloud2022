package com.jm.cloudalibaba.service;

import org.springframework.stereotype.Service;

public interface StorageService {
    void decrease(Long productId,Integer count);
}
