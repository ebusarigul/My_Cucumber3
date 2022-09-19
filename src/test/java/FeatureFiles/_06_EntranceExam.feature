Feature:EntranceExam Func

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario: Create Exam
    And Click on the element in the left Nav
      | entranceExams  |
      | setupExam      |
      | entranceExams2 |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | Ebu108 |

    And Click on the element in the Form
      | academicPeriod |
      | select1        |
      | gradeLevel     |
      | select2        |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in the Form
      | back |

    And User delete item from Form
      | Ebu108 |

    Then Success message should be displayed