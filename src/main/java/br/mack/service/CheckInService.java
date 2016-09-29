package br.mack.service;

import br.mack.controller.dto.CheckInInfoResponse;
import br.mack.controller.dto.CheckinRequest;

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
     */
    CheckInInfoResponse getCheckInfo(long checkInId);
}
