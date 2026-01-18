double TimeToFailure()
{/*ALCODESTART::1741667953281*/
double timesincepm = time() - TimeLastPM;

double pmoverduefactor = max( 1, timesincepm / PMPeriod );
double agefactor = max( 1, Age() / ( 3 * PMPeriod ) );

return exponential( NormalFailureRate * pmoverduefactor * agefactor );
/*ALCODEEND*/}

Color Color()
{/*ALCODESTART::1741667953286*/
if( inState( OnRunning ) ) {
	if( PMTimer.isActive() )
		return lime; //working and prevented maintenance not needed
	return yellow; //working but prevented maintenance is due
} else if( inState( Failed ) ) {
	return red; //falied, waiting for the mechanic (maintenance service) crew
} else {
	return peru; //being serviced (repaired or replaced)
}
/*ALCODEEND*/}

double Age()
{/*ALCODESTART::1741667953288*/
return time() - TimeLastReplacement;
/*ALCODEEND*/}

