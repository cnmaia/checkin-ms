package br.mack.controller;

import br.mack.controller.dto.CheckinRequest;
import br.mack.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cmaia on 29/09/16
 */
@RestController
@RequestMapping("/checkin")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity checkIn(@RequestBody CheckinRequest checkinRequest) {
        checkInService.checkIn(checkinRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCheckinInformation(@PathVariable("id") Long checkinId) {
        return ResponseHelper.ok(checkInService.getCheckInfo(checkinId), HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity getAllCheckins() {
        return ResponseHelper.ok(checkInService.list(), HttpStatus.OK);
    }
}
