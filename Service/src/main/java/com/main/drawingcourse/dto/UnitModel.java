package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class UnitModel {
    private int unitId;
    private String title;
    private String content;
    private int courseId;
}
