package ru.bellintegrator.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.dto.OrganizationDto;
import ru.bellintegrator.service.organization.OrganizationService;


import java.util.List;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    @PostMapping("/list")
    public List<OrganizationDto> organizations(){
        return organizationService.organizations();
    }
    @GetMapping("/{id}")
    public OrganizationDto getById(@PathVariable("id") Long id){
        return null;
    }
}
