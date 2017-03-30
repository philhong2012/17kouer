package com.seventeenkouer.common.constants;



import com.seventeenkouer.common.Exception.SeventeenkouException;
import com.seventeenkouer.common.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * 码表
 *
 * @author yongqin.zhong
 *
 */
public class BaseCode {

    // base domain
    /**
     * 成功返回码表值
     */
    public final static String SUCCESS_CODE = "1";// 成功返回码表值

    //1开头为调用接口类异常
    /**
     * 非法参数
     */
    public final static String ERROR_CODE100 = "100";// 非法参数
    /**
     * 非法操作
     */
    public final static String ERROR_CODE101 = "101";// 非法操作
    /**
     * 请求无效
     */
    public final static String ERROR_CODE102 = "102";// 请求无效
    /**
     * 禁止访问
     */
    public final static String ERROR_CODE103 = "103";// 禁止访问
    /**
     * 未实现
     */
    public final static String ERROR_CODE104 = "104";// 未实现

    /**
     * 无法找到资源
     */
    public final static String ERROR_CODE105 = "105";// 无法找到资源
    /**
     * 资源被禁止
     */
    public final static String ERROR_CODE106 = "106";// 资源被禁止
    /**
     * 网管错误
     */
    public final static String ERROR_CODE107 = "107";// 网管错误
    /**
     * 未登陆
     */
    public final static String ERROR_CODE108 = "108";// 未登陆
    /**
     * 无权限
     */
    public final static String ERROR_CODE109 = "109";// 无权限

    /**
     * 网络连接异常
     */
    public final static String ERROR_CODE110 = "110";// 网络连接异常
    /**
     * 参数太少
     */
    public final static String ERROR_CODE111 = "111";// 参数太少
    /**
     * 参数错误
     */
    public final static String ERROR_CODE112 = "112";// 参数错误
    /**
     * 参数为空
     */
    public final static String ERROR_CODE113 = "113";// 参数为空
    /**
     * JSON解析异常
     */
    public final static String ERROR_CODE114 = "114";// JSON解析异常
    /**
     * JSON匹配异常
     */
    public final static String ERROR_CODE115 = "115";// JSON匹配异常
    /**
     * 数据不存在
     */
    public final static String ERROR_CODE116 = "116";// 数据不存在
    /**
     * 手机号码格式不正确
     */
    public final static String ERROR_CODE117 = "117";// 手机号码格式不正确
    /**
     * 操作过频繁
     */
    public final static String ERROR_CODE118 = "118";// 操作过频繁

    /**
     * 服务器内部对象转换异常
     */
    public final static String ERROR_CODE119 = "119";//服务器内部对象转换异常

    /**
     * 与数据库交换异常
     */
    public final static String ERROR_CODE120 = "120";// 与数据库交换异常

    /**
     * 手机号码不正确或已存在
     */
    public final static String ERROR_CODE121 = "121";// 手机号码不正确
    /****
     * 不能邀请添加自己为好友
     */
    public final static String ERROR_CODE122 = "122";// 不能邀请添加自己为好友
    /****
     * 邮箱不正确或已存在
     */
    public final static String ERROR_CODE123 = "123";// 邮箱不正确
    /****
     * 您所分享的对象不存在
     */
    public final static String ERROR_CODE124 = "124";//您所分享的对象不存在


    /**
     * 类型转换失败
     */
    public final static String ERROR_CODE125 = "125";

    /**
     * 无申请优惠码权限
     */
    public final static String ERROR_CODE126 = "126";

    /**
     * 无效优惠码
     */
    public final static String ERROR_CODE127 = "127";

    /**
     * 该用户已经创建过优惠码
     */
    public final static String ERROR_CODE128 = "128";

    /**
     * 审核中不能编辑
     */
    public final static String ERROR_CODE129 = "129";

    /**
     * 该账号未绑定手机
     */
    public final static String ERROR_CODE130 = "130";



    public static String[] values1 = {"非法参数", "非法操作", "请求无效", "禁止访问", "未实现",
            "无法找到资源", "资源被禁止", "网管错误", "未登陆", "无权限",
            "系统繁忙，请稍后再试", "参数太少", "参数错误", "参数为空", "JSON解析异常", "JSON匹配异常", "数据不存在", "手机号码格式不正确", "操作过频繁",
            "服务器内部对象转换异常", "与数据库交换异常", "手机号码不正确或已存在", "不能邀请添加自己为好友", "邮箱不正确或已存在", "您所分享的对象不存在", "类型转换失败", "无申请优惠码权限", "无效优惠码", "该用户已经创建过优惠码", "审核中不能编辑","该账号未绑定手机"};


