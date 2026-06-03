-- Write your query below
select distinct title from
tv_program t join content c on t.content_id = c.content_id
where kids_content like '%Y%' and t.program_date like '%2020-06%' and c.content_type='Movies';