package com.stackroute.MuzixApplication.controller;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exception.IdNotFoundException;
import com.stackroute.MuzixApplication.exception.TracNotFoundException;
import com.stackroute.MuzixApplication.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import com.stackroute.MuzixApplication.service.TrackService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class TrackController {
    TrackRepository trackRepository;
    TrackService trackService;
    ResponseEntity responseEntity;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


    @PostMapping("track")
    public ResponseEntity<?> saveTracks(@RequestBody Track track)

    {
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch(TrackAlreadyExistsException ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks()
    {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)
    {

        try {
            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("successfully updated", HttpStatus.CREATED);
        }
        catch(IdNotFoundException e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id)
    {
        try
        {
            trackService.deleteTrack(id);
            responseEntity = new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
        } catch (TracNotFoundException e) {
           responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }


        return responseEntity;
    }








}
