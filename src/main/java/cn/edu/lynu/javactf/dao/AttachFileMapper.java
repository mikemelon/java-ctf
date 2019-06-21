package cn.edu.lynu.javactf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.lynu.javactf.model.AttachFile;

@Mapper
public interface AttachFileMapper {
	
	@Select("SELECT * FROM attachfile")
	List<AttachFile> getAllAttachFiles();
	
	@Select("SELECT * FROM attachfile WHERE ID=#{id}")
	AttachFile getAttachFileById(@Param("id") int id);
	
	@Delete("DELETE attachfile WHERE ID = #{id}")
	int deleteAttachFileById(@Param("id")int id);
	
	@Insert("INSERT INTO attachfile(challenge_id,filename, filelocation, uploadtime) VALUES ( #{attachfile.challenge.id}, #{attachfile.fileName}, #{attachfile.fileLocation), #{attachfile.uploadTime}")
	int insertAttachFile(@Param("attachfile")AttachFile attachfile);
	
	@Update("UPDATE attachfile SET challenge_id={attachfile.challenge.id}, filename=#{attachfile.fileName}, filelocation=#{attachfile.fileLocation}, uploadtime=#{attachfile.uploadTime} WHERE ID = #{attachfile.id}")
	int updateAttachFile(@Param("attachfile")AttachFile attachfile);
}
