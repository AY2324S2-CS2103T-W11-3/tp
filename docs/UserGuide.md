---
layout: page
title: User Guide
---

--------------------------------------------------------------------------------------------------------------------

![UiPreview](images/UserGuideFront.png)

## What is Dook?

An _elegant, minimalistic and intuitive_ **desktop application** made especially for [**NUS Computing students**](https://www.comp.nus.edu.sg/) to
easily manage their academic **consultations** and **contacts** all-in-one place.

Dook blends the power of a nimble [**Command Line Interface (CLI)**](#glossary) together with the intuitive accessibility of a
[**Graphical User Interface (GUI)**](#glossary).

Designed for the dynamic needs of the NUS
School of Computing (SoC) community, Dook centralizes faculty information
in an innovative manner, allowing one to easily find their professors by taking advantage of the basic CLI familiarity of SoC students.

For the **quick typist**, Dook elevates your ability to swiftly organize your academic consultations with professors
and teaching assistants, outpacing conventional GUI-based applications, making management of consultations a breeze.

We hope that you will find this guide helpful in maximising your Dook experience! :)

--------------------------------------------------------------------------------------------------------------------

## Using the Guide

We hope that this guide will familiarise you with the [CLI](#glossary) commands and [GUI](#glossary) and interface. If you
are unfamiliar with some jargon here, do have a quick look at our [glossary](#glossary) below! :)

* For **first-time users**, please take a look at our [Quick Start](#quick-start) section to start an end-to-end tutorial for Dook.
* For **seasoned users** who know command line and/or have used _Dook_ before, do take a look at our [Command Summary](#command-summary) for a refresher!

Throughout this guide, we also use coloured boxes to provide any important or extra pointers that we hope you would find useful.

<div markdown="block" class="alert alert-info">
:information_source: **Information**

Content in blue boxes provides additional information and contextual knowledge you need to better understand Dook.
</div>

<div markdown="block" class="alert alert-success">
:bulb: **Tips**

Content in green boxes provides tips and good practices to help you use the application more efficiently.
</div>

<div markdown="block" class="alert alert-warning">
:exclamation: **Caution** <br>

Content in yellow boxes draws your attention to certain minor issues that you may encounter when using Dook.

</div>

<div markdown="block" class="alert alert-danger">
:exclamation: **Warnings** <br>

Content in red boxes draws your attention to potential pitfalls to avoid and alert you to possible errors.
</div>

--------------------------------------------------------------------------------------------------------------------

## Table of Contents

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have [Java 11](#faq) or above installed in your Computer. If you have never downloaded it before,
   download from [here.](https://www.oracle.com/sg/java/technologies/javase/jdk11-archive-downloads.html)

1. Download the latest version of [Dook](https://github.com/AY2324S2-CS2103T-W11-3/tp/releases) `jar` in your computer.

1. Copy the file into an empty folder you want to use as the `home folder` for Dook.

1. Depending on your operating system, either open “Terminal” on macOS or “Command Prompt” in Windows, and type `java -jar Dook.jar` to run the application. <br>
   
You should see a GUI similar to the one shown below pop up in a few seconds.

![Ui image](images/SampleUi.png)

<div markdown="block" class="alert alert-danger">
:exclamation: **Note** <br>

Please note that the application doesn't come with any sample data and that's why we will show you how to add your own in the [next section](#lets-add-some-sample-data).
</div>

<div markdown="block" class="alert alert-info">
:information_source: **Information**

New to the command line? Don't worry, checkout this [guide](https://tutorials.codebar.io/command-line/introduction/tutorial.html)
</div>

### Let's add some sample data

1. First, go to the [command box](#understanding-the-interface) on the main window, where it says

   _"Enter Command here..."_ <br> ![Command Box](images/commandBox.png)

2. Now, type `help` to open another window that lists out all the **commands** native to Dook.
3. Next, paste this command in the `command box` to add a new **contact** named `Bob Smith` to the Dook address book. `add -n Bob Smith -p 98765432 -e bsmith@example.com -a Bedok 693021`
4. Now, let's add some sample **consultations**. Paste this in your [command box](#understanding-the-interface) to add a consultation named `CS2103T Consultation`. <br>`book -n CS2103T Consultation -s 2024-04-21 14:00 -e 2024-04-21 16:00`
5. Repeat steps 3 - 4 to add some more sample data, however this time **change** the details after each flag. (for example, `add -n Celine -p 98564383 ...`) 
6. Now, let's **find** a consultation by typing `search CS2103T Consultation` into the `command box`
7. Voila! You did it. You finally added some sample data to Dook and tried some native features as well.
8. Now, let's exit the app using `exit` command.

<div markdown="block" class="alert alert-success">
:bulb: **Worried about getting your data lost?**

Don't worry, your data is **automatically saved** to Dook Address Book!
</div>



Many thanks for joining us in this tutorial. For additional commands, please refer to the [Features section](#features) below for details of every available command.

[Back To Top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Understanding the Interface

The main interface is divided into **two main panels** (Booking and Contact) and **4 smaller elements** (shown below). There's a menu bar at the top with two buttons `File`
 and `Help`, and at the bottom there's a status bar displaying the location of the `addressbook.json` file.

<div markdown="block" class="alert alert-info">
:information_source: **Information**

A [JSON](#glossary) file is a text-based format for storing and exchanging data. JSON stands for JavaScript Object Notation.
</div>

![Main panel](images/MainPanel.png)

Here's your guide of the different panels:
1. `Contact List`: Displays all contacts in the Dook address book.
2. `Booking List`: Shows all the bookings the user currently has.
3. `Result Box`: Displays the output after each command is executed.
4. `Command Box`: Allows users to enter commands.

### Contact Card
![Contact Card](images/ContactCard.png)

Each `Contact card` Includes the following information:
1. `Prof Damith Rajapakse` - Contact Name
2. `65164359` - Phone Number
3. `COM2-02-57` - Address
4. `damithch@comp.nus.edu.sg` - Email
5. `Professor` - Tag 

<div markdown="block" class="alert alert-success">
:bulb: **Tips**

You can easily `add` a new contact using the [add](#adding-a-contact-add) command or `edit` the existing information with the [edit](#editing-a-contact--edit) command.
</div>

[Back To Top](#table-of-contents)

### Booking Card
![Booking Card](images/BookingCard.png)

Each `Booking card` Includes the following information:
1. `CS2103T Consult` - Consultation Title
2. `2024-03-21 12:00` - Start Date and Time
3. `2024-03-21 14:00` - End Date and Time
4. `Attend as early as possible...` - Notes or Descriptions for the consultation

<div markdown="block" class="alert alert-success">
:bulb: **Tips**

You can easily `update` the following details with the [update](#updating-bookings-update) command or [`cancel`](#cancelling-a-booking--cancel) any existing bookings immediately.
</div>

[Back To Top](#table-of-contents)

### Result Box

Displays two kinds of information/indication based on the command executed.

**Upon Success:**
![Result Box](images/ResultBox_Success.png)

**Upon Failure:**
![Result Box](images/ResultBox_Error.png)

[Back To Top](#table-of-contents)

### Help Window

Displays a window with `Command Box Panel` and `Take me to UG` link.
1. `Command Box Panel` - it consists of all the commands native to Dook.
2. `Take me to UG` - a link that takes you directly to the User Guide for more information on each feature.

<div markdown="block" class="alert alert-danger">
:exclamation: **Note** <br>
`Take me to UG` is the only time when Dook uses internet connection to take you to the User Guide. Otherwise, Dook is offline for most of its uses.
</div>


**Format:** `help`

**Instruction:**
1. Type `help` in the `Command Box` to open this window,
2. Or, press `Help` Button on the main interface.

It will open a window similar to this:

![help message](images/HelpWindow.png)

[Back To Top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------
## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add -n NAME`, `NAME` is a parameter which can be used as `add -n John Doe`.

* Items in square brackets are optional.<br>
  e.g `-n NAME [-t TAG]` can be used as `-n John Doe -t friend` or as `-n John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[-t TAG]…​` can be used as ` ` (i.e. 0 times), `-t friend`, `-t friend -t family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `-n NAME -p PHONE_NUMBER`, `-p PHONE_NUMBER -n NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>
### Contact Management

#### Adding a contact: `add`

**Situation:** With every contact book, we need to be able to create contacts. You have just made a new friend in your tutorial and
decided to save his contact for future collaboration purposes.

```
add -n NAME [-p PHONE_NUMBER] [-e EMAIL] [-a ADDRESS] [-t TAG…​]
```

| Param            | Remarks                                                                                                        |
|------------------|----------------------------------------------------------------------------------------------------------------|
| **NAME**         | Must be non-null and unique                                                                                    |
| **PHONE_NUMBER** | Optional, only numbers and no minimum number of digits                                                         |
| **EMAIL**        | Optional, follow standard email formats (i.e xxx@xxx)                                                          |
| **ADDRESS**      | Optional                                                                                                       |
| **TAG**          | Optional, each tag should start with -t (i.e. for two tags `friend`, `groupmate` use `-t friend -t groupmate`) |

<div markdown="block" class="alert alert-danger">
:exclamation: **Warning** <br>

Currently, Dook doesn't have the ability to recognise abbreviations (with a forward slash) such as d/o or s/o in the **_NAME_** parameter, so 
it might return an error.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**

A person can have any number of tags (including 0)
</div>

<div markdown="block" class="alert alert-info">
:information_source: **Information**

**null** means empty!
</div>

For example:
* `add -n John Doe -p 98765432 -e johnd@example.com -a John street, block 123, #01-01`
* `add -n Betsy Crowe -t friend -e betsycrowe@example.com -a Newgate Prison -p 1234567 -t criminal`

Below shows the successful output upon executing `add` command:

![Success Add Command](images/AddCommandSucess.png)

Below shows the contact list upon successful adding of contact:

![Success Add Command Contact](images/AddCommandContactsSuccess.png)

In the event that the command entered is **invalid**, the below error message will be shown:

![Invalid Add Command Contact](images/AddCommandInvalid.png)

In the event that there is an **existing user** in the contact book, the below error message will be shown:

![Duplicate Add Command Contact](images/AddCommandDuplicate.png)

#### Adding a Professor `prof`

**Situation:** You have just taken CS2040S and you now have a favorite Professor in SoC! You would like to stay in contact with them and have their updated contact details at
your fingertips.

To add a specific Professor to the Dook,

```
prof -n NAME
```

| Param            | Remarks                                                |
|------------------|--------------------------------------------------------|
| **NAME**         | Must be non-null and unique (and must be from NUS SoC) |

Examples:
* `prof -n aaron`

![Prof Aaron Contact](images/profaaron.png)

You can also easily add all SoC staff faculty to Dook with one command:

```
prof -a
```


<div markdown="block" class="alert alert-warning">
:exclamation: **Caution** <br>

While adding all professors is included as feature, we generally advise against this. You might find adding professors individually more useful unless you decide
having the whole SoC staff faculty in your contact book is necessary!

</div>

<div markdown="span" class="alert alert-danger">
:exclamation: **Warning:** <br>


The `prof -a` command takes a bit of time to load all the data, as we are adding over 300+ contacts into Dook. 
We recommend that upon running this command, you as a user should **wait a few seconds** and not force close the application or run other commands
as it could lead to unexpected behaviors. Our team is aware of this and is looking into a more efficient solution to add all professors!

</div>

#### Listing all contacts : `list`

**Situation:** You decided one day to touch base with all your course-mates and friends in NUS.

This command lets you easily view all the people in your contacts!

Format: `list`

Below shows the successful output upon executing `list`:

![List Command Success](images/ListCommandSuccess.png)

Below shows the contact list upon executing `list`:

![List Command Contact Success](images/ListCommandContacts.png)

#### Editing a contact : `edit`

**Situation:** You just had a zoom call with an old friend and realised he changed his phone number because he had
migrated overseas.

The command allows you to update an existing contact's details.

```
edit INDEX [-n NAME] [-p PHONE] [-e EMAIL] [-a ADDRESS] [-t TAG]…​
```

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* **At least one** of the optional fields must be provided.
* Existing values will be updated to the input values.

| Param            | Remarks                                                                                                        |
|------------------|----------------------------------------------------------------------------------------------------------------|
| **INDEX**        | Must be an integer in the range [1, number of contacts displayed]                                              |
| **NAME**         | Optional                                                                                                       |
| **PHONE_NUMBER** | Optional, only numbers and no minimum number of digits                                                         |
| **EMAIL**        | Optional, follow standard email formats (i.e xxx@xxx)                                                          |
| **ADDRESS**      | Optional                                                                                                       |
| **TAG**          | Optional, each tag should start with -t (i.e. for two tags `friend`, `groupmate` use `-t friend -t groupmate`) |

Examples:
* `edit 1 -p 91234567 -e johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
* `edit 2 -n Betsy Crower -t` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

Below shows the current state of a contact information before updating:

![Success Add Command Contact](images/AddCommandContactsSuccess.png)

Below would be the expected output upon executing the command `edit 1 -n John Lim -p 23456789 -a 311, Rochor Ave 1, #01-01, johnl@example.com -t friend`,

![Success Edit Command](images/EditCommandSuccess.png)

Below shows the updated state of the contact information after updating:

![Success Edit Command Contact](images/EditCommandContactsSuccess.png)

<div markdown="block" class="alert alert-info">:information_source: **Information**

When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.

</div>

#### Locating contacts by name: `find`

**Situation:** You have just met a wonderful group of NUS students at a networking event, and you've added their details to the
contact book. A few days later, you want to send a follow-up email to one of them, but their name escapes you. You remember
it started with "John".

This command allows you to quickly retrieve all names that match, ensuring you can maintain that crucial connection without
a hitch.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

<div markdown="block" class="alert alert-info">
:information_source: **Information**

For now, we can only `find` contacts by name - future implementations would include finding by other fields as well,
so stay tuned!
</div>

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>

Below shows all the current contacts in our contact list, say we have 3 contacts, `John Doe`, `Peter Doe` and `Sarah Jacobs`:

![List Command Contact Success](images/ListCommandContacts.png)

Say we only want contacts with "John" in our contact list, we shall execute `find John` to achieve this.

Below shows the expected output after running the command, there is only 1 contact with `John` in their name:

![Find Command Success](images/FindCommandSuccess.png)

Below shows the expected contact list after running the command:

![Find Command Contact Success](images/FindCommandContactsSuccess.png)

<div markdown="block" class="alert alert-info">:information_source: **Information**

This command will also fetch all existing Professors in the contact book if there is a match!

</div>

#### Deleting a contact : `delete`

**Situation:** Your contact book is starting to look cluttered, and you realise you no longer certain contacts' details.

This command deletes the specified person from the contact book, ensuring your contacts remain relevant and up-to-date.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive number** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.

Below shows the current state of our contact list:

![Delete Command Contacts Before](images/DeleteCommandContactsBefore.png)

Say we want to remove `Sarah Jacobs` from our contact list, as she migrated overseas to pursue her masters, and we lost contact.
We observe that she is index number **3** in our contact list. As such, we will run `delete 3` in our command box.

Below is the expected output after running `delete 3`:

![Delete Command Success](images/DeleteCommandSuccess.png)

Below is the expected contact list after running `delete 3`, we observe `Sarah Jacobs` no longer exists in our contact list.

![Delete Command Contacts Success](images/DeleteCommandContactsSuccess.png)

<div markdown="block" class="alert alert-success">
:bulb: **Tips**

`find John` followed by `delete 1` deletes the 1st person with the name `John`.

</div>
<br>
<div markdown="block" class="alert alert-danger">

**:exclamation: Be careful!**<br>

This command is **irreversible**, the deleted contact information will be lost!

</div>

[Back To Top](#table-of-contents)

<div style="page-break-after: always;"></div>
### Booking Management

#### Adding a booking : `book`

**Situation:** Dook allows you to keep track of **all** your consultations, so you never have to worry above forgetting them! 
Say you booked a consultation in the next week, and you would like to keep track of it. The `book` command is for you!

```
book -n DESCRIPTION -s START_TIME -e END_TIME -note NOTE
```
* Duplicate bookings are not allowed! This means that across two bookings, you cannot have all four params to be the exact same.
* For now: start and end time formats must be in `yyyy-mm-dd hh:mm` (we are working to expand this!)

| Param           | Remarks                                  |
|-----------------|------------------------------------------|
| **DESCRIPTION** | Must be non-null                         |
| **START_TIME**  | Must follow format of `2023-12-31 19:00` |
| **END_TIME**    | Must follow format of `2023-12-31 19:00` |
| **NOTE**        | Must be non-null                         |

Examples:
* `book -n CS2101 Consult -s 2023-12-31 19:00 -e 2023-12-31 23:00 -note DO HOMEWORK`

Below shows our original dashboard before adding a booking:

![Before Booking](images/SampleUi.png)

Say we booked a consultation slot a week later, and we would like to add it to **Dook** in case we forget.

Below shows the expected output after executing the command `book -n CS2101 Consult -s 2023-12-31 19:00 -e 2023-12-31 23:00 -note DO HOMEWORK`.

![Book Command Success](images/BookCommandSuccessList.png)

Below shows the expected success message upon executing the above command. 

![Book Command Success Message](images/BookCommandSuccessMessage.png)

#### Updating bookings: `update`

**Situation:** The Professor took a rain-check and decided to reschedule your consult. Now we need to update our booking details!

```
update INDEX -n {DESCRIPTION} -s {START_TIME} -e {END_TIME} -note {NOTE}
```
* The index refers to the index number shown in the displayed booking list.
* Other params are optional and entered only if you want to update current data.

| Param           | Remarks                                            |
|-----------------|----------------------------------------------------|
| **INDEX**       | Refers to currently displayed bookings             |
| **DESCRIPTION** | Optional                                           |
| **START_TIME**  | Optional, Must follow format of `2023-12-31 19:00` |
| **END_TIME**    | Optional, Must follow format of `2023-12-31 19:00` |
| **NOTE**        | Optional                                           |

Examples:
* `update -1 -s 2024-01-02 19:00 -e 2024-01-02 23:00 -note DO HOMEWORK`

Below shows our current booking that we scheduled for next week.

![Book Command Success](images/BookCommandSuccessList.png)

The Professor decides to postpone the consult to two days later, we shall execute the command `update 1 -s 2024-01-02 19:00 -e 2024-01-02 23:00 -note DO HOMEWORK`.

Below shows the updated booking upon executing the command.

![Update Command Success](images/UpdateCommandSuccessList.png)

Below shows the success message upon executing the command.

![Update Command Success Message](images/UpdateCommandSuccessMessage.png)

<div markdown="block" class="alert alert-warning">
:exclamation: **Caution** <br>

The date must exist on the calendar, so **31st Feb** or **31st Apr** would not be allowed!

</div>

#### Cancelling a booking : `cancel`

**Situation:** You realised that you are not available on the current booking date, and you have apologised to the Professor to cancel the booking altogether.
We shall use the `cancel` command to remove a booking from Dook. 

```
cancel INDEX
```

* Deletes the booking at the specified `INDEX`.
* The index refers to the index number shown in the displayed booking list.

Examples:
* `cancel 1` cancels the 1st booking shown in the booking list.

Below shows our current bookings in Dook.

![Update Command Success](images/UpdateCommandSuccessList.png)

We decide to cancel the CS2101 Consult altogether. We notice that the `index` of the booking is **1**. 
We shall use `cancel 1` to remove this booking from Dook.

Below shows our current bookings after executing `cancel 1`.

![Cancel Command Success](images/CancelCommandSuccessList.png)

Below shows the success message upon executing the command.

![Cancel Command Success Message](images/CancelCommandSuccessMessage.png)

<div markdown="block" class="alert alert-success">
:bulb: **Tips**

You might want to use [search](#searching-for-a-booking--search) to display the booking in the GUI first to easily find its INDEX.
</div>

#### Clearing all bookings entries : `cancel -a`

**Situation:** Want a fresh start from our busy schedule? You can quickly clear all your bookings with:

 ```
 cancel -a
 ```

After executing the command above, your [GUI](#glossary) will look similar to the below.
![Cancel All](images/CancelAllCommandSuccess.png)

<div markdown="block" class="alert alert-danger">

**:exclamation: Be careful!**<br>

This command is **irreversible**, and all your data will be lost.
Please use this command with caution!

</div>


#### Searching for a booking : `search`

**Situation:** You have multiple consultations lined up and decide to search for your CS2103 consult. We shall use the 
`search` command to find our CS2103 consultation details!

```
search KEYWORD [MORE_KEYWORDS]
```

* The search is case-insensitive. e.g `coNsUlT` will match `Consult`
* The order of the keywords does not matter. e.g. `consult CS2103` will match `CS2103 Consult`
* Bookings matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Consult` will return `CS2103 Consult`, `CS5300 Consult`

So, let's try to find `CS2103T Consultation` using the `search` command. Here's the initial window
that will be displayed in case you have a list of consultations.

![List of Consult](images/SearchCommandSampleBookings.png)

Now, after executing the `search` command, if the consultation you're trying to find
**exists**, it will be displayed like the sample image shown below.

![Search Command Success](images/SearchCommandSuccess.png)

And, in case the booking **doesn't** exist, Dook will throw you an error (such as the one below) indicating that 
it couldn't find any such bookings in the [JSON](#glossary) file.

![Search Command Error](images/SearchCommandError.png)

<div markdown="block" class="alert alert-success">
:bulb: **Tips**

Want to see all your bookings again? Try the [view command](#viewing-all-bookings--view) .
</div>

#### Viewing all bookings : `view`

**Situation:** You are done searching for your CS2103 consult and decide to refresh your memory of all your consults!
We shall use the `view` command to list all our current bookings!

```
view
```
![View Command Success](images/ViewCommandSuccess.png)

[Back To Top](#table-of-contents)

### Other features

####  Changing themes in Dook : `theme`

Dook comes preinstalled with a light and dark theme.

Format: `theme -bg THEME` 

* Changes the current theme to either dark, light or any other theme. 
* Dark theme is the *default* on a new launch
* Dook remembers your preferences, it loads the most recent selected theme on launch.

Examples:
* `theme -bg light`

Below shows the application **before** executing `theme -bg light`:

![Dark Theme](images/darktheme.png)

Below shows the application **after** executing `theme -bg light`:

![Light Theme](images/lighttheme.png)

Below shows the error message upon executing an invalid theme: 

![Theme_Command_Failure](images/themefailure.png)


<div markdown="block" class="alert alert-info">:information_source: **Information**

New themes are currently being added. In v1.5, we envisioned to create a tool for users to create their own theme from the
`command box` itself.
</div>

#### Adding aliases in Dook : `alias`

For commands that you use often, Dook allows the aliasing of them to any input of your choice.

```
alias -al NEW_COMMAND -r COMMAND_TO_REPLACE
```

| Param                  | Remarks                                          |
|------------------------|--------------------------------------------------|
| **NEW_COMMAND**        | The new string you would like to use as an alias |
| **COMMAND_TO_REPLACE** | The original command that you want an alias for  |

* For example, if you are often swapping between themes, you can replace `theme -bg light` with `light` using the command below <br>
```alias -al light -r theme -bg light```
* After that, you can swap to light theme anytime with just `light`

![Alias Command Success](images/AliasCommandSuccess.png)

After adding the alias above, you can simply type `light` in the `command box` to change the theme.
Isn't that cool?

<div markdown="block" class="alert alert-success">
:bulb: **Tips**

Try adding some more aliases and see how Dook responds efficiently! Remember to 
replace the whole command such as `theme -bg light` otherwise it won't work as expected.
</div>

<div markdown="block" class="alert alert-warning">
:exclamation: **Caution** <br>

`alias` can overwrite any commands and will take precedence, and cannot be deleted for now. Use with caution!

</div>

<div markdown="block" class="alert alert-danger">
:exclamation: **Warning** <br>

**This feature is meant for advanced users, please be careful**

This feature is still in beta, note:
* Aliases **cannot** be deleted as of the current version
* Aliases must be for the entire command (i.e. cannot replace `add -n` with `addn`)
</div>


#### Exiting the program : `exit`

Exits the program.

Format: `exit`

#### Saving the data

Dook's [address book](#glossary) data are saved automatically after any command that changes the data. There is no need to save it manually.

#### Editing the data file

Dook's data is saved automatically as a [JSON](#glossary) file:<br> `[Dook JAR file location]/data/addressbook.json`. 

<div markdown="block" class="alert alert-success">
:bulb: **Tips**

**Advanced** users are welcome to update data directly by editing the json data file.
</div>

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, Dook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it. 

Furthermore, certain edits can cause **Dook** to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

[Back To Top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I install Java 11?<br>
**A**: Follow this [link](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A) for steps to download Java 11.

**Q**: How do I transfer my data to another Computer?<br>
**A**: Go to the application's home directory and copy the `data/addressbook.json` file containing your data into the empty
data folder created by Dook on the other computer.

**Q**: Oh no! I have accidentally closed Dook without using the `exit` command? Do I lose all my data?<br>
**A**: Not to worry! Dook automatically saves all data after every change, so no data will be lost!

**Q**: Do I need Internet connection to use Dook?<br>
**A**: **Only once** when opening the User Guide using `Take me to UG` link in [Help Window](#help-window). Otherwise, Dook works fully offline!

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command Summary

<div markdown="block" class="alert alert-info">
:information_source: **Note:**

The list of valid commands accept **only lowercase letters**. For example, `Book` will not be accepted. Please use `book` instead.
</div>

### Address Book Command summary

| Action            | Format, Examples                                                                                                                                                                      |
|-------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**           | `add -n NAME [-p PHONE_NUMBER] [-e EMAIL] [-a ADDRESS] [-t TAG]…​` <br> e.g., `add -n John Doe -p 22224444 -e jamesho@example.com -a 123, Clementi Rd, 1234665 -t friend t/colleague` |
| **Add Professor** | `prof -n NAME` or `prof -a`                                                                                                                                                           |
| **Delete**        | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                   |
| **Edit**          | `edit INDEX [-n NAME] [-p PHONE_NUMBER] [-e EMAIL] [-a ADDRESS] [-t TAG]…​`<br> e.g.,`edit 2 -n James Lee -e jameslee@example.com`                                                    |
| **Find**          | `find KEYWORD [MORE_KEYWORDS…​]`<br> e.g., `find James Jake`                                                                                                                          |
| **List**          | `list`                                                                                                                                                                                |
| **Clear**         | `clear`                                                                                                                                                                               |
| **Help**          | `help`                                                                                                                                                                                |

[Back To Top](#table-of-contents)

### Booking List Command summary

| Action     | Format, Examples                                                                                                                     |
|------------|--------------------------------------------------------------------------------------------------------------------------------------|
| **Book**   | `book -n DESCRIPTION -s START_TIME -e END_TIME` <br> e.g., `book -n Consult with Prof Aaron -s 2024-03-01 19:00 -e 2024-03-01 23:00` |
| **View**   | `view`                                                                                                                               |
| **Update** | `update INDEX [-n DESCRIPTION] [-s START_TIME] [-e END_TIME]`<br> e.g.,`edit 2 -n Prof Aaron's Consultation -s 2024-03-01 14:30`     |
| **Search** | `search KEYWORD [MORE_KEYWORDS]`<br> e.g., `search Prof Lee's Consultation`                                                          |
| **Cancel** | `cancel INDEX` or `cancel -a`<br> e.g., `cancel 2`                                                                                   |


[Back To Top](#table-of-contents)

## Glossary

| Term                                                                                                                                                                 | Meaning                                                                                                                                                                                                                                                                                      |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **[Address Book (for Dook)](https://en.wikipedia.org/wiki/Command-line_interface)**                                                                                  | A json file that saves all the data regarding contacts and consultations.                                                                                                                                                                                                                    |
| **[CLI (Command Line Interface)](https://en.wikipedia.org/wiki/Command-line_interface)**                                                                             | A text-based interface where users type in commands instead of interacting with the application's graphics.                                                                                                                                                                                  |
| **[CSV](https://en.wikipedia.org/wiki/Comma-separated_values)**                                                                                                      | A text file format that uses commas to separate values. It is supported by a wide range of software, including Microsoft Excel.                                                                                                                                                              |
| **[Command](https://en.wikipedia.org/wiki/Command_(computing))**                                                                                                     | A line of instructions that you input into the command box. Also see: Command Box                                                                                                                                                                                                            |
| **[Command Box](https://www.codecademy.com/articles/command-line-commands)** <a name="command-box"></a>                                                              | A box for you to input commands.                                                                                                                                                                                                                                                             |
| **[Command Output Box](https://stackoverflow.com/questions/3038392/do-you-know-any-command-line-http-fetching-utility-like-wget)** <a name="command-output-box"></a> | A box that displays the results of the command you keyed in. It will tell you whether the command you entered has successfully run, or if there is an error in your command that needs to be fixed. Refer to []() for a picture.                                                             |
| **Contact List** <a name="contact-list"></a>                                                                                                                         | The Contact list is the list of contacts on the left side of the application.                                                                                                                                                                                                                |
| **Booking List** <a name="booking-list"></a>                                                                                                                         | The Booking list is the list of bookings on the right side of the application.                                                                                                                                                                                                               |
| **[GUI (Graphic User Interface)](https://en.wikipedia.org/wiki/Graphical_user_interface)**                                                                           | A graphical based interface where users interact with the application's graphics like buttons or scroll panes. Also see: CLI                                                                                                                                                                 |
| **[JSON](https://www.json.org/json-en.html)**                                                                                                                        | A JSON (JavaScript Object Notation) file is a lightweight data interchange format that's easy for humans to read and write and easy for machines to parse and generate. JSON files typically use the `.json` extension and consist of key/value pairs similar to JavaScript object literals. |
| **[Prefix](https://techterms.com/definition/prefix)**                                                                                                                | A letter or phrase before an input.                                                                                                                                                                                                                                                          |
| **[Tag](https://en.wikipedia.org/wiki/Tag_(metadata))**                                                                                                              | A text phrase used to categorize employees by. A tag must be either a Student, Professor, or Teaching Assistant (TA)                                                                                                                                                                         |
| **[Index](https://en.wikipedia.org/wiki/Index_(computer_science))**                                                                                                  | The number labeling each employee in the employee list.                                                                                                                                                                                                                                      |
| **[Web browser](https://www.mozilla.org/en-US/firefox/new/)**                                                                                                        | An application to serve the web like Internet Explorer, Google Chrome, or Firefox. In fact, you are probably using one to access this guide right now!                                                                                                                                       |



[Back To Top](#table-of-contents)
