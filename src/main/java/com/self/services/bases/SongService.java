/* (C)2026 */
package com.self.services.bases;

import com.self.dtos.AddSongRequestDTO;
import com.self.entities.Song;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SongService {
    List<Song> getAllSongs();

    Song addSong(AddSongRequestDTO requestDTO);
}
