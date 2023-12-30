package com.practicaSpringCrud.CrudFutbolClub.Controllers.ControllersWeb.ControllersVista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practicaSpringCrud.CrudFutbolClub.Repository.AsociacionesRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.ClubesRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.CompetenciasRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.DirectoresRespository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.JugadoresRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.Documents.ClubesDocuments;

import org.springframework.ui.Model;

@Controller
@RequestMapping("clubes")
public class ClubesVista {

    @Autowired
    private ClubesRepository clubesRepository;

    @Autowired
    private JugadoresRepository jugadoresRepository;

    @Autowired
    private AsociacionesRepository asociacionesRepository;

    @Autowired
    private CompetenciasRepository competicionesRepository;

    @Autowired
    private DirectoresRespository directoresRepository;

    @GetMapping("/regresar")
    public String regresar(Model model) {
        model.addAttribute("clubes", clubesRepository.findAll());
        return "/index/index";
    }

    @GetMapping("/listarClubes")
    public String listarClubes(Model model) {
        model.addAttribute("clubes", clubesRepository.findAll());
        return "ClubesLista";
    }

    @GetMapping("/crearClubes")
    public String crearClubes(Model model) {
        model.addAttribute("clubes", new ClubesDocuments());
        model.addAttribute("directores", directoresRepository.findAll());
        model.addAttribute("jugadores", jugadoresRepository.findAll());
        model.addAttribute("asociaciones", asociacionesRepository.findAll());
        model.addAttribute("competencias", competicionesRepository.findAll());
        return "ClubesRegistro";
    }

    @GetMapping("/editarClubes/{id}")
    public String editarClubes(@PathVariable("id") String id, Model model) throws NotFoundException {
        model.addAttribute("clubes", clubesRepository.findById(id).orElseThrow());
        model.addAttribute("directores", directoresRepository.findAll());
        model.addAttribute("jugadores", jugadoresRepository.findAll());
        model.addAttribute("asociaciones", asociacionesRepository.findAll());
        model.addAttribute("competencias", competicionesRepository.findAll());
        return "ClubesRegistro";
    }

    @PostMapping("/guardarClubes")
    public String guardarClubes(@ModelAttribute("clubes") ClubesDocuments clubes) {
        if (clubes.getId().isEmpty()) {
            clubes.setId(null);
        }
        clubesRepository.save(clubes);
        return "redirect:/clubes/listarClubes";
    }

    @GetMapping("/eliminarClubes/{id}")
    public String eliminarClubes(@PathVariable("id") String id) {
        clubesRepository.deleteById(id);
        return "redirect:/clubes/listarClubes";
    }
}