    //2开头为公共类业务异常
    /**
     * 业务逻辑错误(具体错误信息需另外设置)
     */
    public final static String ERROR_CODE200 = "200";// 业务逻辑错误(具体错误信息需另外设置)
    /**
     * 密码错误
     */
    public final static String ERROR_CODE201 = "201";// 密码错误
    /**
     * 验证码错误
     */
    public final static String ERROR_CODE202 = "202";// 验证码错误
    /**
     * 不能重复分享
     */
    public final static String ERROR_CODE203 = "203";// 不能重复分享
    /**
     * 手机或者邮箱已存在
     */
    public final static String ERROR_CODE204 = "204";// 手机或者邮箱已存在
    /**
     * 发送失败
     */
    public final static String ERROR_CODE205 = "205";// 发送失败
    /**
     * 上传目录异常
     */
    public final static String ERROR_CODE206 = "206";// 上传目录异常
    /**
     * 上传文件失败
     */
    public final static String ERROR_CODE207 = "207";// 上传文件失败
    /**
     * 文件类型不正确
     */
    public final static String ERROR_CODE208 = "208";// 文件类型不正确
    /**
     * 用户不存在
     */
    public final static String ERROR_CODE209 = "209";// 用户不存在
    /**
     * 旧密码输入错误
     */
    public final static String ERROR_CODE210 = "210";// 旧密码输入错误
    /**
     * 您已经申请加入该好友
     */
    public final static String ERROR_CODE211 = "211";// 您已经申请加入该好友
    /**
     * 不能加自己为好友
     */
    public final static String ERROR_CODE212 = "212";// 不能加自己为好友
    /**
     * 账号未激活
     */
    public final static String ERROR_CODE213 = "213";// 账号未激活
    /**
     * 验证码已过期
     */
    public final static String ERROR_CODE214 = "214";// 验证码已过期
    /**
     * 你们已经是好友
     */
    public final static String ERROR_CODE215 = "215";// 你们已经是好友
    /**
     * 你输入的账号/密码错误，请重新输入
     */
    public final static String ERROR_CODE216 = "216";// 你输入的账号/密码错误，请重新输入
    /**
     * 该用户已存在
     */
    public final static String ERROR_CODE217 = "217";// 该用户已存在
    /**
     * 激活链接已过期，请重新获取
     */
    public final static String ERROR_CODE218 = "218";// 激活链接已过期，请重新获取

    /**
     * 新旧密码不一致
     */
    public final static String ERROR_CODE219 = "219";// 新旧密码不一致

    /**
     * 输入的手机/邮箱已经被使用
     */
    public final static String ERROR_CODE220 = "220";// 输入的手机/邮箱已经被使用

    /**
     * 账户已经被激活,无需再次激活
     */
    public final static String ERROR_CODE221 = "221";// 账户已经被激活,无需再次激活
    /***
     * 账号已绑定
     */
    public final static String ERROR_CODE222 = "222";// 账号已绑定,无需再次绑定

    /***
     * 文件不存在
     */
    public final static String ERROR_CODE223 = "223";

    /**
     * 手机已经被使用
     */
    public final static String ERROR_CODE224 = "224";

    /**
     * 文件下载异常
     */
    public final static String ERROR_CODE225 = "225";

    /**
     * 该手机号已经被绑定
     */
    public final static String ERROR_CODE226 = "226";

    /**
     * 发送失败，短信余额不足
     */
    public final static String ERROR_CODE227 = "227";

    public static String[] values2 = {"业务逻辑错误", "密码错误", "验证码错误", "不能重复分享", "手机或者邮箱已存在",
            "发送失败", "上传目录异常", "上传文件失败", "文件类型不正确", "用户不存在",
            "旧密码输入错误", "您已经申请加入该好友", "不能加自己为好友", "账号未激活", "验证码已过期",
            "你们已经是好友", "你输入的账号/密码错误，请重新输入", "该用户已存在", "激活链接已过期，请重新获取", "新旧密码不一致",
            "输入的手机/邮箱已经被使用", "账户已经被激活,无需再次激活", "账号已绑定", "文件不存在", "手机已经被使用", "文件下载异常","该手机号已经被绑定",
            "发送失败，短信余额不足"};

