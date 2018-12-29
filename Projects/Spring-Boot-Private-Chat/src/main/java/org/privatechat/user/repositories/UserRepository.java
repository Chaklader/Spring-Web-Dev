package org.privatechat.user.repositories;

import org.privatechat.user.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  public User findByEmail(String email);

  public User findById(long id);

  @Query(" FROM"
      + "    User u"
      + "  WHERE"
      + "    u.email IS NOT :excludedUser")
  public List<User> findFriendsListFor(@Param("excludedUser") String excludedUser);
}