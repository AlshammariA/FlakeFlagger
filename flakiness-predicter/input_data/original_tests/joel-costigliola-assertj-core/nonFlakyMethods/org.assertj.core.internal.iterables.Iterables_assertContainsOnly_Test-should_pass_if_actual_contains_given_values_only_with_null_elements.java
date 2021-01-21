@Test public void should_pass_if_actual_contains_given_values_only_with_null_elements(){
  iterables.assertContainsOnly(someInfo(),actual,array("Luke","Yoda","Leia"));
  actual.add(null);
  actual.add(null);
  iterables.assertContainsOnly(someInfo(),actual,array("Luke",null,"Yoda","Leia",null));
}
