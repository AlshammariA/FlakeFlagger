@Test public void should_pass_if_actual_contains_subsequence_without_elements_between(){
  iterables.assertContainsSubsequence(someInfo(),actual,array("Luke","Leia"));
}
