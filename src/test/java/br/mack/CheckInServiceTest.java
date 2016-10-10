package br.mack;

import br.mack.controller.dto.CheckInInfoResponse;
import br.mack.controller.dto.CheckinRequest;
import br.mack.exception.ResourceNotFoundException;
import br.mack.exception.ValidationException;
import br.mack.model.CheckIn;
import br.mack.model.dto.UserDto;
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
import retrofit.Call;
import retrofit.Response;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

    private Call<UserDto> callUser;
    private UserDto userDtoTest;
    private CheckIn checkInTest;

    @Before
    public void setUp() {
        checkInService = new CheckInServiceImpl();
        MockitoAnnotations.initMocks(this);

        callUser = null;
        userDtoTest = new UserDto(1L, "UserTest", "user@test.com");
        checkInTest = new CheckIn.Builder(1L)
                .setUser(userDtoTest)
                .setCheckInTime(new Date())
                .setLatitude(1.0)
                .setLongitude(1.0)
                .build();
    }

//    @Test
//    public void testCheckIn_Success() throws Exception {
//        Mockito.when(checkInRepository.save(any(CheckIn.class))).thenReturn(null);
//        Mockito.when(callUser.execute()).thenReturn(new Response(null, userDtoTest,null));
//        Mockito.when(userRepository.find(anyLong())).thenReturn(callUser);
//
//        CheckinRequest request = new CheckinRequest();
//        request.setLatitude(1.0);
//        request.setLongitude(1.0);
//        request.setUserId(1L);
//
//        checkInService.checkIn(request);
//
//        verify(checkInRepository, times(1)).save(any(CheckIn.class));
//        verify(userRepository, times(1)).find(anyLong());
//    }

    @Test(expected = ValidationException.class)
    public void testCheckIn_EmptyRequest_ShouldThrowValidationException() {
        CheckinRequest request = new CheckinRequest();

        checkInService.checkIn(request);
    }

    @Test(expected = ValidationException.class)
    public void testCheckIn_InvalidRequest_ShouldThrowValidationException() {
        CheckinRequest request = new CheckinRequest();
        request.setLatitude(-1D);
        request.setLongitude(-1D);
        request.setUserId(0L);

        checkInService.checkIn(request);
    }

    @Test
    public void testCheckIn_InvalidRequest_ShouldStackValidationErrors() {
        CheckinRequest request = new CheckinRequest();

        request.setLatitude(-1D);
        request.setLongitude(-1D);
        request.setUserId(0L);

        try {
            checkInService.checkIn(request);
        } catch (ValidationException ex) {
            assertEquals(3, ex.getValidationErrors().size());
        }
    }

    @Test
    public void testGetCheckInInfo_Success() {
        Mockito.when(checkInRepository.findOne(anyLong())).thenReturn(checkInTest);

        CheckInInfoResponse checkInfo = checkInService.getCheckInfo(1L);

        assertNotNull(checkInfo);
        verify(checkInRepository, times(1)).findOne(anyLong());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetCheckInInfo_NotExistentCheckIn_ShouldThrowException() {
        Mockito.when(checkInRepository.findOne(anyLong())).thenReturn(null);

        checkInService.getCheckInfo(1L);
    }
}
