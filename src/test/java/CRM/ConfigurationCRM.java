package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class ConfigurationCRM {

    public static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    public static final String STUDENT_LOGIN = "Applanatest1";
    public static final String STUDENT_PASSWORD = "Student2020!";
    public static final String BTN_LOGIN_SUBMIT_CRM = "_submit";
    public static final String ID_STUDENT_LOGIN = "prependedInput";
    public static final String ID_STUDENT_PASSWORD = "prependedInput2";

    public static final String XPATH_COUNTERPARTIES_ELEMENT = "//span[contains(.,'Контрагенты')]";
    public static final String LINK_TEXT_COUNTERPARTIES = "Контрагенты";
    public static final String XPATH_CONTACT_PERSON  = ".//span[contains(.,'Контактные лица')]";
    public static final String LINK_TEXT_CREATE_CONTACT_PERSON  = "Создать контактное лицо";
    public static final String BY_NAME_LAST_NAME = "crm_contact[lastName]";
    public static final String CONTACT_PERSON_LAST_NAME = "Geekbrains";
    public static final String BY_NAME_FIRST_NAME = "crm_contact[firstName]";
    public static final String CONTACT_PERSON_FIRST_NAME = "Stud";
    public static final String ORGANIZATION_NAME_CSS_SELECTOR = ".select2-chosen";
    public static final String ORGANIZATION_NAME_XPATH = "//*[@id='select2-drop']/ul[2]/li[5]/div";
    public static final String ORGANIZATION_NAME_TEXT_XPATH = "//div[@class='controls']/div/div[1]/a/span[1]";
    public static final String ORGANIZATION_NAME_TEXT_XPATH_ACTUAL = "1234";
    public static final String BY_NAME_JOB_TITLE = "crm_contact[jobTitle]";
    public static final String JOB_TITLE = "Student";
    public static final String SAVE_BUTTON_CSS_SELECTOR = ".btn-group:nth-child(4) > .btn";
    public static final String FILTER_CSS_SELECTOR = ".filter-item:nth-child(1) .filter-criteria-hint";
    public static final String FILTER_UPDATE_CSS_SELECTOR = ".filter-update";
    public static final String XPATH_CONTACT_PERSON_CREATED = "//td";

    public static final String MY_RANDOM_NUMBER_STR = Double.toString(Math.random());
    public static final String LINK_TEXT_PROJECTS = "Проекты";
    public static final String XPATH_PROJECTS_ELEMENT = "//span[contains(.,'Проекты')]";
    public static final String XPATH_MY_PROJECTS = ".//span[contains(.,'Мои проекты')]";
    public static final String LINK_TEXT_CREATE_PROJECT = "Создать проект";
    public static final String BY_NAME_PROJECT_NAME = "crm_project[name]";
    public static final String ORGANIZATION_CSS_SELECTOR = ".select2-default > .select2-chosen";
    public static final String XPATH_ORGANIZATION = "//*[@id='select2-drop']/ul[2]/li[5]/div";
    public static final String XPATH_ORGANIZATION_NAME = "//div/a/span";
    public static final String ORGANIZATION_NAME = "123test";
    public static final String XPATH_CONTACT_PERSON_IN_PROJECT = "//*[@class='select2-container select2']";
    public static final String CONTACT_PERSON_CSS_SELECTOR = ".select2-focused";
    public static final String CONTACT_PERSON_NAME = "Geekbrains Stud";
    public static final String XPATH_CONTACT_PERSON_NAME = "//div[2]/div/a/span[1]";
    public static final String BUSINESS_UNIT_NAME = "crm_project[businessUnit]";
    public static final String SUBDIVISION_SELECT_BY_VALUE = "1";
    public static final String XPATH_SUBDIVISION_NAME = "//div[5]/div[2]/div/span";
    public static final String SUBDIVISION_NAME = "Research & Development";
    public static final String CURATOR_BY_NAME = "crm_project[curator]";
    public static final String CURATOR_NAME = "Applanatest Applanatest Applanatest";
    public static final String XPATH_CURATOR_NAME = "//div[6]/div[2]/div/span";
    public static final String PROJECT_LEAD_BY_NAME = "crm_project[rp]";
    public static final String PROJECT_LEAD_NAME = "Студентов Студент";
    public static final String XPATH_PROJECT_LEAD = "//div[7]/div[2]/div/span";
    public static final String ADMINISTRATOR_BY_NAME = "crm_project[administrator]";
    public static final String ADMINISTRATOR_NAME = "Applanatest Applanatest Applanatest";
    public static final String XPATH_ADMINISTRATOR_NAME = "//div[8]/div[2]/div/span";
    public static final String MANAGER_BY_NAME = "crm_project[manager]";
    public static final String MANAGER_NAME = "Applanatest Applanatest Applanatest";
    public static final String XPATH_MANAGER_NAME = "//div[9]/div[2]/div/span";
    public static final String BTN_PROJECT_SAVE = ".btn-group:nth-child(4) > .btn";

}
