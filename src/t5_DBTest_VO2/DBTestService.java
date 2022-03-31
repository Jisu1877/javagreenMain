package t5_DBTest_VO2;

import java.util.ArrayList;
import java.util.Scanner;

public class DBTestService {
	Scanner sc = new Scanner(System.in);
	String name;

	DBTestDAO dao = new DBTestDAO();
	DBTestVO vo = new DBTestVO();
	
	// 자료 등록
	public void input() {
		System.out.print("성명 : "); vo.setName(sc.next());
		System.out.print("나이 : "); vo.setAge(sc.nextInt());
		System.out.print("성별 : "); String gender = sc.next();
    if(!gender.equals("남") && !gender.equals("여")) gender = "여";
    vo.setGender(gender);
		System.out.print("입사일 : "); vo.setJoinday(sc.next());
		dao.input(vo);
	}

	// 개별자료 검색
	public void search() {
		System.out.print("검색할 성명을 입력하세요? ");
		name = sc.next();
		vo = dao.search(name);
		//System.out.println("vo : " + vo);
		System.out.println("-----------------------------------");
		if(vo.getName() == null) {
			System.out.println("검색하신 "+name+"(이)가 없습니다.");
		}
		else {
			System.out.println("검색하신 성명은? " + name);
			System.out.println("고유번호 : " + vo.getIdx());
			System.out.println("나이 : " + vo.getAge());
			System.out.println("성별 : " + vo.getGender());
			System.out.println("입사일 : " + vo.getJoinday().substring(0,10));
		}
		System.out.println("-----------------------------------");
		
	}

	// 전체자료 검색후 출력처리하는곳
	public void list() {
		ArrayList<DBTestVO> vos = dao.list();
		
		// 전체자료 출력처리하는곳
		System.out.println("============================================");
		System.out.println("번호\t성 명\t나이\t성별\t 가입일자");
		System.out.println("--------------------------------------------");
		
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			System.out.println(vo.getIdx()+"\t"+vo.getName()+"\t"+vo.getAge()+"\t"+vo.getGender()+"\t"+vo.getJoinday().substring(0,10));
		}
		System.out.println("============================================");
	}

	// 자료 수정을 위한 자료검색
	public void update() {
		System.out.print("수정할 회원의 고유번호를 입력하세요? ");
		int idx = sc.nextInt();
		DBTestVO vo = dao.UpdateSearch(idx);
		if(vo.getName() == null) {
			System.out.println("-->> 검색된 회원이 없습니다. 다시 검색해 보세요.");
		}
		else {
			updateProcess(vo);
		}
	}

	// 검색된 자료가 있을때 수정처리한다.
	private void updateProcess(DBTestVO vo) {
		boolean run = true;
    while(run) {
      System.out.println(vo.getIdx()+" 회원의 수정할 항목을 선택하세요?");
      System.out.print("1."+vo.getName()+"  2."+vo.getAge()+"  3."+vo.getGender()
        +"  4."+vo.getJoinday().substring(0, 11)+"  5.종료 ==> ");
      int no = sc.nextInt();
      switch(no) {
        case 1:
          System.out.print("이름을 입력하세요? ");
          vo.setName(sc.next());
          break;
        case 2:
          System.out.print("나이를 입력하세요? ");
          vo.setAge(sc.nextInt());
          break;
        case 3:
          System.out.print("성별을 입력하세요?(남/여) ");
          String gender = sc.next();
          if(!gender.equals("남") && !gender.equals("여")) gender = "여";
          vo.setGender(gender);
          break;
        case 4:
          System.out.print("입사일을 입력하세요(예: 2022-3-30)? ");
          vo.setJoinday(sc.next());
          break;
        default :
          run = false;
      }
    }
    dao.updateProcess(vo);
    System.out.println("-->> "+vo.getIdx() + "번 자료가 수정되었습니다.");
	}

	// 자료 삭제
	public void delete() {
		System.out.print("삭제할 성명을 입력하세요? ");
		name = sc.next();
		int res = dao.delete(name);
		if(res == 1) System.out.println("-->> 자료가 삭제되었습니다.");
		else System.out.println("-->> 자료 삭제 실패!!");
	}

}
