package com.trainSpringBoot.logant.Utils;

import java.util.Random;

public class MainUtils {

    static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateRandomUsername(int length) {
        Random random = new Random();
        StringBuilder username = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            username.append(chars.charAt(index));
        }

        return username.toString();
    }

    public static String generateRandomPassword(int length) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

    public static String generateRandomEmail() {

        Random random = new Random();
        StringBuilder email = new StringBuilder();

        // Generate a random username (6-12 characters)
        int usernameLength = 6 + random.nextInt(7);
        for (int i = 0; i < usernameLength; i++) {
            email.append(chars.charAt(random.nextInt(chars.length())));
        }

        // Append a domain
        String[] domains = { "gmail.com", "yahoo.com", "outlook.com", "example.com" };
        String domain = domains[random.nextInt(domains.length)];
        email.append("@").append(domain);

        return email.toString();
    }



    // @Bean
	// public CommandLineRunner demo(UserRepo userRepository, RoleRepo roleRepo) {
	// 	return (args) -> {

	// 		UUID uuid = UUID.fromString("de6cbf6c-c4a4-4861-9408-4beb73ca5dc4");
	// 		Role userRole = roleRepo.findById(uuid).orElseThrow(() -> new Exception("Role not found"));

	// 		for(int i = 0 ; i < 20; i++ ){
	// 			User user = new User();
	// 			user.setName(MainUtils.generateRandomUsername(10));
	// 			user.setEmail(MainUtils.generateRandomEmail());
	// 			user.setPassword(MainUtils.generateRandomPassword(10));
	// 			user.setRole(userRole);
	// 			userRepository.save(user);
	// 		}
	// 	};
	// }


    // @Bean
	// public CommandLineRunner demo(MenuRepo menuRepo,RoleRepo roleRepo) {
	// 	return (args) -> {

	// 		UUID uuid = UUID.fromString("de6cbf6c-c4a4-4861-9408-4beb73ca5dc4");
	// 		Role userRole = roleRepo.findById(uuid).orElseThrow(() -> new Exception("Role not found"));

	// 		UUID uuid1 = UUID.fromString("62d6ce16-ac37-4cc3-982c-a0b228f9590b");
	// 		Menu menu = menuRepo.findById(uuid1).orElseThrow(() -> new Exception("Menu not found"));
	// 		List<Menu> menuList = userRole.getMenus();
	// 		menuList.add(menu);
	// 		userRole.setMenus(menuList);
	// 		roleRepo.save(userRole);
	// 	};
	// }
}
