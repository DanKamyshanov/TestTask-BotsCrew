package com.kamyshanov.university.utils;

import lombok.experimental.UtilityClass;

public class Constants {
    @UtilityClass
    public class Regex{
        public final String HEAD_OF_DEPARTMENT = "Who is head of department (.+)";
        public final String SHOW_STATS = "Show (.+) statistics";
        public final String SHOW_SALARY = "Show the average salary for the department (.+)";
        public final String SHOW_EMPLOYEE_COUNT = "Show count of employee for (.+)";
        public final String GLOBAL_SEARCH = "Global search by (.+)";
    }
}
