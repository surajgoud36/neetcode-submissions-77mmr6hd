-- Write your query below

select transaction_id from
(select transaction_id,
rank() over (partition by extract(day from (day)) order by amount desc) as rnk from transactions)
where rnk=1
order by transaction_id;