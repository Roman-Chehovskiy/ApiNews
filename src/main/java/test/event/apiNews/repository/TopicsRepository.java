package test.event.apiNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.event.apiNews.entity.Topic;

import java.util.List;

@Repository
public interface TopicsRepository extends JpaRepository<Topic, Long> {

}
