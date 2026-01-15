package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * 	@Component
 * 		- 스프링 컨테이너가 해당 클래스를 빈으로 생성하고 관리하게 함
 * 		- 요청시 사용할 속성값 지정 (id, name)
 */

/*
 * 	의존성 주입 Annotation
 * 
 * 	@Autowired
 * 		- 변수 위에 설정하여 해당 타입의 객체를 찾아 자동으로 할당
 * 	@Qualifier
 * 		- 특정 객체의 이름을 이용해 의존성 주입
 * 	@Resource
 * 		- =@Autowired
 * 	@Inject
 * 		- @Autowired + @Qualifier
 */

@Component("tv")
public class LgTV implements TV {
	@Autowired
	//@Qualifier("sony")
	//@Resource(name = "sony")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("=> LgTV 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("LgTV ----- 전원을 킨다.");
	}
	
	public void powerOff() {
		System.out.println("LgTV ----- 전원을 끈다.");
	}
	
	public void volumeUp() {
		// System.out.println("LgTV ----- 볼륨을 높인다.");
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		// System.out.println("LgTV ----- 볼륨을 줄인다.");
		speaker.volumeDown();
	}
}
