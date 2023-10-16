package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.UnitModel;
import com.main.drawingcourse.repository.UnitRepository;
import com.main.drawingcourse.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/unit")
public class UnitController {

    @Autowired
    UnitRepository unitRepository;

    @Autowired
    IUnitService unitService;



    @PostMapping("/add")
    public UnitModel AddUnit(@RequestBody UnitModel unitModel) {

        return unitService.AddUnit(unitModel);
    }

}
