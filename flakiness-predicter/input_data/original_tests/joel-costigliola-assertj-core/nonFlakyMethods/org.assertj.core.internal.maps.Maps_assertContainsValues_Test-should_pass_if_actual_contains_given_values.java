@Test public void should_pass_if_actual_contains_given_values(){
  maps.assertContainsValues(someInfo(),actual,"Yoda","Jedi");
}
