select today.id "Id"
from weather today
inner join weather yesterday
on today.temperature>yesterday.temperature
where today.recorddate=yesterday.recorddate+1;