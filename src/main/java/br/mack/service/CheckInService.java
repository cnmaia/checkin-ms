package br.mack.service;

import br.mack.controller.dto.CheckInInfoResponse;
import br.mack.controller.dto.CheckinRequest;
import br.mack.exception.ResourceNotFoundException;

/**
 * Created by cmaia on 29/09/16
 */
public interface CheckInService {

    /**
     * Check in.
     *
     * @param request the request
     */
    void checkIn(CheckinRequest request);

    /**
     * Gets check info.
     *
     * @param checkInId the check in id
     * @return the check info
     * @throws ResourceNotFoundException the resource not found exception
     */
    CheckInInfoResponse getCheckInfo(long checkInId) throws ResourceNotFoundException;
}
