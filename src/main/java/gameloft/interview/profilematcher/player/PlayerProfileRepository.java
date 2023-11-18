package gameloft.interview.profilematcher.player;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProfileRepository extends MongoRepository<PlayerProfile, String> {

  @Override
  public Optional<PlayerProfile> findById(String id);
  
  @Override
  public <S extends PlayerProfile> S save(S entity);

}
