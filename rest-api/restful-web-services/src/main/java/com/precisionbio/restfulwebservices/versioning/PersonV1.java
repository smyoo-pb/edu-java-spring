package com.precisionbio.restfulwebservices.versioning;

public class PersonV1 {
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param name
     */
    public PersonV1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonV1 [name=" + name + "]";
    }

}
