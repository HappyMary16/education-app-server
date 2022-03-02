package com.mborodin.uwm.model.mapper;

import com.mborodin.uwm.api.structure.GroupApi;
import com.mborodin.uwm.config.MapperConfiguration;
import com.mborodin.uwm.model.persistence.StudyGroupDataDb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface GroupMapper {

    @Mapping(target = "educationStartYear", ignore = true)
    @Mapping(target = "universityId", ignore = true)
    GroupApi toGroupApi(StudyGroupDataDb institute);

    StudyGroupDataDb toStudyGroupDataDb(GroupApi institute);
}
