package pl.pjatk.jazs21484nbp.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.jazs21484nbp.exceptionhandler.ApiError;
import pl.pjatk.jazs21484nbp.model.NbpResponse;
import pl.pjatk.jazs21484nbp.service.NbpService;

@RestController
@RequestMapping("/nbp")
public class NbpController {

    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiOperation(value = "Get average gold price for given date",
            response = NbpResponse.class,
            notes = "This method will return average price of gold for given date")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found", response = ApiError.class),
            @ApiResponse(code = 500, message = "Unexpected  error")
    })
    @GetMapping(value = "/{dateFrom}/{dateTo}")
    public ResponseEntity<NbpResponse> getAverageGoldPrice(
            @ApiParam(
                    name = "dateFrom",
                    type = "String",
                    value = "description",
                    example = "2022-01-01",
                    required = true,
                    defaultValue = "2022.01.01")
            @PathVariable String dateFrom,
            @ApiParam(
                    name = "dateTo",
                    type = "String",
                    value = "description",
                    example = "2022.06.01",
                    required = true,
                    defaultValue = "2022.01.01")
            @PathVariable String dateTo) {
        return ResponseEntity.ok(nbpService.calculateAverageGoldPrice(dateFrom, dateTo));
    }
}
