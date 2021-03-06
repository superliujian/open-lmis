/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2013 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License along with this program.  If not, see http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

package org.openlmis.core.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
import org.openlmis.core.exception.DataException;

import java.io.IOException;

/**
 * BaseFeedDTO is the base class for all DTO objects which provides utility methods like getting a serialized DTO object.
 */
@Data
@NoArgsConstructor
public abstract class BaseFeedDTO {

  private static Logger logger = Logger.getLogger(BaseFeedDTO.class);

  @JsonIgnore
  public String getSerializedContents() {
    ObjectMapper mapper = new ObjectMapper();
    String feed;

    try {
      feed = mapper.writeValueAsString(this);
    } catch (IOException e) {
      logger.error("Error in serializing feed", e);
      throw new DataException("error.serialization");
    }
    return feed;
  }
}
