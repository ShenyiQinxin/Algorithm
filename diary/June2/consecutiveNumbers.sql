/**For example, given the above Logs table, 
1 is the only number that appears consecutively for at least three times.
*/
select num "ConsecutiveNums"
from 
(select num, count(num) count_num 
from Logs group by num order by count_num desc)
where rownum=1;