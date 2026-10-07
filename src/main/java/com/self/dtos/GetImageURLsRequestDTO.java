/* (C)2026 */
package com.self.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetImageURLsRequestDTO {
    private String url;
    private String rawContent;
}
