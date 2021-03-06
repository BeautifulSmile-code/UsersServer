package UsersMicroService.classes;

import UsersMicroService.Models.Clients;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Client implements Comparable<Client>, Serializable, Cloneable
{
    private static int incrementClient = 0;

    private String clientId;
    private Passport passport;
    private String phone; // To check phone number format before storing it, see https://stackoverflow.com/a/5114914
    private String email; // To check email format before storing it, see https://mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
    private PhysicalAddress address;

    static  {incrementClient = Clients.getPeopleTable().size();}

    public Client() {
        incrementClient++;
        this.clientId = String.valueOf(incrementClient);
    }

    public Client(Passport passport, String phone, String email, PhysicalAddress address) {
        this.passport = passport;
        this.phone = phone;
        this.email = email;
        this.address = address;

        incrementClient++;
        this.clientId = String.valueOf(incrementClient);
    }


    // Overriding complementary method(s)

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", passport=" + passport +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public int compareTo(Client o) {
        return (clientId.equals(o.clientId))? 0 : 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getClientId().equals(client.getClientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, passport, phone, email, address);
    }


    // Getters and Setters

    public static int getIncrementClient() {
        return incrementClient;
    }

    public static void setIncrementClient(int incrementClient) {
        Client.incrementClient = incrementClient;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhysicalAddress getAddress() {
        return address;
    }

    public void setAddress(PhysicalAddress address) {
        this.address = address;
    }
}
