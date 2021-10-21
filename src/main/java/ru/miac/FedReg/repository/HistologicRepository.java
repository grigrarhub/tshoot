package ru.miac.FedReg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.miac.FedReg.entity.Histologic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface HistologicRepository extends JpaRepository<Histologic,Integer> {
    Optional<Histologic> findAllByNum(String num);
    List<Histologic> findAllByDateRunAfter(LocalDateTime localDateTime);

    @Query(value = "select * from histologic order by id DESC limit 1;",nativeQuery = true)
    Optional<Histologic> getLastLog();

}
