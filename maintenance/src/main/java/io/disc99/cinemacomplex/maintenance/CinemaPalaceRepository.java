package io.disc99.cinemacomplex.maintenance;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaPalaceRepository extends JpaRepository<CinemaPalace, Long> {
    List<CinemaPalace> findByNameStartsWithIgnoreCase(String text);
}
