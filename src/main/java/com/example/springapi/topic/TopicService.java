package com.example.springapi.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//        without database
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "spring framework", "spring description"),
//                new Topic("java", "java programming", "java description"),
//                new Topic("python", "django framework", "python description")
//        ));

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
//        without database
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//
//        with database
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
//        without database
//        topics.add(topic);

//        with database
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        without database
//        for (int i = 0; i < topics.size() ; i++) {
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }

//        with database
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        without database
//        topics.removeIf(t -> t.getId().equals(id));

//        with database
        topicRepository.deleteById(id);

    }

}
