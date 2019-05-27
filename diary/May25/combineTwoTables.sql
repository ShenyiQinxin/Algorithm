/**
 * sql 175. Combine Two Tables
 * provides the following information for each person in the Person table, regardless if there is an address for each of those people:
FirstName, LastName, City, State
 */
select p.FirstName, p.LastName, a.City, a.State
from Person p left join Address a
on p.PersonId=a.PersonId