/* (C)2026 */
package com.self.controller;

import com.self.dtos.AddSongRequestDTO;
import com.self.entities.Song;
import com.self.services.bases.SongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/song")
public class SongController {
    @Autowired private SongService songService;

    @GetMapping(path = "/get-all-songs")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songList = songService.getAllSongs();
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }

    @PutMapping(path = "/add")
    public ResponseEntity<Object> addSong(@RequestBody AddSongRequestDTO requestDTO) {
        return new ResponseEntity<>(songService.addSong(requestDTO), HttpStatus.OK);
    }
}
