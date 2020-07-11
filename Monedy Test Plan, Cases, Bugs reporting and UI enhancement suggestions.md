# First Part: Test Design Plan

As long as we are going for more coverage, so I prepared a checklist for the Core Features, it can be used for Smoke Testing:

  ## *Introduction: 
Personal finance manager and expense tracker that will help you to find out where your money goes in easy and efficient way.

## *Objective:
As long as we are going for more coverage, so I prepared a checklist for the Core Features, it can be used for Smoke Testing.

## *Strategy
1-Manual Functional testing
2-Smoke Test

## *Test TOOLS
Report on google doc & git markdown file

## *Tasks
1-Writing Test Cases
2-Reporting bugs
3-Test Execution


## Test Cases

**⦁Expense, Income & Balance:**

 - -Verify that Can't add to expense while there is no added account.
   
   -Verify that Can't add to income while there is no added account.
   
   -Make sure that the (Balance = Income - Expense).
   
   -Make sure that the Balance can be negative or positive.
   
   -Make sure that the Balance is calculated cumulatively for the selected day.
   
   -Make sure that at "Budget Mode" the income isn't displayed at the chart pie, just expense, and the fixed budget.
   
   -Make sure that at "Budget Mode" balance is calculating regarding the budget instead of income (fixed budget - expense).
   
   -Make sure by enabling "Carry-over" that will calculate cumulatively.

  

**⦁Filtering the View:**

 - -Make sure of view when filtering with a selected account.
   
   -Make sure that the starting day in view is the date of the account's "Initial balance date".
   
   -Make sure of view when selecting a specific time.

  

**⦁Accounts & transfer between:**

 - -Make sure that the user can create a new account.
   
   -Make sure that the user can delete the account.
   
   -Make sure that the user can edit the account details.
   
   -When no accounts created yet, Make sure by clicking on transfer to be forwarded to creating a new account screen.
   
   -Make sure that can not transfer money from and to the same account

  

**⦁Expense Categories, Ratios, Pie Chart:**

 - -Make sure that Adding an expense will reflect on the selected category in: Pie chart, ratio, records details for the selected
   period.
   
   -Make sure that Deleting an expense category will reflect correctly on: Pie Chart, Balance, records details for the selected period.
   
   -Make sure by editing an expense that will reflect correctly on: Pie Chart, Balance and categories list.
   
   -Make sure Edit an expense category will reflect correctly on Pie Chart, Categories list

  