    //3开头为圈子用户类业务异常
    /**
     * 下联验证错误
     */
    public final static String ERROR_CODE300 = "300";// 下联验证错误
    /**
     * 您已是该圈子成员
     */
    public final static String ERROR_CODE301 = "301";// 您已是该圈子成员
    /**
     * 您已关注过该圈子
     */
    public final static String ERROR_CODE302 = "302";// 您已关注过该圈子
    /**
     * 需要先更换负责人
     */
    public final static String ERROR_CODE303 = "303";
    /**
     * 该圈子不能升级
     */
    public final static String ERROR_CODE304 = "304";// 无升级权限
    /**
     * 您已经存在高级圈
     */
    public final static String ERROR_CODE305 = "305";// 您已经存在高级圈
    /**
     * 该圈子不能降级
     */
    public final static String ERROR_CODE306 = "306";// 无降级权限
    /**
     * 圈主才有权限
     */
    public final static String ERROR_CODE307 = "307";// 圈主才有权限
    /**
     * 超过修改权限
     */
    public final static String ERROR_CODE308 = "308";// 超过修改权限
    /**
     * 该成员已存在高级圈
     */
    public final static String ERROR_CODE309 = "309";// 该成员已存在高级圈
    /**
     * 管理圈成员不能退出非管理圈
     */
    public final static String ERROR_CODE310 = "310";// 管理圈成员不能退出非管理圈

    /**
     * 负责人不能退出
     */
    public final static String ERROR_CODE311 = "311";

    /**
     * 邀请码错误
     */
    public final static String ERROR_CODE312 = "312";

    /**
     * 该用户已设职级
     */
    public final static String ERROR_CODE313 = "313";

    /**
     * 该企业已存在
     */
    public final static String ERROR_CODE314 = "314";

    /**
     * 你们已经是合作伙伴
     */
    public final static String ERROR_CODE315 = "315";

    /**
     * 只能创建一个团队
     */
    public final static String ERROR_CODE316 = "316";

    /**
     * 该岗位已经存在负责人
     */
    public final static String ERROR_CODE317 = "317";


    /**
     * 无效优惠码
     */
    public final static String ERROR_CODE318 = "318";

    /**
     * 该岗位下只能有一个负责人
     */
    public final static String ERROR_CODE319 = "319";

    /**
     * 该合作伙伴未设置对接人
     */
    public final static String ERROR_CODE320 = "320";

    /**
     * 该团队未设团队负责人
     */
    public final static String ERROR_CODE321 = "321";

    /**
     * 请调整该部门下的员工至新部门后再删除该部门！
     */
    public final static String ERROR_CODE322 = "322";


    /**
     * 请调整该岗位下的员工至新岗位后再删除该岗位！
     */
    public final static String ERROR_CODE323 = "323";

    public static String[] values3 = {"下联验证错误", "您已是该圈子成员", "您已关注过该圈子", "需要先更换负责人", "该圈子不能升级",
            "您已经存在高级圈", "该圈子不能降级", "负责人才有权限", "超过修改权限", "该成员已存在高级圈", "管理圈成员不能退出非管理圈",
            "负责人不能退出", "邀请码错误", "该用户已设职级", "该企业已存在", "您们已经是合作伙伴", "只能创建一个团队", "该岗位已经存在负责人", "无效优惠码", "该岗位下只能有一个负责人", "该合作伙伴未设置对接人", "该团队未设团队负责人","请调整该部门下的员工至新部门后再删除该部门！","请调整该岗位下的员工至新岗位后再删除该岗位！"};

    //4开头为活动类业务异常
    /**
     * 您已进行过投票
     */
    public final static String ERROR_CODE400 = "400";// 您已进行过投票
    /**
     * 您已参加活动
     */
    public final static String ERROR_CODE401 = "401";// 您已参加活动
    /**
     * 已经邀请过他/她参加活动
     */
    public final static String ERROR_CODE402 = "402";// 已经邀请过他/她参加活动
    /**
     * 您已经点赞过
     */
    public final static String ERROR_CODE403 = "403";// 您已经点赞过
    /**
     * 未到签到时间
     */
    public final static String ERROR_CODE404 = "404";// 未到签到时间
    /**
     * 您已签到
     */
    public final static String ERROR_CODE405 = "405";// 您已签到
    /**
     * 活动已满员
     */
    public final static String ERROR_CODE406 = "406";// 活动已满员

    /**
     * 无创建活动权限
     */
    public final static String ERROR_CODE407 = "407";// 无创建活动权限

