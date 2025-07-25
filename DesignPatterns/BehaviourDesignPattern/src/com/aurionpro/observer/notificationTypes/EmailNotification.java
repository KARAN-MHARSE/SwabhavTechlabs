package com.aurionpro.observer.notificationTypes;

import com.aurionpro.observer.enums.NotificationType;
import com.aurionpro.observer.repo.INotifier;

public class EmailNotification  implements INotifier{
	@Override
	public void sendNotification(double amount,NotificationType type) {
		if(type.equals(NotificationType.Credit)) {
			System.out.println(amount+ " successfuly credited to account : Email");
			return;
		}
		if(type.equals(NotificationType.Debit)) {
			System.out.println(amount+ " successfuly debited from account : Email");
			return;
		}
		
		
	}
}
