/* (C)2026 */
package com.self.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/inquiry")
public class InquiryController {
    @GetMapping(path = "/songs")
    public List<Object> getAllSongs() {
        return List.of();
    }

    @GetMapping(path = "/artists")
    public List<Object> getAllArtists() {
        return List.of();
    }

    @GetMapping(path = "/song-types")
    public List<Object> getAllSongTypes() {
        return List.of();
    }

    @GetMapping(path = "/genres")
    public List<Object> getAllGenres() {
        return List.of();
    }

    @GetMapping(path = "/versions")
    public List<Object> getAllVersions() {
        return List.of();
    }
}
