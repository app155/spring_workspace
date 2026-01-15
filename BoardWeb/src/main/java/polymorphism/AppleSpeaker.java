package polymorphism;

import org.springframework.stereotype.Component;

//@Component("apple")
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("=> AppleSpeaker 객체 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("Apple Speaker ----- 볼륨을 높인다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("Apple Speaker ----- 볼륨을 내린다.");
	}

}
