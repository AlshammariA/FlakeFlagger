@Test public void should_pass_if_actual_and_subsequence_are_equal(){
  iterables.assertContainsSubsequence(someInfo(),actual,array("Yoda","Luke","Leia","Obi-Wan"));
}
