package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.UnitConverter;
import com.main.drawingcourse.dto.UnitModel;
import com.main.drawingcourse.entity.Unit;
import com.main.drawingcourse.repository.UnitRepository;
import com.main.drawingcourse.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitImpl implements IUnitService {
    @Autowired
    UnitConverter unitConverter;

    @Autowired
    UnitRepository unitRepository;



    public UnitModel AddUnit(UnitModel unitModel) {
        Unit unitEntity = unitConverter.toEntity(unitModel);
        unitEntity = unitRepository.save(unitEntity);

        return unitConverter.toDTO(unitEntity);
    }
}
