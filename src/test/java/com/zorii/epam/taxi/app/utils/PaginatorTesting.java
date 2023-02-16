package com.zorii.epam.taxi.app.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static com.zorii.epam.taxi.app.utils.Paginator.*;

public class PaginatorTesting {
    @ParameterizedTest
    @MethodSource("testCalcPagesNumArgumentsSupplier")
    void TestCalculatePagesNum(int totalRecordsNum, int pagesNum) {
        assertEquals(calculatePagesNum(totalRecordsNum), pagesNum);
    }

    static Stream<Arguments> testCalcPagesNumArgumentsSupplier() {
        return Stream.of(
                Arguments.of(54, 6),
                Arguments.of(30, 3),
                Arguments.of(11, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testCalcOffsetArgumentsSupplier")
    void TestCalculateOffset(int currentPage, int offset) {
        assertEquals(calculateOffset(currentPage), offset);
    }

    static Stream<Arguments> testCalcOffsetArgumentsSupplier() {
        return Stream.of(
                Arguments.of(5, 50),
                Arguments.of(1, 10),
                Arguments.of(7, 70)
        );
    }

}
