@Test public void should_pass_if_actual_contains_sequence(){
  arrays.assertContainsSequence(someInfo(),actual,arrayOf(true,false));
}
