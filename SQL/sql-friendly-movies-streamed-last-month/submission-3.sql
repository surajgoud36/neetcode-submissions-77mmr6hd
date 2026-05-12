-- Write your query below
select distinct title from content
where kids_content = 'Y' and content_type= 'Movies'
and content_id in (select content_id from tv_program where program_date like '%2020-06%');