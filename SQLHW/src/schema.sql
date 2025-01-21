course:
    id,
    name,
    teacher_id, fk
student:
    id,
    name,
    dof
teacher:
    id,
    name
enrollments:
    id,
    student_id fk,
    course_id fk,
    score

select student_id
from enrollments
group by student_id
order by count(course_id) desc
limit 1;

select course_id
from enrollments
group by course_id
order by count(student_id) desc
    limit 1;

select name
from student
where dof between today and today + 7;

select student_id
from enrollments
group by course_id, student_id
order by score desc
limit 1;