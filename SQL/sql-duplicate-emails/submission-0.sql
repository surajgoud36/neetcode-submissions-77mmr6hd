-- Write your query below
select email from
(select email,count(*) as count from person group by email)
where count>1;