package Loan.org.manage.validators;

public class Validators extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Validators(String s) {
		super(s);
	}

	public static void isValidEmail(String email) throws Validators {
		String regex = "^(.+)@(.+)$";
		if (!email.matches(regex)) {
			throw new Validators("Invaild Email");
		} else {
			System.out.println("Email Verified");
		}
	}

	public static void isValidAadhar(long Aadhar) throws Validators {
		String regex = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";
		;
		if (!String.valueOf(Aadhar).matches(regex)) {
			throw new Validators("Invaild Aadhar");
		} else {
			System.out.println("Aadhar Verified");
		}
	}

	public static void isValidPhone(String Phone) throws Validators {
		String regex = "^[0-9]{10}$";
		if (!Phone.matches(regex)) {
			throw new Validators("Invalid Phone number");
		} else {
			System.out.println("Phone number Verified");
		}
	}

	public static void isValidPAN(String PAN) throws Validators {
		String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
		if (!PAN.matches(regex)) {
			throw new Validators("Invalid PAN");
		} else {
			System.out.println("PAN Verified");
		}
	}

}
