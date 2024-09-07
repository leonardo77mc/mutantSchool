package com.mutantschool.service;
import com.mutantschool.model.Adn;
import org.springframework.transaction.annotation.Transactional;

public interface AdnService {
    public boolean save(String[] adn);
}