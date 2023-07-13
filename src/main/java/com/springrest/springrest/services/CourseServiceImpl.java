package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    //List<Course> list;

    public CourseServiceImpl() {
        /*this.list = new ArrayList<>();
        list.add(new Course(1, "Java course", "This course contain basics of springboot"));
        list.add(new Course(2, "Golang course", "This course contain basics of golang gin framework"));

         */
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        /*Course c = null;
        for (Course course : list) {
            if (course.getId() == courseId) {
                c = course;
                break;
            }
        }
        return c;*/

        return courseDao.getReferenceById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        // list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        //tried to use lamda function here on list to map and update list's course
       /* list.forEach(e -> {
            if (e.getId() == course.getId()) {
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;*/

        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(Long courseId) {
      /*  list = this.list.stream()
                .filter(
                e -> e.getId() != courseId)
                .collect(Collectors.toList());*/
        Course id = courseDao.getReferenceById(courseId);
        courseDao.delete(id);
    }
}
