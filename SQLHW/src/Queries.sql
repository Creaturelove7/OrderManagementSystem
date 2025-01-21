/* The student enrolled most number of class*/
select s.student_name , count(course_id)
from enrollments
         join student s
              on enrollments.student_id = s.id
group by s.id, s.student_name
order by count(course_id) desc
    limit 1;

/*Find most popular course enrooled by students*/
select course_name, count(student_id) as enrolled_students
from enrollments e
         join course c
              on e.course_id = c.id
group by course_id
order by enrolled_students desc
    limit 1
;

/*Find students who will have birthday next week.*/
select student_name
from student
WHERE
 DAYOFYEAR(dof) BETWEEN DAYOFYEAR(CURDATE()) + 1 AND DAYOFYEAR(CURDATE()) + 7;

/*Best student(highest score) of each course.*/
select course_id, student_name, score
from enrollments e
join student s
on e.student_id = s.id
WHERE score in (
	select max(e1.score)
	from enrollments e1
	group by course_id
);