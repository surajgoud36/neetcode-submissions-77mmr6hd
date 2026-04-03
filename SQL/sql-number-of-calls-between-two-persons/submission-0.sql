-- Write your query below
select person1,person2, count(*) as call_count, sum(duration) as total_duration from
(select 
    (case
        when from_id>to_id then to_id
        else from_id
    end) as person1, 
    (case
        when to_id < from_id then from_id
        else to_id
    end) person2, duration
    from calls) group by person1,person2;