package bcntec.spring.data.entities;


import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(
        @NamedQuery(name = "userOrderByName", query = "from User u order by u.name")
)
@MappedSuperclass
public class MyQueries1 {
}
