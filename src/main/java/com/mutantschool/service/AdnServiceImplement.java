package com.mutantschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mutantschool.repository.IAdnRepository;

@Service
public class AdnServiceImplement implements AdnService {

    @Autowired
    private IAdnRepository adnRepository;

    @Transactional
    @Override
    public boolean save(String[] adn) {
        String stringDna = String.join(",", adn);
        // adnRepository.save(stringDna);
        return isMutanst(adn, adn.length);
    }

    public boolean isMutanst(String[] adnList, int N) {
        int count = 0;
        char[][] columRow = new char[adnList.length][adnList.length];
        for (int i = 0; i < N; i++) {
            columRow[i] = adnList[i].toCharArray();
        }
        count += tourDna(columRow, N);
        return count > 0;
    }

    private int tourDna(char[][] columRow, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (columRow[i][j] == columRow[i][j + 1] && columRow[i][j + 1] == columRow[i][j + 2] && columRow[i][j + 2] == columRow[i][j + 3]) {
                    count++;
                }
                if (columRow[j][i] == columRow[j + 1][i] && columRow[j + 1][i] == columRow[j + 2][i] && columRow[j + 2][i] == columRow[j + 3][i]) {
                    count++;
                }
                if (columRow[i][j] == columRow[i + 1][j + 1] && columRow[i + 1][j + 1] == columRow[i + 2][j + 2] && columRow[i + 2][j + 2] == columRow[i + 3][j + 3]) {
                    count++;
                }
                if (columRow[i][j] == columRow[i + 1][j - 1] && columRow[i + 1][j - 1] == columRow[i + 2][j - 2] && columRow[i + 2][j - 2] == columRow[i + 3][j - 3]) {
                    count++;
                }
            }
        }
        return count;
    }

}