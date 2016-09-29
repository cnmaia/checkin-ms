package br.mack.service.impl;

import br.mack.controller.dto.CheckInInfoResponse;
import br.mack.controller.dto.CheckinRequest;
import br.mack.exception.ResourceNotFoundException;
import br.mack.exception.ValidationException;
import br.mack.model.CheckIn;
import br.mack.model.User;
import br.mack.repository.CheckInRepository;
import br.mack.repository.UserRepository;
import br.mack.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cmaia on 29/09/16
 */
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void checkIn(CheckinRequest request) {
        validate(request);

        final CheckIn.Builder checkInBuilder = new CheckIn.Builder(null)
                .setLatitude(request.getLatitude())
                .setLongitude(request.getLongitude())
                .setCheckInTime(new Date());

        User user = userRepository.findOne(request.getUserId());
        checkInBuilder.setUser(user);

        checkInRepository.save(checkInBuilder.build());
    }

    @Override
    public CheckInInfoResponse getCheckInfo(long checkInId) {
        CheckIn checkIn = checkInRepository.findOne(checkInId);

        if (checkIn != null) {
            CheckInInfoResponse checkInInfo = new CheckInInfoResponse();

            checkInInfo.setLatitude(checkIn.getLatitude());
            checkInInfo.setLongitude(checkIn.getLongitude());
            checkInInfo.setUserEmail(checkIn.getUser().getEmail());
            checkInInfo.setCheckinTime(checkIn.getCheckInTime());

            return checkInInfo;
        }

        throw new ResourceNotFoundException(String.format("Check in [%d] not found.", checkInId));
    }

    private void validate(CheckinRequest request) {
        Map<String, String> validationErrors = new HashMap<String, String>();

        if (request.getUserId() <= 0) {
            validationErrors.put("userId", "Invalid user id");
        }

        if (request.getLatitude() <= 0) {
            validationErrors.put("latitude", "Invalid latitude");
        }

        if (request.getLongitude() <= 0) {
            validationErrors.put("longitude", "Invalid longitude");
        }

        if (validationErrors.size() > 0) {
            throw new ValidationException(validationErrors);
        }
    }
}