**⦁Basic Mobile Behavioral checks while testing**: Installing - Launching - Uninstall - Running - Closing - online/offline - Multitasking - update over update if there is an update.  
(further test to check the performance to avoid any unexpected crashes: don't keep activities - battery saving mode)

  
  
  
  

# Second Part: Bug Reporting

**Bug#1**:

Title:
By adding more than one interval, the dates are messed up and all saved intervals are displayed in wrong values

Steps:
1-Install the app  
2-Open the app  
3-Swipe to left, to open the slide menu  
4-Select interval  
5-Choose start and end dates, then click “Save”  
6-Repeat steps 4 & 5  
After that check the intervals that you have selected

Attachments:
[https://drive.google.com/file/d/1qeG8HMSSxWySFqtQkhXmIxyW_loPE9FW/view?usp=sharing](https://drive.google.com/file/d/1qeG8HMSSxWySFqtQkhXmIxyW_loPE9FW/view?usp=sharing)

Devices + OS: Android-OS.9: Oppo F9

Network: Both Online(Wifi) and Offline

Severity: High

Priority: High

Impact: Displaying wrong intervals rather than the selected

## **Bug#2**:

Title:
By trying to add an Expense or Income, the text field of adding a note is highlighted and the cursor appears as you clicked on it; meanwhile, you are working with the calculator

Steps:
1-Install the app  
2-Open the app  
3-Try to add an expense or income  
Check the add note text field

Attachments:
[https://drive.google.com/file/d/1qfglPlA3iO65izUULHMraVCUPM5Ym9Rr/view?usp=sharing](https://drive.google.com/file/d/1qfglPlA3iO65izUULHMraVCUPM5Ym9Rr/view?usp=sharing)

Devices + OS: Android-OS.9: Oppo F9

Network: Both Online(Wifi) and Offline

Severity: Medium

Priority: Low

Impact:
An ambiguity of behavior, as the field is highlighted as selected with a cursor as some users may expect by entering numbers should reflect on the selected field.

## **Bug#3**:

Title:
After making a lot of calculations aggressively using the calculator, it doesn’t calculate

Steps:
1-Install the app  
2-Open the app  
3-Try to add an expense or income or transfer money (any item that uses the calculator)
4-Try to make a lot of calculations as much as you can  
Check the calculation after that

Attachments:
[https://drive.google.com/file/d/1qn_x0CJV7n4LCcb35dZNkD2AManBjxzT/view?usp=sharing](https://drive.google.com/file/d/1qn_x0CJV7n4LCcb35dZNkD2AManBjxzT/view?usp=sharing)

Devices + OS: Android-OS.9: Oppo F9

Network: Both Online(Wifi) and Offline

Severity:Medium

Priority: Medium

Impact: The calculator doesn’t calculate just accepts clicked numbers

  

## **Bug#4**:

Title:
While enabling “Don’t keep activities”, by clicking multiple times on Carry Over/Future recurring records .. the pie chart and categories at Main screen disappear.

Steps:
1-Install the app  
2-Open mobile settings, enable “Don’t keep activities” from “developer options”  
3-Open the app
4-Open slide menu on the right  
5-Click multiple times on Carry Over or Future recurring records checkboxes  
Check the Main screen view (The pie chart)

Attachments

[https://drive.google.com/file/d/1-2--ukrMvGq5x0AXCJ7oxhRvbz81wLmH/view?usp=sharing](https://drive.google.com/file/d/1-2--ukrMvGq5x0AXCJ7oxhRvbz81wLmH/view?usp=sharing)

Devices + OS: Android-OS.7: Lenovo VIBE K6

Network:Both Online(Wifi) and Offline

Severity:High

Priority:High

Impact:The pie chart and categories on the Main screen disappear.

  
  

## **Bug#5**:

Title:
After selecting a number of items from records detail screen without deleting any, by trying to make an expense or income then come back to details the delete icon still available but the selection is hidden and by clicking on delete the selected items before are deleted

Steps:
1-Install the app  
2-Open the app  
3-Swipe up/Select the Balance details  
4-Choose category view  
5-Select multi-items from categories  
6-Click on income/expense  
7-Do an income/expense or just click back  
Check the selected items & delete icon

Attachments:
[https://drive.google.com/file/d/1qvIlaZYd2cjfp4iFH-vVnBrsz7YjApVg/view?usp=sharing](https://drive.google.com/file/d/1qvIlaZYd2cjfp4iFH-vVnBrsz7YjApVg/view?usp=sharing)

Devices + OS: Android-OS.9: Oppo F9

Network: Both Online(Wifi) and Offline

Severity: High

Priority: High

Impact:
1-The items aren’t selected anymore  
2-While the delete icon still displayed and by clicking on it the selected items before will be deleted

  

## **Bug#6**:

Title: 
By selecting +/- buttons while swiping between days/weeks/months/years, After coming back to the Main screen... It becomes empty without the piechart or the balance tab

Steps:
1-Install the app  
2-Open the app  
3-Swipe left/right  
4-While swiping click on +/-  
5-Do an income/expense or just cancel to back to the Main screen  
Check the Main screen view (The pie chart + balance bar)

Attachments: [https://drive.google.com/file/d/1Z3oWrtLDBxq35AR09BkkaTXWu33cIX00/view?usp=sharing](https://drive.google.com/file/d/1-2--ukrMvGq5x0AXCJ7oxhRvbz81wLmH/view?usp=sharing)

Devices + OS: iOS 12.3.1: iPhone 6s

Network: Both Online(Wifi) and Offline

Severity: High

Priority: High

Impact:
1-The pie chart and categories on the Main screen disappear.  
2-The Balance bar on the Main screen also disappears.

  

  
**

## Second Part: UI/UX enhancement suggestions:

1- Slide menus on the Left & Right are completely hidden and not clear that there is a bar  
2-By trying to make an income/expense action, the account selection besides the input number isn’t clear that it’s a dropdown list to select which account to be selected for the taken action.  
3-Replace the toast messages with a better-designed alert one.  
4-Add a better touring to learn/educate the user in a more easy way
