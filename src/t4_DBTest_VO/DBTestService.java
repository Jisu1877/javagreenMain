package t4_DBTest_VO;

import java.util.ArrayList;
import java.util.Scanner;

public class DBTestService {
	Scanner sc = new Scanner(System.in);
	DBTestDAO dao = new DBTestDAO();
	DBTestVO vo = new DBTestVO();

	int idx;
	String name;
	String age;
	String gender;
	String joinday;
	
	// 자료 등록.
	public void input() {
		System.out.print("성명 : "); vo.setName(sc.next());
		System.out.print("나이 : "); vo.setAge(sc.nextInt());
		System.out.print("성별 : "); vo.setGender(sc.next());
		System.out.print("가입 일자 : "); vo.setJoinday(sc.next());
		dao.input(vo);
	}
	
	// 개별자료 검색
	public void search() {
		String ans;
		boolean run = true;
		while(run) {
			System.out.print("검색할 성명을 입력하세요? => ");
			name = sc.next(); 
			vo = dao.search(name);
			System.out.println("vo : " + vo.toString());
			if(vo.getName() != null) {
				System.out.println("=========================");
				System.out.println("고유번호 : " + vo.getIdx());
				System.out.println("성명 : " + vo.getName());
				System.out.println("나이 : " + vo.getAge());
				System.out.println("성별 : " + vo.getGender());
				System.out.println("가입 일자 : " + vo.getJoinday());
				System.out.println("=========================");
			}
			else {
				System.out.println("=========================");
				System.out.println(name + "회원님을 찾지 못했습니다.");
				System.out.println("=========================");
				System.out.println();
			}
			System.out.print("계속 개별조회 하시겠습니까?(y/n) =>");
			ans = sc.next();
			if(ans.toLowerCase().equals("y")) {
				continue;
			}else if(ans.toLowerCase().equals("n")) {
				run = false;
			}
		}
	}
	
	// 전체자료 검색 후 출력처리하는 곳
	public void list() {
		 ArrayList<DBTestVO> vos = dao.list();		
		 //데이터베이스에서 읽어올 레코드 하나가 하나의 vo이다. 그 전체를 모두 vos라 하기. 
		 //vo들을 객체배열 ArrayList<DBTestVO>에 담아서 가져온다.
		 
		//전체자료 출력처리하는곳
		 System.out.println("=================================================");
		 System.out.println("고유번호\t 성 명\t 나 이\t 성 별\t 가입 일자");
		 System.out.println("-------------------------------------------------");
		 for(int i=0; i<vos.size(); i++) {
			 vo = vos.get(i);
			 System.out.println(vo.getIdx()+ " \t" +vo.getName()+ " \t" +vo.getAge()+ " \t" +vo.getGender()+ "  \t" +vo.getJoinday());
		 }
		 System.out.println("=================================================");
	}
	
	// 자료 수정
	public void update() {
		boolean run = true;
		while(run) {
			System.out.print("수정할 자료의 고유번호(idx)를 입력하세요? =>");
			idx = sc.nextInt();
			vo = dao.show(idx);
			if(vo != null) {
				System.out.println("========================== 선택하신 회원의 정보 ==========================");
				System.out.println("고유번호: " + vo.getIdx() + ", 성명: " + vo.getName() + ", 나이: " + vo.getAge() + ", 성별: " + vo.getGender() + ", 가입일: " + vo.getJoinday());
				System.out.println("=====================================================================");
				System.out.println();
			}
			else {
				System.out.println("고유번호 "+idx+"번 회원은 없습니다.\n");
				continue;
			}
			while(run) {
				System.out.println("수정할 항목을 선택하세요?");
				System.out.println("1.이름 | 2.나이 | 3.성별 | 4.가입일 | 5.종료 ");
				System.out.print("==>선택 :");
				int no = sc.nextInt();
				switch (no) {
					case 1: {
						System.out.print("이름 : ");
						name = sc.next();
						dao.update(idx ,name, no);
						System.out.println("수정성공!\n");
						break;
					}
					case 2: {
						System.out.print("나이 : ");
						age = sc.next();
						dao.update(idx, age, no);
						System.out.println("수정성공!\n");
						break;
					}
					case 3: {
						System.out.print("성별(남/여) : ");
						gender = sc.next();
						dao.update(idx, gender, no);
						System.out.println("수정성공!\n");
						break;
					}
					case 4: {
						System.out.print("가입일자(yyyy-mm-dd) : ");
						joinday = sc.next();
						dao.update(idx, joinday, no);
						System.out.println("수정성공!\n");
						break;
					}
					case 5: {
						System.out.println("수정을 종료합니다.");
						run = false;
						break;
					}
					default:
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요. \n");
						continue;
				}
			}
		}
	}
	
	// 자료 삭제
	public void delete() {
		while(true) {
			System.out.print("삭제할 자료의 고유번호(idx)를 입력하세요? =>");
			idx = sc.nextInt();
			vo = dao.show(idx);
			if(vo != null) {
				System.out.println("========================== 선택하신 회원의 정보 ==========================");
				System.out.println("고유번호: " + vo.getIdx() + ", 성명: " + vo.getName() + ", 나이: " + vo.getAge() + ", 성별: " + vo.getGender() + ", 가입일: " + vo.getJoinday());
				System.out.println("=====================================================================");
				System.out.println();
			}
			else {
				System.out.println("고유번호 "+idx+"번 회원은 없습니다. \n");
				continue;
			}
			System.out.print("정말로 삭제하시겠습니까?(y/n) =>");
			String choice = sc.next();
			if(choice.toLowerCase().equals("y")) {
				dao.delete(idx);
				System.out.println("삭제완료.");
				break;
			}
			else if(choice.toLowerCase().equals("n")) {
				System.out.println("삭제취소.");
				break;
			}else {
				System.out.println("잘못입력하여 삭제처리가 되지 않았습니다.");
				System.out.println();
				continue;
			}
		}
	}
}
