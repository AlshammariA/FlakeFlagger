@Test public void should_pass_if_actual_contains_given_values_only_once_even_if_duplicated(){
  arrays.assertContainsOnlyOnce(someInfo(),actual,array("Luke","Yoda","Leia","Luke","Yoda","Leia"));
}
