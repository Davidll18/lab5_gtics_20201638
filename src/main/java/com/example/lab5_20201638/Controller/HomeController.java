package com.example.lab5_20201638.Controller;

import com.example.lab5_20201638.entity.Viajes;
import com.example.lab5_20201638.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/travelcan")
public class HomeController {

    final ViajesRepository viajesRepository;
    public  HomeController(ViajesRepository viajesRepository){
        this.viajesRepository = viajesRepository;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String paginaPrincipal(){
        return "principal";
    }

    @GetMapping("/listaViajes")
    public String listaViajes(Model model){

        List<Viajes> lista = viajesRepository.findAll();
        model.addAttribute("viajelist",lista);
        return "viajes";
    }

    @GetMapping("/listaMascota")
    public String listaMascota(){
        return "mascotas";
    }

    @GetMapping("/formViaje")
    public String formViaje(){
        return "nuevoViaje";
    }

    @GetMapping("/listaPersonas")
    public String listaPersonas(){
        return "personas";
    }
    @GetMapping("/verMas")
    public String verMas(Model model, @RequestParam("id") int id){
        Optional<Viajes> optViaje = viajesRepository.findById(id);
        if(optViaje.isPresent()){
            Viajes viajes = optViaje.get();
            model.addAttribute("viajes", viajes);
            return "verMasViajes";
        }else {
            return "redirect: listaMascota";
        }

    }
}
