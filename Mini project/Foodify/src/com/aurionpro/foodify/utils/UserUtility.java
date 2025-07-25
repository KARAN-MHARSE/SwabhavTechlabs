package com.aurionpro.foodify.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.aurionpro.foodify.models.DeliveryAgent;
import com.aurionpro.foodify.models.User;

public class UserUtility {
	public static User getUserByEmailId(Map<UUID, User> users, String userEmail) {		
		if (users == null || userEmail == null || userEmail.trim().isEmpty()) {
            return null; 
        }
		
		for(Map.Entry<UUID,User> entry : users.entrySet()) {
			if(entry.getValue().getEmail().trim().equalsIgnoreCase(userEmail.trim())) {
				return entry.getValue();
			}
		}
		return null;
		
	}
	
	public static List<User> getDelieveryBoysList(Map<UUID,User> users){
		if(users== null || users.isEmpty()) return null;
		List<User> deliveryAgents = new ArrayList<User>();
		
		for(Map.Entry<UUID,User> entry : users.entrySet()) {
			if(entry.getValue() instanceof DeliveryAgent) {
				deliveryAgents.add(entry.getValue());
			}
		}
		return deliveryAgents;
		
	}
	
	public static User getDeliveryAgentById(Map<UUID,User> users , UUID deliveryAgentId) {
		if(users== null || users.isEmpty()) return null;

		if(users.containsKey(deliveryAgentId)) {
			return users.get(deliveryAgentId);
		}
		
		return null;
	}

}
