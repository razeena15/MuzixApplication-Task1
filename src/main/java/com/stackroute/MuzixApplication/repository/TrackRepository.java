package com.stackroute.MuzixApplication.repository;

import com.stackroute.MuzixApplication.domain.Track;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer>, CrudRepository<Track, Integer> {


}
