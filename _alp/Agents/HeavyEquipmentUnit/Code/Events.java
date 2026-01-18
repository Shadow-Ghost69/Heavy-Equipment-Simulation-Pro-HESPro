void PMTimer()
{/*ALCODESTART::1741667953298*/
//When PM time is due, then request the PM.
main.requestPM( this );
/*ALCODEEND*/}

void HEqStartTime()
{/*ALCODESTART::1742520478141*/
if (getHour() == 8) { // = 8 AM (Due to the office hours are 8:00 AM - 5:00 PM)
    dataCollectionHEq.start(); // start the collection data
}
/*ALCODEEND*/}

void HEqEndTime()
{/*ALCODESTART::1742520552960*/
if (getHour() == 17) { // 17 = 5 PM (Due to the office hours are 8:00 AM - 5:00 PM)
    dataCollectionHEq.stop(); // stop the collection data
}
/*ALCODEEND*/}

