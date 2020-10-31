package com.xzsd.pc.focusUserBusiness.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.focusUserBusiness.dao.FocusUserBusinessDao;
import com.xzsd.pc.focusUserBusiness.entity.FocusUserBusinessInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class FocusUserBusinessService {

    @Resource
    private FocusUserBusinessDao focusUserBusinessDao;

    /**
     * 获取关注用户业务编号
     * wumaoxing
     * 2020-10-27 16:06
     */
    public AppResponse queryFocusUserBusinessId(String userId, String focusUserId) {
        List<String> listUserId = Arrays.asList(userId.split(","));
        return AppResponse.success("查询成功！", focusUserBusinessDao.queryFocusUserBusinessId(listUserId, focusUserId));
    }

    /**
     * 未关注->关注
     * wumaoxing
     * 2020-10-27 16:07
     */
    public AppResponse addFocusUserBusiness(FocusUserBusinessInfo focusUserBusinessInfo) {
        focusUserBusinessInfo.setCreateBy(focusUserBusinessInfo.getFocusUserId());
        focusUserBusinessInfo.setFocusUserBusinessId(StringUtil.getCommonCode(2));
        // 新增数据
        int count = focusUserBusinessDao.addFocusUserBusiness(focusUserBusinessInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 关注->取消关注
     * wumaoxing
     * 2020-10-27 16:07
     */
    public AppResponse deleteFocusUserBusiness(FocusUserBusinessInfo focusUserBusinessInfo) {
        focusUserBusinessInfo.setLastModifiedBy(focusUserBusinessInfo.getFocusUserId());
        // 删除数据
        int count = focusUserBusinessDao.deleteFocusUserBusiness(focusUserBusinessInfo);
        if(0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
}
