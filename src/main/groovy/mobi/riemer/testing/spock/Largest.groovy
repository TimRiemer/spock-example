package mobi.riemer.testing.spock

/**
 *
 * @author tiri
 * @version 0.1 , 22.01.2015
 *
 */
class Largest {

   def static max(list) {
      def maximum
      if (!list) {
         throw new RuntimeException("max: Empty List")
      }
      list.each { item ->
         if (item > maximum) {
            maximum = item
         }
      }
      maximum
   }
}
