-- Write your query below
select student_id,exam_id,score from (
    select student_id,exam_id,score, RANK() over (
        partition by student_id
        order by score desc, exam_id
    ) as rank_alias
    from exam_results
) where rank_alias = 1;