package br.mack.controller;

import br.mack.controller.dto.CheckinRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cmaia on 29/09/16
 */
@RestController
@RequestMapping("/checkin")
public class CheckInController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    private ResponseEntity checkIn(@RequestBody CheckinRequest checkinRequest) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private ResponseEntity getCheckinInformation(@PathVariable("id") Long checkinId) {
        return null;
    }
}
