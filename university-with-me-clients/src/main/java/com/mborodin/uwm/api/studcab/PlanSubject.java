package com.mborodin.uwm.api.studcab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanSubject {

    private String audit;
    private String control;
    private String credit;
    private String indzav;
    private String kabr;
    private String kafedra;
    private String kurs;
    private String semestr;
    private String subj_id;
    private String subject;
}
