package br.mack;

import br.mack.controller.dto.CheckinRequest;
import br.mack.exception.ValidationException;
import br.mack.model.CheckIn;
import br.mack.model.User;
import br.mack.repository.CheckInRepository;
import br.mack.repository.UserRepository;
import br.mack.service.CheckInService;
import br.mack.service.impl.CheckInServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by cmaia on 29/09/16
 */
public class CheckInServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private CheckInRepository checkInRepository;

    @InjectMocks
    private CheckInService checkInService;

    private User userTest;

    @Before
    public void setUp() {
        checkInService = new CheckInServiceImpl();
        MockitoAnnotations.initMocks(this);
        userTest = new User(1L, "UserTest", "user@test.com");
    }

    @Test
    public void testCheckIn_Success() {
        Mockito.when(checkInRepository.save(any(CheckIn.class))).thenReturn(null);
        Mockito.when(userRepository.findOne(anyLong())).thenReturn(userTest);

        CheckinRequest request = new CheckinRequest();
        request.setLatitude(1.0);
        request.setLongitude(1.0);
        request.setUserId(1L);

        checkInService.checkIn(request);

        verify(checkInRepository, times(1)).save(any(CheckIn.class));
        verify(userRepository, times(1)).findOne(anyLong());
    }

    @Test(expected = ValidationException.class)
    public void testCheckIn_EmptyRequest_ShouldThrowValidationException() {
        CheckinRequest request = new CheckinRequest();

        checkInService.checkIn(request);
    }

    @Test(expected = ValidationException.class)
    public void testCheckIn_InvalidRequest_ShouldThrowValidationException() {
        CheckinRequest request = new CheckinRequest();
        request.setLatitude(-1);

        checkInService.checkIn(request);
    }

    @Test
    public void testCheckIn_InvalidRequest_ShouldStackValidationErrors() {
        CheckinRequest request = new CheckinRequest();

        request.setLatitude(-1);
        request.setLongitude(-1);
        request.setUserId(0);

        try {
            checkInService.checkIn(request);
        } catch (ValidationException ex) {
            assertEquals(3, ex.getValidationErrors().size());
        }
    }
}