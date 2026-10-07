/* (C)2026 */
package com.self.services.bases;

import com.self.entities.Artist;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ArtistService {
    List<Artist> getAllArtists();
}
