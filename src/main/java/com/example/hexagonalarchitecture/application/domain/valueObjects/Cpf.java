package com.example.hexagonalarchitecture.application.domain.valueObjects;

import com.example.hexagonalarchitecture.application.domain.exceptions.InvalidCpfException;

import java.util.InputMismatchException;
import java.util.Objects;

public class Cpf {
    private String value;

    Cpf() {}

    public Cpf(String cpf) {
        this.value = Objects.nonNull(cpf) ? cpf : "";
        if (isValid()) {
            throw new InvalidCpfException();
        }
    }

    public String getValue() {return this.value;}

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
        Cpf other = (Cpf) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    public boolean isInvalid() {
        return !isValid();
    }

    public boolean isValid() {
        // CPF's formed by a sequence of equal numbers are considered an error
        if (getValue().equals("00000000000") ||
                getValue().equals("11111111111") ||
                getValue().equals("22222222222") || getValue().equals("33333333333") ||
                getValue().equals("44444444444") || getValue().equals("55555555555") ||
                getValue().equals("66666666666") || getValue().equals("77777777777") ||
                getValue().equals("88888888888") || getValue().equals("99999999999") ||
                (getValue().length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protects the code against possible type (int) conversion errors
        try {
            // Calculation of the 1st Verifying digit
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // Converts the i-th character of the CPF into a number:
                // For example, transform the character '0' into the integer 0
                // (48 is the position of '0' in the ASCII table)
                num = (int)(getValue().charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converts to the respective numerical character

            // Calculation of the 2and. Verifying digit
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(getValue().charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Checks if the calculated digits match the entered digits.
            if ((dig10 == getValue().charAt(9)) && (dig11 == getValue().charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
}
