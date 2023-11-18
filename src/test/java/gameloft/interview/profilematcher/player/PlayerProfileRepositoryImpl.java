package gameloft.interview.profilematcher.player;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public class PlayerProfileRepositoryImpl implements PlayerProfileRepository {

  private final MongoTemplate mongoTemplate;

  public PlayerProfileRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<PlayerProfile> findAll() {
    return mongoTemplate.findAll(PlayerProfile.class);
  }

  @Override
  public Optional<PlayerProfile> findById(String id) {
    return Optional.of(mongoTemplate.findById(id, PlayerProfile.class));
  }

  @Override
  public PlayerProfile save(PlayerProfile playerProfile) {
    return mongoTemplate.save(playerProfile);
  }

  @Override
  public void delete(PlayerProfile playerProfile) {
    mongoTemplate.remove(playerProfile);
  }

  @Override
  public <S extends PlayerProfile> S insert(S entity) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public <S extends PlayerProfile> List<S> insert(Iterable<S> entities) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public <S extends PlayerProfile> List<S> findAll(Example<S> example) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public <S extends PlayerProfile> List<S> findAll(Example<S> example, Sort sort) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public <S extends PlayerProfile> List<S> saveAll(Iterable<S> entities) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public List<PlayerProfile> findAllById(Iterable<String> ids) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public boolean existsById(String id) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public long count() {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public void deleteById(String id) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public void deleteAllById(Iterable<? extends String> ids) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public void deleteAll(Iterable<? extends PlayerProfile> entities) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public void deleteAll() {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public List<PlayerProfile> findAll(Sort sort) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public Page<PlayerProfile> findAll(Pageable pageable) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public <S extends PlayerProfile> Optional<S> findOne(Example<S> example) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public <S extends PlayerProfile> Page<S> findAll(Example<S> example, Pageable pageable) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public <S extends PlayerProfile> long count(Example<S> example) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public <S extends PlayerProfile> boolean exists(Example<S> example) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public <S extends PlayerProfile, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    throw new RuntimeException("Not implemented yet!!!");
  }
}
