package banking;

public class WrapperClassModification
{
	private static int value = 0;
	
	
	public static int getValue() {
		return value;
	}
	public static void setValue(int value) {
		WrapperClassModification.value = value;
	}
	
	

}
