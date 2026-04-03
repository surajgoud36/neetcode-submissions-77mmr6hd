-- Write your query below
-- select student_id,exam_id,max(score) as score from exam_results
-- group by student_id,exam_id;

select distinct on (student_id) student_id,exam_id,score from exam_results
order by student_id,score desc,exam_id;