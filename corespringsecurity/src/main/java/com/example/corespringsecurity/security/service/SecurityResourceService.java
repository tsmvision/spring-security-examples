package com.example.corespringsecurity.security.service;

import com.example.corespringsecurity.domain.entity.Resources;
import com.example.corespringsecurity.repository.ResourcesRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RequiredArgsConstructor
public class SecurityResourceService {

    private final ResourcesRepository resourceRepository;

    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceList() {

        LinkedHashMap<RequestMatcher, List<ConfigAttribute>>  result = new LinkedHashMap<>();
        List<Resources> resourcesList = resourceRepository.findAllResources();
        resourcesList.forEach(re -> {
            List<ConfigAttribute> configAttributeList = new ArrayList<>();
            result.put(new AntPathRequestMatcher(re.getResourceName()), configAttributeList);
        });
        return result;
    }

}
