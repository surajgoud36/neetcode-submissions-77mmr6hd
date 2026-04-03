-- Write your query below
select distinct title from content c
join tv_program t on c.content_id=t.content_id
where t.program_date like '%2020-06%' and c.kids_content like '%Y%'
and c.content_type='Movies';