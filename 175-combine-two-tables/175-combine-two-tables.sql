# Write your MySQL query statement below
select p.firstname, p.lastname , q.city,q.state from Person as p left join Address as q on p.personId = q.personId;