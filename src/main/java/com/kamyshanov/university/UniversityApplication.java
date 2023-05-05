package com.kamyshanov.university;

import com.kamyshanov.university.service.ResponseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.kamyshanov.university.utils.Constants.Regex;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

	ResponseService responseService = new ResponseService();

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner input = new Scanner(System.in);
		String sentence = input.nextLine();

		Matcher matcher = Pattern.compile(Regex.HEAD_OF_DEPARTMENT).matcher(sentence);
		if(matcher.find()){
			responseService.printHeadOfDepartment(matcher.group(1));
			return;
		}

		matcher = Pattern.compile(Regex.SHOW_STATS).matcher(sentence);
		if(matcher.find()){
			responseService.printStatistics(matcher.group(1));
			return;
		}

		matcher = Pattern.compile(Regex.SHOW_SALARY).matcher(sentence);
		if(matcher.find()){
			responseService.printAverageSalary(matcher.group(1));
			return;
		}

		matcher = Pattern.compile(Regex.SHOW_EMPLOYEE_COUNT).matcher(sentence);
		if(matcher.find()){
			responseService.printEmployeeCount(matcher.group(1));
			return;
		}

		matcher = Pattern.compile(Regex.GLOBAL_SEARCH).matcher(sentence);
		if(matcher.find()){
			responseService.printGlobalSearchResult(matcher.group(1));
		}
	}
}
