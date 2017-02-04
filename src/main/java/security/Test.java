package security;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.ValidationErrorList;
import org.owasp.esapi.Validator;
import org.owasp.esapi.errors.ValidationException;
import org.owasp.esapi.reference.validation.HTMLValidationRule;

public class Test {

	public static void main(String[] args) throws ValidationException {
		System.out.println("getValidSafeHTML");
		Validator instance = ESAPI.validator();

		// new school test case setup
//		HTMLValidationRule rule = new HTMLValidationRule("safehtml");
//		ESAPI.validator().addRule(rule);

//		System.out.println(ESAPI.validator().getRule("safehtml").getValid("test", "Test. <script>alert(document.cookie)</script>"));
//
//		String test1 = "<b>Jeff</b>";
//		String result1 = instance.getValidSafeHTML("test", test1, 100, false);
		
		System.out.println(ESAPI.validator().getValidInput("User Email",  "Test. <script>alert(document.cookie)</script>", "SafeString", 100, false));
	}
}
