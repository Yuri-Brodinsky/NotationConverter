package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class NotationConverterTest {
    private static NotationConverter converter;
    @BeforeAll
    public static void init(){
        converter = new NotationConverter();
    }
    @Test
    public void shouldBe3() throws InvalidValueException {
        int res = converter.toArabic("III");
        Assertions.assertEquals(3,res);
    }
    @Test
    public void shouldBe12() throws InvalidValueException {
        int res = converter.toArabic("XII");
        Assertions.assertEquals(12,res);
    }
    @Test
    public void shouldBe59() throws InvalidValueException {
        int res = converter.toArabic("LIX");
        Assertions.assertEquals(59,res);
    }
    @Test
    public void shouldBe1990() throws InvalidValueException {
        int res = converter.toArabic("MCMXC");
        Assertions.assertEquals(1990,res);
    }
    @Test
    public void shouldThrowExceptionCaseOne() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic("1"));
        Assertions.assertEquals("String must contain only valid roman numerals [I,V,X,L,C,D,M].",
                thrown.getMessage());
    }
    @Test
    public void shouldThrowExceptionCaseTwo() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic("VI1"));
        Assertions.assertEquals("String must contain only valid roman numerals [I,V,X,L,C,D,M].",
                thrown.getMessage());
    }
    @Test
    public void shouldThrowExceptionCaseThree() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic("A"));
        Assertions.assertEquals("String must contain only valid roman numerals [I,V,X,L,C,D,M].",
                thrown.getMessage());
    }
    @Test
    public void shouldThrowExceptionCaseFour() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic(""));
        Assertions.assertEquals("String must contain only valid roman numerals [I,V,X,L,C,D,M].",
                thrown.getMessage());
    }
    @Test
    public void shouldThrowExceptionCaseFive() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic("MXM"));
        Assertions.assertEquals("The preceding lesser numeral cannot be less than ten times.",
                thrown.getMessage());
    }
    @Test
    public void shouldThrowExceptionCaseSix() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic("IIV"));
        Assertions.assertEquals("The order of the numerals is violated.",
                thrown.getMessage());
    }
    @Test
    public void shouldThrowExceptionCaseSeven() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic("XIXI"));
        Assertions.assertEquals("The order of the numerals is violated.",
                thrown.getMessage());
    }
    @Test
    public void shouldThrowExceptionCaseEight() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic("IXIX"));
        Assertions.assertEquals("The order of the numerals is violated.",
                thrown.getMessage());
    }
    @Test
    public void shouldThrowExceptionCaseNine() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic("VIIII"));
        Assertions.assertEquals("The order of the numerals is violated.",
                thrown.getMessage());
    }
    @Test
    public void shouldBe2143() throws Exception {
        int res = converter.toArabic("MMCXLIII");
        Assertions.assertEquals(2143,res);
    }
    @Test
    public void shouldThrowExceptionCaseTen() throws InvalidValueException {
        Throwable thrown = Assertions.assertThrowsExactly(
                InvalidValueException.class,()->converter.toArabic(null));
        Assertions.assertEquals("String must contain only valid roman numerals [I,V,X,L,C,D,M].",
                thrown.getMessage());
    }




}