void endOfYear()
{/*ALCODESTART::1338211639361*/
//Record the year results
endYearHEqOnRunning.add( statsHEqOnRunning.mean() );
endYearHEqOnPM.add( statsHEqOnPM.mean() );
endYearHEqOnService.add( statsHEqOnService.mean() );
endYearHEqFailed.add( statsHEqFailed.mean() );

endYearMaintServStandByAtOffice.add( statsMaintServStandByAtOffice.mean() );
endYearMaintServOnTheWay.add( statsMaintServOnTheWay.mean() );
endYearMaintServWorkingAtField.add( statsMaintServWorkingAtField.mean() );

double yearrevenue = statsHEqOnRunning.mean() * (MonthlyRevenuePerUnit *12);
double yearexpenses = statsMaintServSize.mean() * ( MonthlyMSCSalaryCost *12 ) + HeavyEquipmentCost;
endYearRevenue.add( yearrevenue / 1000000 );
endYearExpenses.add( yearexpenses / 1000000);
endYearProfit.add(( yearrevenue - yearexpenses ) / 1000000);

//Reset the stats
statsHEqOnRunning.reset();
statsHEqOnPM.reset();
statsHEqOnService.reset();
statsHEqFailed.reset();

statsMaintServSize.reset();
statsMaintServStandByAtOffice.reset();
statsMaintServOnTheWay.reset();
statsMaintServWorkingAtField.reset();

HeavyEquipmentCost = 0;
/*ALCODEEND*/}

