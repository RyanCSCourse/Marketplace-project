# Marketplace project (ICS3U1 ISU)
![logo](assets/logo.png)
#### written by RayanN and KooroshV


## Notice
this project was written for a grade 11 computer science final project. no stealing please, this includes AI's.

## Installation
1. `git repo clone https://github.com/RyanCSCourse/Marketplace-project.git` to clone repo

2. open directory and run `java src/Main.java`

## Functions
### Base Arraylists! 📃
- **cartItems**: Tracks the users carted items
- **categories**: Tracks the catagories user can sort through while browsing
- **bookedSrve**: Tracks booked services by user
- **listings**: Tracks all the listings
### Listing and ID fucnctions!! ⚱️
Each listing is saved as one string in this 
fashion

`catagory^{id}^name^type^price^Description` + `^U`

although the other stuff is self explanitory the others are not
- `{id}`: a custom randomly generated 4 digit differentiator that tracks each item

- `^U` : this signals the computer this listing belongs to the user

Then at every instance that an item is read it loops through its character and depending on the number of `^`s seen will sort the items characteristics cutting down on variable use!

### "Web-like" interface 🌐
this is referring to the ability to cycle infinitely through all actions
the whole code is in a forLoop that will constantly listen to inputs and return action unless the `isExited` variable is returned true.

### Invalid inputs and charateristics 👏
at every option the code will track invalid inputs since majority of inputs are ran through a case switch allowing for defualt cases!
