@Test public void should_pass_if_actual_is_contains_given_string_only_once(){
  strings.assertContainsOnlyOnce(someInfo(),"Yoda","Yo");
}
