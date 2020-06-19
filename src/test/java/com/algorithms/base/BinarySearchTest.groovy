package com.algorithms.base

import spock.lang.Specification

class BinarySearchTest extends Specification {

    def testSearch() {
        given:
        BinarySearch binarySearch = new BinarySearch();

        when:
        def actual = binarySearch.binarySearch(toFind, array as int[])

        then:
        expected == actual

        where:
        array              | toFind | expected
        [1, 2, 3, 4, 5]    | 1      | 0
        [1, 2, 3, 4, 5]    | 2      | 1
        [1, 2, 3, 4, 5]    | 3      | 2
        [1, 2, 3, 4, 5]    | 4      | 3
        [1, 2, 3, 4, 5]    | 5      | 4
        [1, 2, 3, 4, 5, 6] | 1      | 0
        [1, 2, 3, 4, 5, 6] | 2      | 1
        [1, 2, 3, 4, 5, 6] | 3      | 2
        [1, 2, 3, 4, 5, 6] | 4      | 3
        [1, 2, 3, 4, 5, 6] | 5      | 4
        [1, 2, 3, 4, 5, 6] | 6      | 5
    }

}
