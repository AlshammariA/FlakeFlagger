@Test public void should_pass_if_actual_contains_given_values_exactly_with_null_elements(){
  actual=array("Luke","Yoda","Leia",null);
  arrays.assertContainsExactly(someInfo(),actual,array("Luke","Yoda","Leia",null));
}
