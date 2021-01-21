@Test public void should_pass_if_actual_contains_given_values_exactly_with_null_elements(){
  iterables.assertContainsExactly(someInfo(),actual,array("Luke","Yoda","Leia"));
  actual.add(null);
  iterables.assertContainsExactly(someInfo(),actual,array("Luke","Yoda","Leia",null));
}
