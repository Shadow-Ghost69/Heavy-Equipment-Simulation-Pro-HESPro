void MSCWorkingTimeStart()
{/*ALCODESTART::1742525123374*/
if (getHour() == 8) { // = 8 AM (Due to the office hours are 8:00 AM - 5:00 PM)
    dataCollectionMSC.start(); // start the collection data
}
/*ALCODEEND*/}

void MSCWorkingTimeEnds()
{/*ALCODESTART::1742525179129*/
if (getHour() == 17) { // 17 = 5 PM (Due to the office hours are 8:00 AM - 5:00 PM)
    dataCollectionMSC.stop(); // stop the collection data
}
/*ALCODEEND*/}

