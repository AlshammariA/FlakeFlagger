@Test public void should_pass_if_actual_contains_sequence(){
  arrays.assertContainsSequence(someInfo(),actual,arrayOf(6L,8L));
}
