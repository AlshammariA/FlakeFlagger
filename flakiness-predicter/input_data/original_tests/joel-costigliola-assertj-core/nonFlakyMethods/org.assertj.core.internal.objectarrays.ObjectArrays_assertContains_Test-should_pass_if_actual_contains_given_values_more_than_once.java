@Test public void should_pass_if_actual_contains_given_values_more_than_once(){
  actual=array("Luke","Yoda","Leia","Luke","Luke");
  arrays.assertContains(someInfo(),actual,array("Luke"));
}
