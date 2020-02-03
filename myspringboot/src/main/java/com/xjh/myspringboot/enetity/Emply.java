package com.xjh.myspringboot.enetity;

import java.io.Serializable;
import java.util.Date;

public class Emply implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emply.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emply.user_name
     *
     * @mbg.generated
     */
    private String user_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emply.user_brithday
     *
     * @mbg.generated
     */
    private Date user_brithday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emply.age
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emply.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table emply
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emply.id
     *
     * @return the value of emply.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emply.id
     *
     * @param id the value for emply.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emply.user_name
     *
     * @return the value of emply.user_name
     *
     * @mbg.generated
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emply.user_name
     *
     * @param user_name the value for emply.user_name
     *
     * @mbg.generated
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emply.user_brithday
     *
     * @return the value of emply.user_brithday
     *
     * @mbg.generated
     */
    public Date getUser_brithday() {
        return user_brithday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emply.user_brithday
     *
     * @param user_brithday the value for emply.user_brithday
     *
     * @mbg.generated
     */
    public void setUser_brithday(Date user_brithday) {
        this.user_brithday = user_brithday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emply.age
     *
     * @return the value of emply.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emply.age
     *
     * @param age the value for emply.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emply.address
     *
     * @return the value of emply.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emply.address
     *
     * @param address the value for emply.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emply
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Emply other = (Emply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUser_name() == null ? other.getUser_name() == null : this.getUser_name().equals(other.getUser_name()))
            && (this.getUser_brithday() == null ? other.getUser_brithday() == null : this.getUser_brithday().equals(other.getUser_brithday()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emply
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUser_name() == null) ? 0 : getUser_name().hashCode());
        result = prime * result + ((getUser_brithday() == null) ? 0 : getUser_brithday().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emply
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user_name=").append(user_name);
        sb.append(", user_brithday=").append(user_brithday);
        sb.append(", age=").append(age);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Emply() {
    }

    public Emply(String user_name, Date user_brithday, Integer age, String address) {
        this.user_name = user_name;
        this.user_brithday = user_brithday;
        this.age = age;
        this.address = address;
    }
}