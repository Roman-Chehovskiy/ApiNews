package test.event.apiNews.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.event.apiNews.entity.Topic;
import test.event.apiNews.repository.TopicsRepository;
import test.event.apiNews.services.TopicService;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicsRepository topicsRepository;

    //получаем все темы новостей
    public List<Topic> getTopics() {
        return topicsRepository.findAll();
    }

}
