package test.event.apiNews.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.event.apiNews.entity.Sources;
import test.event.apiNews.repository.SourceRepository;
import test.event.apiNews.services.SourcesService;

import java.util.List;

@Service
public class SourcesServiceImpl implements SourcesService {

    @Autowired
    private SourceRepository sourceRepository;

    //получаем все источники новостей
    public List<Sources> getSources() {
        return sourceRepository.findAll();
    }
}
