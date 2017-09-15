package models.interfaces;
import java.util.regex.Pattern;

public interface NumberValidationPredicate extends ValidationPredicate<Integer> {
	public boolean evaluvate(Integer e,Pattern pattern);
}
