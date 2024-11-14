class TopMostDude {
	public void myMethod(String randomText) {
		System.out.println("Don't change my words bro! (" + randomText + ")");
	}
}

class LowerDude extends TopMostDude {
	@Override 
	public void myMethod(String randomText) {
		System.out.println("What you gonna do bout it? (" + randomText + ")");
	}
}

class RandomDude extends LowerDude {
	@Override 
	public void myMethod(String randomText) {
		System.out.println("Whatchu goyz doin'? (" + randomText + ")");
	}
}

public class HyperdriveEyy {
	public static void main(String[] args) {
		TopMostDude theMan = new TopMostDude();
		LowerDude theDude = new LowerDude();
		RandomDude thePasserby = new RandomDude();
		
		theMan.myMethod("hatdog"); 
		theDude.myMethod("hehe"); 
		thePasserby.myMethod("oh wow"); 
	}
}