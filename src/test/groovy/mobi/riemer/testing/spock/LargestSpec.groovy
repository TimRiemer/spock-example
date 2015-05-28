package mobi.riemer.testing.spock

import spock.lang.Specification


/**
 * Spock framework test project inspired by
 * http://edgibbs.com/spock-intro-a-bdd-testing-framework-in-groovy/
 *
 * @author Tim Riemer
 * @version 0.1 , 22.01.2015
 *
 */
class LargestSpec extends Specification {

   def "Largest number should be returned when first in list"() {
      when:
      def largest = Largest.max([3, 2, 1])

      then:
      largest == 3
   }

   def "Largest number should be returned regardless of order"() {
      expect:
      Largest.max([first, second, third]) == largest

      where:
//      first << [2, 4, 8]
//      second << [4, 8, 2]
//      third << [8, 2, 4]
//      largest << [8, 8, 8]
      first | second | third | largest
      2     | 4      | 8     | 8
      4     | 8      | 2     | 8
      8     | 2      | 4     | 8
   }

   def "Largest number should be returned even with duplicates"() {
      expect:
      Largest.max([8, 7, 3, 3]) == 8
   }

   def "Largest number should work with only a single entry"() {
      when:
      def largest = Largest.max([1])

      then:
      largest == 1
   }

   def "Largest number with a 10 item list should work"() {
      given:
      def list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

      when:
      def largest = Largest.max(list)

      then:
      largest == 9
   }

   def "Largest will return correct negative numbers"() {
      when:
      def largest = Largest.max([-9, -8, -7])

      then:
      largest == -7
   }

   def "Largest will fail on an empty list wirh error message"() {
      when:
      def largest = Largest.max([])

      then:
      RuntimeException error = thrown()
      error.message == "max: Empty List"
   }

   def "Should return exception if passing in null"() {
      when:
      def largest = Largest.max(null)

      then:
      RuntimeException error = thrown()
      error.message == "max: Empty List"
   }
}