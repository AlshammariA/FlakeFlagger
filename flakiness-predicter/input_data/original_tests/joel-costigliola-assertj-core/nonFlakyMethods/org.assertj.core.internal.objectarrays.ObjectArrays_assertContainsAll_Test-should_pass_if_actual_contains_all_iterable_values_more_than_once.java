@Test public void should_pass_if_actual_contains_all_iterable_values_more_than_once(){
  actual=array("Luke","Yoda","Leia","Luke","Luke");
  arrays.assertContainsAll(someInfo(),actual,newArrayList("Luke"));
}
