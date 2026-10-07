/* (C)2026 */
package com.self.services.implementations;

import com.self.dtos.AddSongRequestDTO;
import com.self.entities.Song;
import com.self.repositories.SongRepository;
import com.self.services.bases.SongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    @Autowired private SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
    ;

    public Song addSong(AddSongRequestDTO requestDTO) {
        Song song =
                Song.builder()
                        .songName(requestDTO.getSongName())
                        .artistId(requestDTO.getArtistId())
                        .songTypeId(requestDTO.getSongTypeId())
                        .genreId(requestDTO.getGenreId())
                        .minBpm(requestDTO.getMinBpm())
                        .maxBpm(requestDTO.getMaxBpm())
                        .versionId(requestDTO.getVersionId())
                        .build();

        return songRepository.save(song);
    }
}