    /**
     * 不能删除自己
     */
    public final static String ERROR_CODE408 = "408";// 不能删除自己

    /**
     * 投票已结束
     */
    public final static String ERROR_CODE409 = "409";

    /**
     * 投票截止时间不能小于当前时间
     */
    public final static String ERROR_CODE410 = "410";

    /**
     * 开始时间不能小于当前时间
     */
    public final static String ERROR_CODE411 = "411";

    /**
     * 该动态已被删除
     */
    public final static String ERROR_CODE412 = "412";

    /**
     * 活动发起者不能取消参加
     */
    public final static String ERROR_CODE413 = "413";

    /**
     * 该系列您已经报满
     */
    public final static String ERROR_CODE414 = "414";

    /**
     * 未到报名时间
     */
    public final static String ERROR_CODE415 = "415";// 未到报名时间

    /**
     * 您已经发布该结果
     */
    public final static String ERROR_CODE416 = "416";

    /**
     * 已过报名时间
     */
    public final static String ERROR_CODE417 = "417";

    /**
     * 无参加权限
     */
    public final static String ERROR_CODE418 = "418";

    /**
     * 入选人数超额
     */
    public final static String ERROR_CODE419 = "419";

    /**
     * 年龄不在范围之内
     */
    public final static String ERROR_CODE420 = "420";


    public static String[] values4 = {"您已进行过投票", "您已参加活动", "已经邀请过他/她参加活动", "您已经点赞过", "未到签到时间",
            "您已签到", "活动已满员", "无创建活动权限", "不能删除自己",
            "投票已结束", "投票截止时间不能小于当前时间", "开始时间不能小于当前时间", "该动态已被删除", "活动发起者不能取消参加", "该系列您已经报满", "未到报名时间", "您已经发布该结果", "已过报名时间", "无参加权限", "入选人数超额", "年龄不在范围之内"};

    /**
     * 任务已经提交
     */
    public final static String ERROR_CODE500 = "500";

    /**
     * 设置未完成
     */
    public final static String ERROR_CODE501 = "501";

    /**
     * 无模板
     */
    public final static String ERROR_CODE502 = "502";

    /**
     * 任务已过期
     */
    public final static String ERROR_CODE503 = "503";

    /**
     * 任务不存在
     */
    public final static String ERROR_CODE504 = "504";

    /**
     * 找不到执行人
     */
    public final static String ERROR_CODE505 = "505";

    /**
     * 不能删除节点上表单项
     */
    public final static String ERROR_CODE506 = "506";

    /**
     * 该流程未定义表单
     */
    public final static String ERROR_CODE507 = "507";

    /**
     *  任务已撤销或修改
     */
    public final static String ERROR_CODE508 = "508";


    public static String[] values5 = {"任务已经提交", "设置未完成", "无模板", "任务已过期", "任务不存在", "找不到执行人", "不能删除节点上表单项", "该流程未定义表单", "任务已撤销或修改", "", "", "", "", "", "", ""};


    /**
     * 服务已下架
     */
    public final static String ERROR_CODE600 = "600";

    /**
     * 服务已上架
     */
    public final static String ERROR_CODE601 = "601";

    public static String[] values6 = {"服务已下架", "服务已上架", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};


    /**
     * 标签已存在
     */
    public final static String ERROR_CODE700 = "700";

    /**
     * 标签名称已存在
     */
    public final static String ERROR_CODE701 = "701";

    /**
     * 标签使用中
     */
    public final static String ERROR_CODE702 = "702";

    public static String[] values7 = {"标签已存在", "标签名称已存在", "标签使用中", "", "", "", "", "", "", "", "", "", "", "", "", ""};


    //10开头为返回成功码
    /**
     * 已提交审核
     */
    public final static String SUCCESS_CODE1000 = "1000";// 已提交审核成功返回码表值

    /**
     * 发布成功
     */
    public final static String SUCCESS_CODE1001 = "1001";// 发布成功返回码表值

    /**
     * 撤销成功
     */
    public final static String SUCCESS_CODE1002 = "1002";// 撤销成功返回码表值

    /**
     * 上架成功
     */
    public final static String SUCCESS_CODE1003 = "1003";// 上架成功返回码表值

    /**
     * 下架成功
     */
    public final static String SUCCESS_CODE1004 = "1004";// 下架成功返回码表值

    /**
     * 归档成功
     */
    public final static String SUCCESS_CODE1005 = "1005";// 归档成功返回码表值

