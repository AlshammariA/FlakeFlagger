@Test public void should_pass_if_actual_contains_given_values_more_than_once(){
  actual.addAll(newArrayList("Luke","Luke"));
  iterables.assertContains(someInfo(),actual,array("Luke"));
}
