@Test public void should_pass_if_actual_and_sequence_are_equal(){
  iterables.assertStartsWith(someInfo(),actual,array("Yoda","Luke","Leia","Obi-Wan"));
}
