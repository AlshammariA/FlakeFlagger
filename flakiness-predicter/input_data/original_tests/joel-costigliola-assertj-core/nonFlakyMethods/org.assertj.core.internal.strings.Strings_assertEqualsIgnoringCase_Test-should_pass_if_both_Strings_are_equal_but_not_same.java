@Test public void should_pass_if_both_Strings_are_equal_but_not_same(){
  strings.assertEqualsIgnoringCase(someInfo(),"Yoda",new String(arrayOf('Y','o','d','a')));
}
