@Test public void should_pass_when_not_ignored_inherited_fields_are_equal(){
  Jedi actual=new Jedi("Yoda","Green");
  Jedi other=new Jedi("Luke","Green");
  objects.assertIsEqualToIgnoringGivenFields(someInfo(),actual,other,"name");
}
