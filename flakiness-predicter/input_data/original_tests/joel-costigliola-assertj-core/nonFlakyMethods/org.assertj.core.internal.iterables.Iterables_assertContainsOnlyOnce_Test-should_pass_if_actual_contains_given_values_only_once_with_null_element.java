@Test public void should_pass_if_actual_contains_given_values_only_once_with_null_element(){
  actual.add(null);
  iterables.assertContainsOnlyOnce(someInfo(),actual,array("Luke",null,"Yoda","Leia",null));
}
