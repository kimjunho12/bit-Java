package prob05;

public class MyBase extends Base {

	@Override
	public void service(String state) {
		// TODO Auto-generated method stub
		if (state.equals("오후"))
			System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
		else
			super.service(state);
	}

}
