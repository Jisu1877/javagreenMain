package t5_DBTest_VO2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTestDAO {
	Connection conn = null;
//	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	DBTestVO vo = null;
	
	// 처음 DAO생성시에 Database 연결한다.
	public DBTestDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javagreen";
			String user = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~~");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패~~~");
		}
	}
	
	// Database Close
	public void dbClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	// preparedstatement객체 Close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
	
	// resultset객체 close
	public void rsClose() {
		try {
			if(rs != null) {
				rs.close();
				pstmtClose();
			}
		} catch (Exception e) {}
	}

	// 자료 등록처리하기
	public void input(DBTestVO vo) {
		try {
//			stmt = conn.createStatement();
//			sql = "insert into dbtest values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getJoinday()+"')";
//			stmt.executeUpdate(sql);
			// Statement는 sql문 안에 직접 값을 주기 때문에 보안상 문제가 있다. 그래서 PreparedStatement 가 나왔다.
			
			// 데이터베이스의 테이블 구조와 변수들을 이미 외우거나 기록해뒀다는 전제하에.. 
			sql = "insert into dbtest values (default,?,?,?,?)";	//idx만 입력받지 않아도 되는 것이라 default를 준다.
			pstmt = conn.prepareStatement(sql);	//먼저 sql문을 만들어놓고 PreparedStatement 생성할때 sql을 넘기기.
			//현재는 값을 모른채 껍데기만 가지고 생성한 상태.. pstmt에 넣어줘야한다.
			pstmt.setString(1, vo.getName());	//pstmt.setString : 입력할 데이터 타입에 맞춰주고, (1, vo.getName()); -> 1은 첫번째 ? 란 뜻. 뒤에는 넣어줄 데이터.
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getJoinday());
			pstmt.executeUpdate();	//이미 생성할때 sql문을 넣어줬기때문에 executeUpdate() 에는 넣지 않는다. : Statement와의 차이점..
			System.out.println(vo.getName() + " 님 자료가 등록되었습니다.");
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}

	// 전체자료 검색하기
	public ArrayList<DBTestVO> list() {
		ArrayList<DBTestVO> vos = new ArrayList<DBTestVO>();
		try {
			sql = "select * from dbtest order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DBTestVO vo = new DBTestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setJoinday(rs.getString("joinday"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	// 개별자료 검색하기
	public DBTestVO search(String name) {
		vo = new DBTestVO();
		try {
//			sql = "select * from dbtest where name = '"+name+"'";
			sql = "select * from dbtest where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
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

	// 자료 삭제처리하기
	public int delete(String name) {
		int res = 0;
		try {
			sql = "select * from dbTest where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();		
			//.executeQuery() 가 sql를 실행할때 오류가 날 수 있기 때문에, 143번을 위해서 try-catch문으로 감싸준 것.
			//따라서 142라인까지는 무조건 실행되기때문에 finally에서 pstmt를 닫아줘야 했던 것이다.
			if(rs.next()) {
				rsClose();		//위에서 검색용으로 prepareStatement 사용한것을 닫아주기..!(사실은 pstmt만 닫아줘도 rs도 같이 닫힌다. 하지만 더 정확히 하기 위해 pstmtClose()를 담고있는 rsClose()를 부른것.)
				sql = "delete from dbTest where name = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.executeUpdate();	//여기서 발생할 수 있는 sql오류도 아래 catch문에서 잡아준다.
				res = 1;
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 회원자료 수정처리...(검색후 수정처리한다.)
	public DBTestVO UpdateSearch(int idx) {
		vo = new DBTestVO();
		try {
			sql = "select * from dbTest where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
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

	// 실제 자료내용 수정처리하기
	public void updateProcess(DBTestVO vo) {
		try {
			sql = "update dbTest set name=?, age= ?, gender= ?, joinday= ? where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getJoinday());
			pstmt.setInt(5, vo.getIdx());
			pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
}
