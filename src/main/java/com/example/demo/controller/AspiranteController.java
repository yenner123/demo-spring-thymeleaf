package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.demo.domain.Aspirante;
import com.example.demo.dto.AspiranteDTO;
import com.example.demo.dto.SelectorDTO;
import com.example.demo.service.AspiranteService;
import com.example.demo.service.MunicipioService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AspiranteController {

    private final AspiranteService aspiranteService;

    private final MunicipioService municipioService;

    static Map<String, String> tiposDocumentos = Map.of("CC", "Cédula de Ciudadania", "CE", "Cédula de Extranjeria");

    @GetMapping({ "/", "/index" })
    public String indexPage(Model model) {
        List<Aspirante> aspirantes = aspiranteService.listAll();
        model.addAttribute("aspirantes", aspirantes);
        return "index";
    }

    @GetMapping("/new")
    public String newPage(Model model) {
        List<SelectorDTO> municipios = municipioService.listAllAsSelectorDTO();
        model.addAttribute("aspirante", new AspiranteDTO());
        model.addAttribute("municipios", municipios);
        model.addAttribute("tiposDocumentos", tiposDocumentos);
        return "new";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("edit");
        AspiranteDTO aspirante = aspiranteService.get(id);
        mav.addObject("aspirante", aspirante);
        List<SelectorDTO> municipios = municipioService.listAllAsSelectorDTO();
        mav.addObject("municipios", municipios);
        mav.addObject("tiposDocumentos", tiposDocumentos);
        return mav;
    }

    @PostMapping(value = "/save")
    public String save(@Valid AspiranteDTO aspirante, BindingResult result, Model model) {
        aspiranteService.save(aspirante);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        aspiranteService.delete(id);
        return "redirect:/index";
    }
}