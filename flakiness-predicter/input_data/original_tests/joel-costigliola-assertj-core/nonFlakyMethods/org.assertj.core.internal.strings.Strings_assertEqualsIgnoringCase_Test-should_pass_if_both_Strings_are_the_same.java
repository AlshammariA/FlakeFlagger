@Test public void should_pass_if_both_Strings_are_the_same(){
  String s="Yoda";
  strings.assertEqualsIgnoringCase(someInfo(),s,s);
}
