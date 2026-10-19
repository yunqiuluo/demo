package top.ffxl.jqr.onebotv11.sjk;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Insert("insert user(nickname,remark,user_id_qqbot) value (#{name},#{name},#{userid})")
    void setUser(String name,String userid);
    @Select("select * from user where user_id = #{id}")
    Map<String, Object> getUser(long id);
    @Insert("insert qun(group_name,group_id_qqbot) value (#{id},#{id})")
    void setQun(String id);
    @Insert("insert qunuser(group_id,nickname,card, user_id, join_time, last_sent_time,role) value (#{group_id},#{name},#{name},#{user_id},#{time},#{time},#{role})")
    void setQunuser(long group_id,String name, long user_id,String role, long time);
    @Insert("insert xx(time, group_id, user_id, message, raw_message, message_id_qqbot) value (#{time},#{group_id},#{user_id},#{message},#{message},#{id})")
    void setxx(long time, long group_id, long user_id, String message, String id);
    @Insert("insert xx(time, message_type,sub_type, user_id, message, raw_message, message_id_qqbot) value (#{time},'private','friend',#{user_id},#{message},#{message},#{id})")
    void setxxu(long time, long user_id, String message, String id);
    @Select("select * from qun where group_id_qqbot = #{id}")
    Map<String, Object> getQun(String id);
    @Select("select * from user where user_id_qqbot = #{id}")
    Map<String, Object> getUserQqbot(String id);
    @Select("select * from qunuser where group_id = #{group_id} and user_id = #{user_id}")
    Map<String, Object> getQunuser(long group_id, long user_id);
    @Delete("delete from xx where message_id_qqbot = #{m_id}")
    void delxx(long m_id);
    @Select("select user_id,nickname,remark from user")
    List<Map<String, Object>> getUserList();
    @Select("select group_id,group_name,member_count,max_member_count from qun")
    List<Map<String, Object>> getGroupList();
    @Update("update qun set member_count = #{rs} where group_id_qqbot = #{id}")
    void updMemberCount(int rs, String id);
    @Select("select * from qunuser where group_id = #{id}")
    List<Map<String, Object>> getQunuserrs(long id);
    @Select("select * from qun where group_id = #{id}")
    Map<String, Object> getQunId(long id);
    @Update("update qunuser set last_sent_time = #{time} where group_id = #{g_id} and user_id = #{u_id}")
    void updLastSentTime(long time, long g_id, long u_id);
    @Select("select group_id,user_id,nickname,card,sex,age,area,join_time,last_sent_time,level,role,unfriendly,card_changeable from qunuser where group_id = #{g_id} and user_id = #{u_id}")
    Map<String,Object> getGroupMemberInfo(long g_id, long u_id);
    @Select("select group_id,user_id,nickname,card,sex,age,area,join_time,last_sent_time,level,role,unfriendly,card_changeable from qunuser where group_id = #{g_id}")
    List<Map<String,Object>> getGroupMemberList(long g_id);
    @Select("select * from xx where group_id = #{g_id} and bot = 0 and time > #{now} - 300  order by time")
    List<Map<String, Object>> getxxList(long g_id,long now);
    @Select("select time,message_type,message_id,message,user_id from xx where message_id = #{m_id}")
    Map<String, Object> getXx(long m_id);
    @Select("select * from xx where message_id_qqbot = #{m_id_q}")
    Map<String, Object> getxxQ(String m_id_q);
    @Select("select group_id_qqbot from qun where group_id = #{g_id}")
    String getQungroup(long g_id);
    @Insert("insert xx(time, group_id, user_id, message, raw_message, message_id_qqbot,bot) value (#{time},#{group_id},112435483,#{message},#{message},#{id},1)")
    void setxxb(long time, long group_id, String message, String id);
    @Insert("insert xx(time, message_type,sub_type, user_id, message, raw_message, message_id_qqbot,bot) value (#{time},'private','friend',112435483,#{message},#{message},#{id},1)")
    void setxxub(long time, String message, String id);
    @Select("select user_id_qqbot from user where user_id = #{u_id}")
    String getUserid(long u_id);
    @Select("select * from xx where user_id = #{u_id} and bot = 0 and time > #{now} - 300 and message_type = 'private' order by time")
    List<Map<String, Object>> getxxuList(long u_id,long now);
    @Update("update user set qqid = #{qq} where user_id_qqbot = #{u_id_q}")
    void updateUserQqid(String qq, String u_id_q);
    @Update("update user set sgcs = sgcs + 1 where user_id = #{u_id_q}")
    void updateUserSgcs(long u_id_q);
    @Update("update user set sgcs = sgcs - 1 where user_id_qqbot = #{u_id_q}")
    void updateUserSgcsDec(String u_id_q);
}
