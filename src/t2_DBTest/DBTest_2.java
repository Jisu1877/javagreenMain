package t2_DBTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DAO(Data Access Object)
public class DBTest_2 {
	Connection conn = null;
	String sql = "";
	
	public DBTest_2() {
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
	public void searchTest() {		//Run객체에서 불러다 사용할 메소드..
		try {
			Statement stmt = conn.createStatement(); 		//데이터베이스에서 객체를 핸들링할 statement 객체 생성.. (필드에 지역변수로 선언했다.)
			sql = "select * from aaa where name='홍길동'";	//실행할 명령어를 sql에 담기.. (필드에 지역변수로 선언했다.)
			ResultSet rs = stmt.executeQuery(sql);	//executeQuery 은 검색할때.. update는 그외 수정할때.. 검색해서 갖고온것을 레코드 단위로 수행하는 rs에 담기
			//ResultSet : 데이터베이스의 테이블의 레코드 단위로 수행.
			//rs는 현재 레코드포인트가 BOF에 있는 상태.. 그래서 next()로 한줄 내려야 한다.
			
			if(rs.next()) {		//자료가 있으면 true, 없으면 false
//				System.out.println("홍길동을 찾았다.");
				String name = rs.getString("name"); 	//읽어올땐 get , 필드의 타입이 String 이면 getString, ()안에는 필드명 적기.
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
				System.out.println("=========================");
				System.out.println("홍길동을 찾지 못했습니다.");
				System.out.println("=========================");
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 :" + e.getMessage() );
		}
	}
}
