package t4_DBTest_VO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTestDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	DBTestVO vo = null;
	
	//처음 DAO(다오) 생성시에 Database 연결한다...
	public DBTestDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javagreen";
			String user = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}
	}
	
	// Database Close
	public void dbClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	//statement 객체 Close
	public void stmtClose() {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {}
	}
	
	//resultset 객체 Close
	public void rsClose() {
		try {
			if(rs != null) {
				rs.close();
				stmtClose();
			}
		} catch (Exception e) {}
	}
	
	// 자료 등록처리하기
	public void input(DBTestVO vo) {
		try {
			stmt = conn.createStatement();
			sql = "insert into dbtest values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getJoinday()+"')";
			stmt.executeUpdate(sql);
			System.out.println(vo.getName() + "님 자료가 등록되었습니다.");
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
	}
	
	// 전체 자료 검색하기
	public ArrayList<DBTestVO> list() {
		ArrayList<DBTestVO> vos = new ArrayList<DBTestVO>();
		try {
			stmt = conn.createStatement();
			sql = "select * from dbtest order by idx desc";		//최근자료를 먼저 보여주겠다.
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				DBTestVO vo = new DBTestVO();		
				//while문이 돌때마다 새로운 vo 객체를 생성해야한다. 
				//모든 레코드들이 구조는 같지만 다른 vo에 저장되서 ArrayList에 담겨야 한다.
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setJoinday(rs.getString("joinday"));
				
				vos.add(vo);	//vo객체 한개가 ArrayList에 저장됨..
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	//개별 자료 검색
	public DBTestVO search(String name) {
		vo = new DBTestVO();
		try {
			stmt = conn.createStatement();
			sql = "select * from dbtest where name = '"+name+"' ";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setJoinday(rs.getString("joinday"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	public void update(int idx, String imsi, int no) {
		try {
			stmt = conn.createStatement();
			if(no == 1) {
				sql = "update dbtest set name = '"+imsi+"' where idx = "+idx;
				stmt.executeUpdate(sql);
			}else if(no == 2) {
				Integer imsiInt = new Integer(imsi);
				sql = "update dbtest set age = '"+imsiInt+"' where idx = "+idx;
				stmt.executeUpdate(sql);
			}else if(no == 3) {
				sql = "update dbtest set gender = '"+imsi+"' where idx = "+idx;
				stmt.executeUpdate(sql);
			}else if(no == 4) {
				sql = "update dbtest set joinday = '"+imsi+"' where idx = "+idx;
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
	}

	public DBTestVO show(int idx) {
		DBTestVO vo = new DBTestVO();
		try {
			stmt = conn.createStatement();
			sql = "select * from dbtest where idx = "+idx+" ";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setJoinday(rs.getString("joinday"));
			}
			else {
				vo = null;
			}
		}catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	public void delete(int idx) {
		try {
			stmt = conn.createStatement();
			sql = "delete from dbtest where idx = " + idx;
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
	}
}
