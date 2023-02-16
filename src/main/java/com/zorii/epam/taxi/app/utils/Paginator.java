package com.zorii.epam.taxi.app.utils;

public class Paginator {
    public static final int DEFAULT_PAGE_CAPACITY = 2;
    public static final int DEFAULT_PAGES_AVAILABLE = 3;

    public static int calculateOffset(int currentPage) {
        return currentPage * DEFAULT_PAGE_CAPACITY - DEFAULT_PAGE_CAPACITY;
    }

    public static int calculatePagesNum(int totalRecordsNum) {
        return totalRecordsNum / DEFAULT_PAGE_CAPACITY +
                (totalRecordsNum % DEFAULT_PAGE_CAPACITY == 0 ? 0 : 1);
    }

    public static int calculateStartPage(int currentPage, int numOfPages) {
        if (currentPage == 1) {
            return currentPage;
        }
        if (currentPage == numOfPages) {
            return currentPage - DEFAULT_PAGES_AVAILABLE + 1;
        }
        return currentPage - DEFAULT_PAGES_AVAILABLE / 2;
    }

    public static int calculateEndPage(int currentPage, int numOfPages) {
        if (numOfPages < DEFAULT_PAGES_AVAILABLE) {
            return numOfPages;
        }
        if (currentPage == 1) {
            return DEFAULT_PAGES_AVAILABLE;
        }
        if (currentPage == numOfPages) {
            return currentPage;
        }
        return currentPage + DEFAULT_PAGES_AVAILABLE / 2;
    }

    private Paginator() {
    }
}
