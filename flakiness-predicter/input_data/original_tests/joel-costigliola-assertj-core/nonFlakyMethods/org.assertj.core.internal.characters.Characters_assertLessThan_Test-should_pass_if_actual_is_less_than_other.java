@Test public void should_pass_if_actual_is_less_than_other(){
  characters.assertLessThan(someInfo(),'a','b');
}
