#  Employee menusu için Create-Exist-Delete bölümleri olan Senaryoyu yazınız
#  Daha sonra aynı senaryoru 5 farklı degerler için çalıştırınız.

Feature:Employee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create a Fee
    And Click on the element in the left Nav
      | humanResources |
      | employees      |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Form content
      | firstName      | <firstName>      |
      | lastName       | <lastName>       |
      | employeeid     | <employeeid>     |
      | documentNumber | <documentNumber> |
      | personalId     | <personalId>     |

    And Click on the element in the Form
      | gender       |
      | <cinsiyet>   |
      | employeeType |
      | other        |

    When Click on the ESC

    And Click on the element in the Form
      | qualification  |
      | master         |
      | documentType   |
      | passport       |
      | contactAddress |

    And User sending the keys in Form content
      | country | <country> |

    When Click on the ENTER

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in the Form
      | back |

    And User delete item from Form
      | <firstName> |

    Then Success message should be displayed
    Examples:
      | firstName | lastName | employeeid | documentNumber | personalId | cinsiyet | country |
      | Ebubekir  | Sarigul  | 12421414   | 124124         | 325235     | male     | Turkey  |
      | Selma     | Sarigul  | 23534      | 34234          | 75675      | female   | France  |
      | Havva     | Sarigul  | 457547     | 75685          | 568568     | female   | ABD     |
      | Muhittin  | Sarigul  | 6546747    | 23423          | 4535       | male     | England |
      | Busra     | Sarigul  | 235235     | 645645         | 75675      | female   | Canada  |
























