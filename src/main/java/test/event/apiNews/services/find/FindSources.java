package test.event.apiNews.services.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.event.apiNews.entity.Sources;
import test.event.apiNews.repository.SourceRepository;

import java.util.List;

@Service
public class FindSources {

    @Autowired
    private SourceRepository sourceRepository;

    //получаем все источники новостей
    public List<Sources> getSources() {
        return sourceRepository.findAll();
    }
}