    /**
     * 审核流程变更，已提交审核，可在首页中查看相关进度
     */
    public final static String SUCCESS_CODE1006 = "1006";

    /**
     * 审核流程变更，发布成功，可在首页中进行查看
     */
    public final static String SUCCESS_CODE1007 = "1007";

    /**
     * 审核流程变更，无需审核，撤销成功
     */
    public final static String SUCCESS_CODE1008 = "1008";

    public static String[] values10 = {"已提交审核，可在首页中查看相关进度", "发布成功，可在首页中进行查看", "撤销成功","上架成功","下架成功","归档成功",
            "审核流程变更，已提交审核，可在首页中查看相关进度","审核流程变更，发布成功，可在首页中进行查看","审核流程变更，无需审核，撤销成功",""};

    public static Map<String, Object> resultMsg = new HashMap<String, Object>();

    static {
        // put error message in map
        for (int i = 0; i <= 70; i++) {
            String code = "0";
            if (i < 10) {
                code = "0" + i;
            } else {
                code = i + "";
            }
            if (i < values1.length) {
                resultMsg.put("1" + code, values1[i]);
            }
            if (i < values2.length) {
                resultMsg.put("2" + code, values2[i]);
            }
            if (i < values3.length) {
                resultMsg.put("3" + code, values3[i]);
            }
            if (i < values4.length) {
                resultMsg.put("4" + code, values4[i]);
            }
            if (i < values5.length) {
                resultMsg.put("5" + code, values5[i]);
            }
            if (i < values6.length) {
                resultMsg.put("6" + code, values6[i]);
            }
            if (i < values7.length) {
                resultMsg.put("7" + code, values7[i]);
            }
            if (i < values10.length) {
                resultMsg.put("10" + code, values10[i]);
            }
        }

    }

    /**
     * 取错误消息
     *
     * @param code 错误代码
     * @return
     * @author:kaiqiang.wu
     * @time:2015年11月24日上午10:37:13
     */
    public static String getMsg(String code) {
        Object msgObj = resultMsg.get(code);
        return msgObj != null ? msgObj.toString() : "";
    }


    /**
     * 取错误消息,若取不到，返回 网络超时
     *
     * @param zde
     * @return
     * @author:kaiqiang.wu
     * @time:2015年11月24日上午10:41:20
     */
    public static String getMsg(SeventeenkouException zde) {
        String code = zde != null ? zde.getCode() : BaseCode.ERROR_CODE110;
        String errorMessage = "";
        //业务逻辑错误时，直接返回直接异常，因而抛出此异常时，注意此异常消息内容
        if (BaseCode.ERROR_CODE200.equals(code)) {
            errorMessage = zde.getMessage();
        } else {
            errorMessage = getMsg(code);
        }
        return errorMessage;
    }

    /**
     * 取错误消息,若取不到，返回网络超时
     *
     * @param ex
     * @return
     * @author:kaiqiang.wu
     * @time:2015年11月24日上午10:46:55
     */
    public static String getMsg(Exception ex) {
        SeventeenkouException zde = getZdnstException(ex);
        String errorMessage = getMsg(zde);
        return errorMessage;
    }

    /**
     * 取异常
     *
     * @param ex
     * @return
     * @author:kaiqiang.wu
     * @time:2015年11月24日上午10:55:10
     */
    public static SeventeenkouException getZdnstException(Exception ex) {
        SeventeenkouException zde = null;
        if (ex instanceof SeventeenkouException) {
            zde = (SeventeenkouException) ex;
        } else {
            zde = new SeventeenkouException(BaseCode.ERROR_CODE110, ex);
        }
        return zde;
    }


    /**
     * 取详情错误消息，包含e.getMessage(前面带异常代码),若取不到，返回网络超时
     *
     * @param ex
     * @return
     * @author:kaiqiang.wu
     * @time:2015年11月24日上午10:46:55
     */
    public static String getDetailMsg(Exception ex) {
        SeventeenkouException zde = getZdnstException(ex);
        String errorMessage = zde.getCode() + StringUtils.BLANK + getMsg(zde.getCode()) + StringUtils.BLANK + zde.getMessage();
        return errorMessage;
    }

    /**
     * 判断是否指定的异常
     * @param zde
     * @param code
     * @return
     */
    public static boolean isException(SeventeenkouException zde,String code) {
        if(zde == null || code == null){
            return false;
        }
        if(code.equals(zde.getCode())){
            return true;
        }else{
            return false;
        }
    }

}
