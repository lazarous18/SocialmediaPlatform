package SocialMediaPlatform;

import Model.Database;
import View.Welcome;

public class Main {

	public static void main(String[] args) {
		new Welcome(new Database());
	}

}
