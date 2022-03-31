package t3_DBTest_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DAO(Data Access Object)
public class DBTest {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	public DBTest() {
		try {
			//1. JDBC드라이버 검색.
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 데이터베이스 연결
			String url = "jdbc:mysql://localhost:3306/javagreen";
			String user = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);	//커넥션 객체.. conn이란 이름을 부여.. 데이터베이스 url, 아이디, 비번 입력해서 연결하기.
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~");
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패..");
			System.exit(0);
		}
	}

	//데이터베이스안의 테이블 검색
	public int searchTest(String name, String flag) {		//Run객체에서 불러다 사용할 메소드..
		int res = 0;
		try {
			stmt = conn.createStatement(); 		//데이터베이스에서 객체를 핸들링할 statement 객체 생성.. (필드에 지역변수로 선언했다.)
			sql = "select * from aaa where name='"+name+"'";	//실행할 명령어를 sql에 담기.. (필드에 지역변수로 선언했다.)
			rs = stmt.executeQuery(sql);	//executeQuery 은 검색할때.. update는 그외 수정할때.. 검색해서 갖고온것을 레코드 단위로 수행하는 rs에 담기.(필드에 지역변수로 선언했다.)
			//ResultSet : 데이터베이스의 테이블의 레코드 단위로 수행.
			//rs는 현재 레코드포인트가 BOF에 있는 상태.. 그래서 next()로 한줄 내려야 한다.
			
			if(rs.next()) {		//자료가 있으면 true, 없으면 false
				if(flag.equals("s")) {
					name = rs.getString("name"); 	//읽어올땐 get , 필드의 타입이 String 이면 getString, ()안에는 필드명 적기.
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					String joinday = rs.getString("joinday");
					System.out.println("=========================");
					System.out.println("성명 : " + name);
					System.out.println("나이 : " + age);
					System.out.println("성별 : " + gender);
					System.out.println("가입일 : " + joinday);
					System.out.println("=========================");
				}
				else {
					res = 1;
				}
			}
			else {
				System.out.println("=========================");
				System.out.println(name + "을(를) 찾지 못했습니다.");
				System.out.println("=========================");
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 :" + e.getMessage() );
		}finally {
			rsClose();
		}
		return res;
	}
	
	//stmt객체 Close
	public void stmtClose() {
		if(stmt != null) {
			try {
				stmt.close();
			}catch (SQLException e) {}
		}
	}
	
	//rs객체 close
	public void rsClose() {
		if(stmt != null) {
			try {
				rs.close();
				stmtClose();
			}catch (SQLException e) {}
		}
	}
	
	// 데이터베이스객체 Close
	public void dbClose() {
		try {
			conn.close();
		} catch (Exception e) {}	//  close 할땐 에러날일이 없어서 내용을 적지 않음.
	}

	//전체 조회 처리
	public void list() {
		try {
			stmt = conn.createStatement();	//Statement 생성
			sql = "select * from aaa order by name";	//명령어 sql에 담기.
			rs = stmt.executeQuery(sql);	//검색결과  rs에 담기.
			
			System.out.println("=================================================");
			System.out.println("성 명\t 나 이\t 성 별\t 가입 일자");
			System.out.println("-------------------------------------------------");

			while(rs.next()) {
				String gender = "";
				if(rs.getString("gender").equals("m")) {
					gender="남자";
				}
				else {
					gender="여자";
				}
				System.out.println(rs.getString("name") + "\t " + rs.getInt("age") + "\t " + gender + "\t " + rs.getString("joinday").substring(0,10));
			}
			
			System.out.println("=================================================");
			
		} catch (SQLException e) {
			System.out.println("SQL오류 :" + e.getMessage() );
		}finally {
			rsClose();
		}
	}
	
	// 자료 등록처리
	public void input(String name, int age, String gender, String joinday) {
		try {
			stmt = conn.createStatement();	
			sql = "insert into aaa values ('"+name+"','"+age+"','"+gender+"','"+joinday+"')";	
			stmt.executeUpdate(sql);	//읽어오는 것이 아닌 저장시키는 것이기 때문에 따로 변수에 담을 필요가 없다.
		} catch (Exception e) {
			System.out.println("SQL오류 :" + e.getMessage() );
		}finally {
			stmtClose();
		}
	}

	//나이 수정
	public void update(int no, int age, String name) {
		try {
			stmt = conn.createStatement();
			sql = "update aaa set age = "+age+" where name = '"+name+"' ";
			stmt.executeUpdate(sql);
			System.out.println("수정완료!");
		} catch (SQLException e) {
			System.out.println("SQL오류 :" + e.getMessage() );
		}finally {
			stmtClose();
		}
	}

	//성별 or 가입일 수정
	public void update(int no, String imsi, String name) {
		try {
			stmt = conn.createStatement();
			if(no == 2) {		//성별수정
				String gender;
				if(imsi.equals("1")) {
					gender = "m";
				}else {
					gender = "f";
				}
				sql = "update aaa set gender = '"+gender+"' where name = '"+name+"'";
//				stmt.executeUpdate(sql);
//				System.out.println("수정완료!");
			}
			else {	//가입일수정
				sql = "update aaa set joinday = '"+imsi+"' where name = '"+name+"'";
			}
			stmt.executeUpdate(sql);
			System.out.println("수정완료!");
		} catch (SQLException e) {
			System.out.println("SQL오류 :" + e.getMessage() );
		}finally {
			stmtClose();
		}
	}

	// 자료 삭제처리
	public void delete(String name) {
		try {
			stmt = conn.createStatement();
			sql = "delete from aaa where name = '"+name+"'";
			stmt.executeUpdate(sql);
			System.out.println("삭제완료!");
		} catch (SQLException e) {
			System.out.println("SQL오류 :" + e.getMessage() );
		}finally {
			stmtClose();
		}
	}
}
