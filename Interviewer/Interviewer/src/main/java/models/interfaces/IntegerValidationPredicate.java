package models.interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerValidationPredicate implements ValidationPredicate<Integer> {

	@Override
	public boolean validatite(Integer e, Pattern pattern) {
		Matcher m = pattern.matcher(e.toString());
		return m.find();
	}

}
