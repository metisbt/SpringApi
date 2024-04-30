package com.example.springapi.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

//        without database
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "spring framework", "spring description"),
//                new Topic("java", "java programming", "java description"),
//                new Topic("python", "django framework", "python description")
//        ));

    public List<Course> getAllCourse(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
//        without database
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//
//        with database
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
//        without database
//        topics.add(topic);

//        with database
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
//        without database
//        for (int i = 0; i < topics.size() ; i++) {
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }

//        with database
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
//        without database
//        topics.removeIf(t -> t.getId().equals(id));

//        with database
        courseRepository.deleteById(id);

    }

}
