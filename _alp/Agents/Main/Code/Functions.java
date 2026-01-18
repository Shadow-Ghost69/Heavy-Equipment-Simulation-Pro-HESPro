void requestService(HeavyEquipmentUnit unit)
{/*ALCODESTART::1337331570802*/
//if this unit already has asked for mantenance - remove that request as lower priority 
if( pmRequests.contains( unit ) )
	pmRequests.remove( unit );
//if some service crew is already handling this unit - ignore request
for( MaintenanceServiceCrew msc : maintservice ) 
	if( msc.heavyequipmentUnit == unit )
		return;
//add service request to the queue
serviceRequests.addLast( unit );
//and make all service crews check the request queue
for( MaintenanceServiceCrew msc : maintservice ) 
	send("CHECK REQUEST QUEUE", msc);
/*ALCODEEND*/}

void requestPM(HeavyEquipmentUnit unit)
{/*ALCODESTART::1337345038232*/
//if this unit already has asked for service - no need to leave request for mechanic 
if( serviceRequests.contains( unit ) )
	return;
//if some service crew is already handling this unit - ignore request
for( MaintenanceServiceCrew msc : maintservice ) 
	if( msc.heavyequipmentUnit == unit )
		return;
//add PM request to the queue
pmRequests.addLast( unit );
//and make all service crews check the request queue
for( MaintenanceServiceCrew msc : maintservice ) 
	send("CHECK REQUEST QUEUE", msc);
/*ALCODEEND*/}

HeavyEquipmentUnit getRequest()
{/*ALCODESTART::1337774778073*/
//first check failures - higher priority
if( ! serviceRequests.isEmpty() )
	return serviceRequests.removeFirst(); 
else //then check preventive maintenance (PM) - lower priority
	return pmRequests.removeFirst();
/*ALCODEEND*/}

boolean thereAreRequests()
{/*ALCODESTART::1337774842416*/
return ! serviceRequests.isEmpty() || ! pmRequests.isEmpty();
/*ALCODEEND*/}

double navigate(ViewArea viewArea)
{/*ALCODESTART::1488807799356*/
selectedViewArea = viewArea;
viewArea.navigateTo();
groupMainMenu.setPos( viewArea.getX(), viewArea.getY() );
/*ALCODEEND*/}

