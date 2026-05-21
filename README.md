# Selenium CURA Healthcare - Appointment Booking Automation

## Project Overview
Automated appointment booking flow on CURA Healthcare demo website using Selenium WebDriver with Java.

## What This Project Does
- Reads login credentials from Excel file
- Handles dropdown selection, checkbox, radio button, and date input
- Validates appointment confirmation message

## Tools & Technologies
- Java
- Selenium WebDriver
- ChromeOptions
- Apache POI (Excel reading)
- Eclipse IDE

## Challenges I Solved
**1. NoAlertPresentException**
Thought it was a JavaScript alert but it was Chrome's password manager popup. Selenium cannot control browser level popups. Solved by launching Chrome in Incognito mode using ChromeOptions.

**2. Page Load Timing Issue**
Script was running too fast before page fully loaded. Used Thread.sleep(3000) to stabilize. Next improvement is replacing with explicit waits.

## What I Learned
Automation is not just about writing steps. It's about understanding browser behavior and handling real-time issues.
