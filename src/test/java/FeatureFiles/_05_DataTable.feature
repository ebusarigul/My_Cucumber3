Feature: DataTable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly


  Scenario: Create Country
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | countries  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | EbuCountry |
      | codeInput | 12346874   |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | EbuCountry |
    Then Success message should be displayed


  Scenario: Create a Nationality
    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | nationalities |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | EbuNat1 |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | EbuNat1 |
    Then Success message should be displayed


  Scenario: Create a Fee
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | Ebu112     |
      | codeInput       | 16545635   |
      | integrationCode | 154565   |
      | priority        | 181        |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | Ebu112 |

    Then Success message should be displayed




