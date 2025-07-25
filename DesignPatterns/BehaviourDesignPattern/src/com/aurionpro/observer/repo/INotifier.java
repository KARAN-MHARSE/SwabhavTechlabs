package com.aurionpro.observer.repo;

import com.aurionpro.observer.enums.NotificationType;

public interface INotifier {
	void sendNotification(double amount, NotificationType type);

}
