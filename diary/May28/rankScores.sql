select round(score,2) as "Score", rn as "Rank"
from (select scores.*, dense_rank() over (order by score desc) rn from scores)
