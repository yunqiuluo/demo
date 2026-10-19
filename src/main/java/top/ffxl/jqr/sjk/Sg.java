package top.ffxl.jqr.sjk;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface Sg {
    @Select("select * from sg where name = #{name} and user_openid = #{openid}")
    Map<String,Object> usersj(String name,String openid);

    @Delete("delete from sg where name IS NULL and #{now} - time >= 1800")
    void del(long now);

    @Insert("insert into sg(uid,user_openid,time) value (#{uid},#{user_openid},#{now})")
    void set(String uid,String user_openid,long now);

    @Select("select * from sg where uid = #{uid} and user_openid = #{openid}")
    Map<String,Object> get(String uid,String openid);

    @Update("update sg set name = #{name} where id = #{id} and user_openid = #{openid}")
    void update(String id,String name,String openid);

    @Update("update sg set mr = 0 where mr = 1 and user_openid = #{openid}")
    void update0Mr(String openid);

    @Update("update sg set mr = 1 where name = #{name} and user_openid = #{openid}")
    void update1Mr(String name,String openid);

    @Select("select * from sg where user_openid = #{openid} and mr = 1")
    Map<String,Object> getMr(String openid);

    @Select("select * from sg where id = #{id} and user_openid = #{openid}")
    Map<String,Object> geti(String id,String openid);

    @Select("select * from sg where user_openid = #{openid} and name IS NOT NULL order by id ")
    List<Map<String,Object>> arr(String openid);

    @Delete("delete from sg where name = #{name} and user_openid = #{openid}")
    void deluser(String openid,String name);

    @Select("select * from sg where uid = #{uid} and user_openid = #{openid} and name is not null")
    Map<String,Object> getnull(String uid,String openid);

    @Update("update sg set img = #{img} where uid = #{uid} and user_openid = #{openid}")
    void updateImg(String img,String uid,String openid);
}

