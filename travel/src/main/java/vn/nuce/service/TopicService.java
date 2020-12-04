package vn.nuce.service;

import vn.nuce.dto.TopicDto;

import java.util.List;

public interface TopicService {

    void saveTopic(TopicDto topicDto);
    List<TopicDto> findAllTopic();
    TopicDto findOneTopic(Long id);
    TopicDto updateTopic(TopicDto dto);
}
