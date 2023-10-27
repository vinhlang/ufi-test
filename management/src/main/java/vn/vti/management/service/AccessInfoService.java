package vn.vti.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.vti.management.repository.AccessInfoRepository;
import vn.vti.management.entity.AccessInfo;

@Service
public class AccessInfoService {
    @Autowired
    AccessInfoRepository accessInfoRepository;

    public AccessInfo loadUserById(Long userId) {

        return accessInfoRepository.getAccessInfoById(userId);
    }

    public AccessInfo getAccessInfo(String username, String password) {
        // TODO Auto-generated method stub
        return accessInfoRepository.getAccessInfoByLogin(username, password);
    }

    ;
}
