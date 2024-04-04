package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.iolist.models.IolistVO;

public interface IolistDao {
	
//	@Select("SELECT * FROM tbl_iolist "
//			+ "ORDER BY io_date DESC, io_time DESC")
	public List<IolistVO> selectAll();
	
//	@Select("SELECT * FROM tbl_iolist "
//			+ " WHERE io_seq = #{io_seq}")
	public IolistVO findBySeq(Long seq);
	
	public int insertOrUpdate(IolistVO vo);
	
	public int insert(IolistVO vo);
	public int update(IolistVO vo);
	
	@Delete("DELETE FROM tbl_iolist WHERE io_seq = #{io_seq}")
	public int delete(Long seq);
	
	public void create_iolist_table(String dumy);

}
