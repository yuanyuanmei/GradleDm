package com.example.common.dao;

import com.example.common.dto.JobDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface JobDao {

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into t_job(jobName, description, cron, springBeanName, methodName, isSysJob, status, createTime, updateTime) values(#{jobName}, #{description}, #{cron}, #{springBeanName}, #{methodName}, #{isSysJob}, 1, now(), now())")
	int save(JobDto JobDto);

	@Select("select * from t_job t where t.id = #{id}")
	JobDto getById(Long id);

	@Select("select * from t_job t where t.jobName = #{jobName}")
	JobDto getByName(String jobName);

	int update(JobDto JobDto);

	int count(@Param("params") Map<String, Object> params);

	List<JobDto> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset,
                        @Param("limit") Integer limit);
}
