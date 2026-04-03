-- Write your query below

select distinct page_id as recommended_page from likes
where user_id!=1 and user_id in(select 
case 
    when user1_id=1 then user2_id
    when user2_id=1 then user1_id
end from friendship)
and page_id not in(select page_id from likes where user_id=1);