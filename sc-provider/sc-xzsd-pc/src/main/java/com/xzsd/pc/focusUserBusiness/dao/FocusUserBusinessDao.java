package com.xzsd.pc.focusUserBusiness.dao;

import com.xzsd.pc.focusUserBusiness.entity.FocusUserBusinessInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FocusUserBusinessDao {
    /**
     * 获取关注用户业务编号
     * wumaoxing
     * 2020-10-27 16:13
     */
    List<FocusUserBusinessInfo> queryFocusUserBusinessId(@Param("listUserId") List<String> listUserId, @Param("focusUserId") String focusUserId);
    /**
     * 未关注->关注
     * wumaoxing
     * 2020-10-27 16:13
     */
    int addFocusUserBusiness(FocusUserBusinessInfo focusUserBusinessInfo);
    /**
     * 关注->取消关注
     * wumaoxing
     * 2020-10-27 16:13
     */
    int deleteFocusUserBusiness(FocusUserBusinessInfo focusUserBusinessInfo);
}
