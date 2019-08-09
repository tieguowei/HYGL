package com.resale.background.mapper;

import com.resale.background.pojo.MemberBill;
import com.resale.background.pojo.MemberBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberBillMapper {
    long countByExample(MemberBillExample example);

    int deleteByExample(MemberBillExample example);

    int deleteByPrimaryKey(Integer billId);

    int insert(MemberBill record);

    int insertSelective(MemberBill record);

    List<MemberBill> selectByExample(MemberBillExample example);

    MemberBill selectByPrimaryKey(Integer billId);

    int updateByExampleSelective(@Param("record") MemberBill record, @Param("example") MemberBillExample example);

    int updateByExample(@Param("record") MemberBill record, @Param("example") MemberBillExample example);

    int updateByPrimaryKeySelective(MemberBill record);

    int updateByPrimaryKey(MemberBill record);
}