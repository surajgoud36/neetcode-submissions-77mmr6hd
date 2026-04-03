-- Write your query below
-- select student_id,exam_id,max(score) as score from exam_results
-- group by student_id,exam_id;

-- select distinct on (student_id) student_id,exam_id,score from exam_results
-- order by student_id,score desc,exam_id;

select distinct on (e.student_id) e.student_id,e.exam_id,e.score from exam_results e join
(select student_id,max(score) as max_score from exam_results group by student_id) m on
e.student_id=m.student_id and e.score=m.max_score
order by e.student_id,e.score desc,e.exam_id;