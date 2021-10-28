package br.com.zup.CarrosVenta.Controllers;

import br.com.zup.CarrosVenta.DTOS.CarroDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {
    private List<CarroDto> consecionario = new ArrayList<>();

    @GetMapping
    public List<CarroDto> exibirCarro() {
        return consecionario;
    }

    @PostMapping
    public void cadastrarCarro(@RequestBody CarroDto carroDto) {
        consecionario.add(carroDto);
    }

    @GetMapping("/{nomeCarro}")//Pegar e exibir carro
    public CarroDto exibirCarro(@PathVariable String nomeCarro){

        for (CarroDto carroDto : consecionario) {
            if (carroDto.getModelo().equalsIgnoreCase(nomeCarro)) {
                return carroDto;
            }

        }

        throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{modeloCarro}")
    public CarroDto atualizarCarro (@PathVariable String modeloCarro, @RequestBody CarroDto carroDto){
        for (CarroDto carroRef : consecionario) {
            if (carroRef.getModelo().equalsIgnoreCase(modeloCarro)) {
                carroRef.setAno(carroRef.getAno());
                carroRef.setCor(carroRef.getCor());
                carroRef.setMotor(carroRef.getMotor());
                return carroRef;
            }

        }
thro
    }
}