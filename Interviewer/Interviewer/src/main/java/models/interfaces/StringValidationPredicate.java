package models.interfaces;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidationPredicate implements ValidationPredicate<String> {
	
	@Override
	public boolean validatite(String e, Pattern pattern) {
		Matcher m = pattern.matcher(e.toString());
		return m.find();
	}}
