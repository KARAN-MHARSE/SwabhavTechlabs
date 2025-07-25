package com.aurionrpo.abstractfactory;

interface Car {
	void start();
	void stop();
}

class Maruti implements Car {
	public void start() {
		System.out.println("Maruti car start");
	}
	public void stop() {
		System.out.println("Maruti car stopped");

	}
}
class Tata implements Car {
	public void start() {
		System.out.println("Tata car start");
	}
	public void stop() {
		System.out.println("Tata car stapped");

	}
}

class Mahindra implements Car {
	public void start() {
		System.out.println("Mahindra car start");
	}
	public void stop() {
		System.out.println("Mahindra car stapped");

	}
}

abstract class Builder {
	abstract Car buildCar();
}
class MarutiBuilder extends Builder {

	@Override
	Car buildCar() {
		// TODO Auto-generated method stub
		return new Maruti();
	}

}
class TataBuilder extends Builder {

	@Override
	Car buildCar() {
		// TODO Auto-generated method stub
		return new Tata();
	}

}

class MahindraBuilder extends Builder {

	@Override
	Car buildCar() {
		// TODO Auto-generated method stub
		return new Mahindra();
	}

}

class CarBuilder {
	public Car getCar(Builder builder) {
		return builder.buildCar();
	}
}

public class Main {
	public static void main(String args[]) {
		Builder marutiCarBuilder = new MahindraBuilder();
		CarBuilder carBuilder = new CarBuilder();
		Car car1 = carBuilder.getCar(marutiCarBuilder);
		car1.start();
	}
}
