package com.resale.background.mapper;

import com.resale.background.pojo.ProcessIdentifying;
import com.resale.background.pojo.ProcessIdentifyingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessIdentifyingMapper {
    long countByExample(ProcessIdentifyingExample example);

    int deleteByExample(ProcessIdentifyingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProcessIdentifying record);

    int insertSelective(ProcessIdentifying record);

    List<ProcessIdentifying> selectByExample(ProcessIdentifyingExample example);

    ProcessIdentifying selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProcessIdentifying record, @Param("example") ProcessIdentifyingExample example);

    int updateByExample(@Param("record") ProcessIdentifying record, @Param("example") ProcessIdentifyingExample example);

    int updateByPrimaryKeySelective(ProcessIdentifying record);

    int updateByPrimaryKey(ProcessIdentifying record);

	ProcessIdentifying selectByProcessId(String processId);

	/**
	 * 修改流程状态
	 * @param updateRecord
	 */
	void updateProcessIdentify(ProcessIdentifying updateRecord);
}