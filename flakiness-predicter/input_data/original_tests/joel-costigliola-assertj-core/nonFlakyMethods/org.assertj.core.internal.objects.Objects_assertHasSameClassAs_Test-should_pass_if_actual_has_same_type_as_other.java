@Test public void should_pass_if_actual_has_same_type_as_other(){
  objects.assertHasSameClassAs(someInfo(),actual,new Person("Luke"));
}
