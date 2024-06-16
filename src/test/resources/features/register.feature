Feature: User Interaction on Registration Page

  # Dropdown Menu Scenarios [Solusi Kami]

  Scenario: User selects Integrasi Marketplace
    Given user is on registration page
    When user click on Solusi Kami dropdown
    And user select Integrasi Marketplace
    Then user redirected to Integrasi Marketplace page

  Scenario: User selects Manajemen Inventori
    Given user is on registration page
    When user click on Solusi Kami dropdown
    And user select Manajemen Inventori
    Then user redirected to Manajemen Inventori page

  Scenario: User selects Manajemen Order
    Given user is on registration page
    When user click on Solusi Kami dropdown
    And user select Manajemen Order
    Then user redirected to Manajemen Order page

  Scenario: User selects Catatan Keuangan
    Given user is on registration page
    When user click on Solusi Kami dropdown
    And user select Catatan Keuangan
    Then user redirected to Catatan Keuangan page

  Scenario: User selects Analisa Pelanggan
    Given user is on registration page
    When user click on Solusi Kami dropdown
    And user select Analisa Pelanggan
    Then user redirected to Analisa Pelanggan page

  Scenario: User selects Melaka Market
    Given user is on registration page
    When user click on Solusi Kami dropdown
    And user select Melaka Market
    Then user redirected to Melaka Market page

  # Dropdown Menu Scenarios [Edukasi]

  Scenario: User selects Seller Academy
    Given user is on registration page
    When user click on Edukasi dropdown
    And user select Seller Academy
    Then user redirected to Seller Academy page

  Scenario: User selects Pusat Bantuan
    Given user is on registration page
    When user click on Edukasi dropdown
    And user select Pusat Bantuan
    Then user redirected to Pusat Bantuan page

  # Registration Form Scenarios (Successful)

  Scenario: Successful registration with valid details
    Given user is on registration page
    When user enters registration details
    Then user registered successfully and redirected to the welcome page

  # Registration Form Negative Scenarios - Blank Fields

  Scenario: Registration fails due to nama field blank
    Given user is on registration page
    When user leaves the nama field blank
    Then error message indicating the nama field is required displayed

  Scenario: Registration fails due to nomor telepon field blank
    Given user is on registration page
    When user leaves the nomor telepon field blank
    Then error message indicating the nomor telepon field is required displayed

  Scenario: Registration fails due to nama bisnis field blank
    Given user is on registration page
    When user leaves the nama bisnis field blank
    Then error message indicating the nama bisnis field is required displayed

  Scenario: Registration fails due to email fields blank
    Given user is on registration page
    When user leaves the email field blank
    Then error message indicating the email field is required displayed

  Scenario: Registration fails due to kata sandi fields blank
    Given user is on registration page
    When user leaves the kata sandi field blank
    Then error message indicating the kata sandi field is required displayed

  # Registration Form Negative Scenarios - Invalid Formats

  Scenario: Registration fails due to invalid nama formats
    Given user is on registration page
    When user enters special characters in nama
    Then error message indicating the Nama field contains invalid characters

  Scenario: Registration fails due to invalid nomor telepon formats
    Given user is on registration page
    When user enters a long nomor telepon
    Then error message indicating the Nomor Telepon field is too long

  Scenario: Registration fails due to invalid email formats
    Given user is on registration page
    When user enters an invalid email format
    Then error message Email invalid

  Scenario: Registration fails due to invalid nama bisnis formats
    Given user is on registration page
    When user enters special characters in nama bisnis
    Then error message indicating the Nama Bisnis field contains invalid characters

  # Registration Form Negative Scenarios - Passwords

  Scenario: Registration fails due to mismatched passwords
    Given user is on registration page
    When user enters mismatched passwords
    Then error message indicating the passwords do not match

  Scenario: Registration fails due to weak password
    Given user is on registration page
    When user enters a weak password
    Then error message indicating the password is too weak

  # Registration Form Negative Scenarios - Syarat dan Ketentuan

  Scenario: Registration fails due to unchecked Syarat dan Ketentuan
    Given user is on registration page
    When user enters valid details
    Then daftar button disabled

  # User Already Have Account

  Scenario: User already have account
    Given user is on registration page
    When user click Masuk
    Then user redirected to login page