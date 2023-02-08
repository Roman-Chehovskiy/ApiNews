package test.event.apiNews.services;

import test.event.apiNews.entity.News;

import java.util.List;

public interface NewsService {
    List<News> getNews();
    List<News> getNewsByTopic(String topic);
    List<News> getNewsBySource(String source);
}
