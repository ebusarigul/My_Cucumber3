#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption      | GradeLevelOption |
#| Math exam is1   | academicPeriod2              | gradeLevel4  |
#| IT exam is1     | academicPeriod2              | gradeLevel2  |
#| Oracle exam is1 | academicPeriod2              | gradeLevel3  |
#| Math exam  is1  | academicPeriod2              | gradeLevel1  |

Feature:EntranceExam Func

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create Exam
    And Click on the element in the left Nav
      | entranceExams  |
      | setupExam      |
      | entranceExams2 |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | <ExamName> |

    And Click on the element in the Form
      | academicPeriod         |
      | <AcademicPeriodOption> |
      | gradeLevel             |
      | <GradeLevelOption>     |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in the Form
      | back |

    And User delete item from Form
      | <ExamName> |

    Then Success message should be displayed

    Examples:
      | ExamName        | AcademicPeriodOption | GradeLevelOption |
      | Math exam is1   | select1              | select2          |
      | IT exam is1     | select1              | select2          |
      | Oracle exam is1 | select1              | select2          |
      | Math exam  is1  | select1              | select2          |