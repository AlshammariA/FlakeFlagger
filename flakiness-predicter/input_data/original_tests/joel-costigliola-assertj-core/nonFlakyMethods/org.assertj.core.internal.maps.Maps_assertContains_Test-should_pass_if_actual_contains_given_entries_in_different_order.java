@Test public void should_pass_if_actual_contains_given_entries_in_different_order(){
  maps.assertContains(someInfo(),actual,array(entry("color","green"),entry("name","Yoda")));
}
