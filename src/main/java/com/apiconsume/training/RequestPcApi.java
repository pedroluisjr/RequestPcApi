package com.apiconsume.training;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("cep-request")
public class RequestPcApi {
    @GetMapping("{cep}")
    public RequestPcDto requestDto (@PathVariable("cep")String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RequestPcDto> resp = restTemplate.getForEntity(String.format("http://viacep.com.br/ws/%s/json/", cep), RequestPcDto.class);
        return resp.getBody();
    }

}
