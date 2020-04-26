package com.smart.basic.complicating;
//Read-only objects don't require synchronization
class Customer{
    private final int serviceTime;
    public Customer(int tm){serviceTime=tm;}

    public int getServiceTime() {
        return serviceTime;
    }

}
public class BankTellerSimulation {
}
