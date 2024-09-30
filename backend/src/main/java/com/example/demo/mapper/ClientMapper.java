package com.example.demo.mapper;

import com.example.demo.model.Client;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClientMapper {

    @Select("SELECT * FROM client WHERE cid = #{cid}")
    Client findById(int cid);

    @Select("SELECT * FROM client")
    List<Client> findAll();

    @Insert("INSERT INTO client (cid, Image, Cname, Password, phone_number, Email, Createtime, Ckind, test) " +
            "VALUES (#{cid}, #{image}, #{cname}, #{password}, #{phoneNumber}, #{email}, #{createTime}, #{ckind}, #{test})")
    void insert(Client client);

    @Update("UPDATE client SET Image=#{image}, Cname=#{cname}, Password=#{password}, phone_number=#{phoneNumber}, " +
            "Email=#{email}, Createtime=#{createTime}, Ckind=#{ckind}, test=#{test} WHERE cid=#{cid}")
    void update(Client client);

    @Delete("DELETE FROM client WHERE cid = #{cid}")
    void delete(int cid);
}