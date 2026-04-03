-- Write your query below
select name,balance from 
(select account,sum(amount) as balance from transactions group by account) t
join users u on u.account=t.account
where balance>10000;