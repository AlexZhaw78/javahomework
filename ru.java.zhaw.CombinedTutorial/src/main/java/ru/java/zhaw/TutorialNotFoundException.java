package ru.java.zhaw;

public class TutorialNotFoundException extends RuntimeException {
	TutorialNotFoundException(Long id) {
		    super("Could not find tutorial " + id);
		  }
}
