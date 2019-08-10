package com.resale.background.mapper;

import com.resale.background.pojo.MemberScore;
import com.resale.background.pojo.MemberScoreExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MemberScoreMapper {
    long countByExample(MemberScoreExample example);

    int deleteByExample(MemberScoreExample example);

    int deleteByPrimaryKey(Integer scoreId);

    int insert(MemberScore record);

    int insertSelective(MemberScore record);

    List<MemberScore> selectByExample(MemberScoreExample example);

    MemberScore selectByPrimaryKey(Integer scoreId);

    int updateByExampleSelective(@Param("record") MemberScore record, @Param("example") MemberScoreExample example);

    int updateByExample(@Param("record") MemberScore record, @Param("example") MemberScoreExample example);

    int updateByPrimaryKeySelective(MemberScore record);

    int updateByPrimaryKey(MemberScore record);

	void updateMemberScore(List<Map<String, String>> data);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
}