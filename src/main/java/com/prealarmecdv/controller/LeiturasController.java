package com.prealarmecdv.controller;
import com.prealarmecdv.application.usecases.*;
import com.prealarmecdv.domain.DTO.FindAnomaliasDTO;
import com.prealarmecdv.domain.DTO.FindResistanceAnomalias;
import com.prealarmecdv.domain.Response.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@Controller
@RestController
@RequestMapping("/leituras")
public class LeiturasController {
    private ListAllLeituras listAllLeituras;
    private ListByDistrict listByDistrict;
    private ListByAddress listByAddress;
    private FindByAnomalias findByAnomalias;
    private GetAllAddress getAllAddress;
    private FindByResistanceAnomalias findByResistanceAnomalias;

    public LeiturasController(ListAllLeituras listAllLeituras, ListByDistrict listByDistrict,
                              ListByAddress listByAddress, FindByAnomalias findByAnomalias,
                              GetAllAddress getAllAddress, FindByResistanceAnomalias findByResistanceAnomalias) {
        this.listAllLeituras = listAllLeituras;
        this.listByDistrict = listByDistrict;
        this.listByAddress = listByAddress;
        this.findByAnomalias = findByAnomalias;
        this.getAllAddress = getAllAddress;
        this.findByResistanceAnomalias = findByResistanceAnomalias;
    }

    @GetMapping
    public ResponseEntity<Response> listAll(){
        Response response = this.listAllLeituras.execute();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    @GetMapping("/distritos")
    public ResponseEntity<Response> listByDistrict(@RequestParam(name = "distrito") String distrito,
                                                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim)

    {
        Response response = this.listByDistrict.execute(distrito, dataInicio, dataFim);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    @GetMapping("/address")
    public ResponseEntity<Response> listByAddress(@RequestParam(name = "address") String address,
                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim){
        Response response = this.listByAddress.execute(address, dataInicio, dataFim);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    @GetMapping("get-address")
    public ResponseEntity<Response> getAllAddress(){
        Response response = this.getAllAddress.execute();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    @GetMapping("/anomalias/corrente")
    public ResponseEntity<Response> findAnomalias(@RequestParam(name = "distrito") String distrito,
                                                  @RequestParam(name = "correnteMin") Double correnteMin,
                                                  @RequestParam(name = "correnteMax") Double correnteMax,
                                                  @RequestParam(name = "dataInicio") LocalDateTime dataInicio
    ){
        FindAnomaliasDTO data = new FindAnomaliasDTO(correnteMin, correnteMax, dataInicio);
        Response response = this.findByAnomalias.execute(distrito, data);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    @GetMapping("/anomalias/resistencia")
    public ResponseEntity<Response> findAnomaliasResistencia(@RequestParam(name = "distrito") String distrito,
                                                             @RequestParam(name = "resistencia") Double resistencia,
                                                             @RequestParam(name = "dataInicio") LocalDateTime dataInicio
    ){
        FindResistanceAnomalias data = new FindResistanceAnomalias(resistencia, dataInicio);
        Response response = this.findByResistanceAnomalias.execute(distrito, data);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}
