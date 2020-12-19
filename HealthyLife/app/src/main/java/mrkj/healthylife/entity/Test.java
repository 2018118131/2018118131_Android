package mrkj.healthylife.entity;

/**
 *
 */
public class Test {
    private String address;
    private String age;
    private String name;


    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;

    }

    @Override
    public String toString() {

        String str = "【address】" + address + "\t\t【age】"+age + "\t\t【name】" + name;
        return str;
    }
}
