package models.interfaces;

import java.util.regex.Pattern;

public interface ValidationPredicate<E> {
	public boolean validatite(E e,Pattern pattern);
}
