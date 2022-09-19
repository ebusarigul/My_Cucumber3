Feature: Fee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create a Fee
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <nameInput>       |
      | codeInput       | <codeInput>       |
      | integrationCode | <integrationCode> |
      | priority        | <priority>        |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | <nameInput> |

    Then Success message should be displayed

    Examples:
      | nameInput  | codeInput | integrationCode | priority |
      | Ebu123     | 1345      | 121             | 15       |
      | Serkan234  | 3124      | 4712            | 78       |
      | Hamiyet124 | 21347     | 564165          | 156      |
      | Selma2323  | 46513     | 7451            | 16       |
      | Bsra4235   | 1451      | 15151           | 18       |