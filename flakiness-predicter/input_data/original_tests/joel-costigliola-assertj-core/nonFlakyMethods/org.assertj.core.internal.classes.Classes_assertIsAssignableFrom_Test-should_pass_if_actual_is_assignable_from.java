@Test public void should_pass_if_actual_is_assignable_from(){
  actual=Jedi.class;
  classes.assertIsAssignableFrom(someInfo(),actual,HumanJedi.class);
}
