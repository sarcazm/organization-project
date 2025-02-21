package ru.bellintegrator.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.dto.OrganizationDto;
import ru.bellintegrator.model.wrapper.response.Data;
import ru.bellintegrator.service.organization.OrganizationService;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/list")
    public <T> T organizations(@RequestBody OrganizationDto organizationDto) {
        try {

            // for commit
            // for commit2
            // for commit3
            // for commit4
            // for commit5
            // for commit7
            return (T) organizationService.getOrganizationsByParams(organizationDto);
        } catch (RuntimeException ex) {
            return (T) ("error:" + ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public <T> T getById(@PathVariable("id") Long id) {
        try {
            return (T) new Data<OrganizationDto>(organizationService.foundById(id));

        } catch (RuntimeException ex) {
            return (T) ("error:" + ex.getMessage());
        }
    }

    @PostMapping("/update")
    public <T> T update(@RequestBody OrganizationDto organizationDto) {
        try {
            organizationService.updateByParams(organizationDto);
        } catch (RuntimeException ex) {
            return (T) ("error:" + ex.getMessage());
        }
        String result = "{\"result\":\"success\"}";
        return (T) result;
    }

    @PostMapping("/save")
    public <T> T save(@RequestBody OrganizationDto organizationDto) {
        try {
            organizationService.saveByParams(organizationDto);
        } catch (RuntimeException ex) {
            return (T) ("error:" + ex.getMessage());
        }
        String result = "{\"result\":\"success\"}";
        return (T) result;
    }
}
