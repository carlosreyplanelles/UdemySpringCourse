package src.com.luv2code.springdemo;

public class AverageFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is an average day. Nothing interesting will happen.";
	}

}
