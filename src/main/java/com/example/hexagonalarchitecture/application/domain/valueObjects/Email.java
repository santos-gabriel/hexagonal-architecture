package com.example.hexagonalarchitecture.application.domain.valueObjects;

import com.example.hexagonalarchitecture.application.domain.exceptions.InvalidEmailException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX  = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private String value;
    Email() {}

    public Email(String email) {
        this.value = Objects.nonNull(email) ? email : "";
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value);
        if (!matcher.find()) {
            throw new InvalidEmailException();
        }
    }

    public String getValue() {
        return this.value;
    }

    public boolean isInvalid() {
        return !isValid();
    }

    public boolean isValid() {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value);
        return matcher.find();
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Email other = (Email) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
