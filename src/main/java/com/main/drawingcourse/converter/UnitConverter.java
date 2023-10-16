package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.UnitModel;
import com.main.drawingcourse.entity.Unit;
import com.main.drawingcourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnitConverter {

    @Autowired
    CourseRepository courseRepository;



    public Unit toEntity(UnitModel unitDTO) {
        Unit entity = new Unit();
        entity.setUnitId(unitDTO.getUnitId());
        entity.setContent(unitDTO.getContent());
        entity.setTitle(unitDTO.getTitle());
        entity.setCourse(courseRepository.getReferenceById(unitDTO.getCourseId()));
        return entity;
    }


    public UnitModel toDTO(Unit unitEntity) {
        UnitModel dto = new UnitModel();
        dto.setUnitId(unitEntity.getUnitId());
        dto.setContent(unitEntity.getContent());
        dto.setTitle(unitEntity.getTitle());
        dto.setCourseId(unitEntity.getCourse().getCourseId());
        return dto;
    }
}
