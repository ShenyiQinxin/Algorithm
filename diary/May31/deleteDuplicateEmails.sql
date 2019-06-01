delete larger
from person larger inner join person smaller
on larger.email=smaller.email
where larger.id>smaller.id;