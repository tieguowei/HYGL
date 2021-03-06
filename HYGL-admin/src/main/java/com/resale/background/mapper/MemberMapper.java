package com.resale.background.mapper;

import com.resale.background.pojo.Member;
import com.resale.background.pojo.MemberExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    long countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	void deleteMember(Member member);

	Member checkPwd(Member member);

	void updateTotalMoney(Member member);

	void updateResidueMoney(Member member);

	void updateResidueScore(Member member);

	List<Map<String, Object>> findBirthdayAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findBirthdayAllByPageCount(Map<String, Object> paramsCondition);

	String getTodayNum(Map<String, Object> paramsCondition);

	String getMonthNum(Map<String, Object> paramsCondition);
}