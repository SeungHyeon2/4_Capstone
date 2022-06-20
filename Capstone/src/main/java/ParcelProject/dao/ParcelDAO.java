package ParcelProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ParcelProject.vo.KeepRequest;

// DB parcel 테이블에 접근하는 DAO
public class ParcelDAO {
	private JdbcTemplate jdbcTemplate;

	public ParcelDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
//
//	public Student selectBySid(int sid) {
//		List<Student> results = jdbcTemplate.query("SELECT * FROM student WHERE SID = ?", new RowMapper<Student>() {
//			@Override
//			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student(rs.getInt("SID"), rs.getString("NAME"), rs.getString("PASSWORD"),
//						rs.getInt("GRADE"), rs.getString("SUBJECT"));
//				return student;
//			}
//		}, sid);
//
//		return results.isEmpty() ? null : results.get(0);
//
//	}

	public int insertParcel(KeepRequest keepRequest) {
		int result = jdbcTemplate.update(				
				"INSERT INTO parcelproject.parcel(name, phone, code) VAlUES(?, ?, ?)",
				keepRequest.getName(), keepRequest.getPhone(), keepRequest.getCode());
		return result;
	}

	public List<KeepRequest> selectParcel(KeepRequest keepRequest) {
		List<KeepRequest> results = jdbcTemplate.query("SELECT * FROM parcelproject.parcel",
				new RowMapper<KeepRequest>() {

					@Override
					public KeepRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						KeepRequest keepRequest = new KeepRequest(rs.getString("name"), rs.getString("phone"), rs.getString("code"));
						
						return keepRequest;
					}
			
		});
		return results;
	}
//	public Student selectBySidPassword(LoginRequest loginRequest) {
//		List<Student> results = jdbcTemplate.query("SELECT * FROM student WHERE SID = ? AND PASSWORD = ?",
//				new RowMapper<Student>() {
//					@Override
//					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Student student = new Student(rs.getInt("SID"), rs.getString("NAME"), rs.getString("PASSWORD"),
//								rs.getInt("GRADE"), rs.getString("SUBJECT"));
//						return student;
//					}
//				}, Integer.parseInt(loginRequest.getSid()), loginRequest.getPassword());
//
//		return results.isEmpty() ? null : results.get(0);
//
//	}

//
//	public static Student getWriter(int sid) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		Student student = new Student();
//		student.setSid(sid);
//		try {
//			student = sqlSession.selectOne("org.mybatis.persistence.StudentMapper.selectBySid", student);
//
//			return student;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return student;
//		} finally {
//			sqlSession.close();
//		}
//	}
}
