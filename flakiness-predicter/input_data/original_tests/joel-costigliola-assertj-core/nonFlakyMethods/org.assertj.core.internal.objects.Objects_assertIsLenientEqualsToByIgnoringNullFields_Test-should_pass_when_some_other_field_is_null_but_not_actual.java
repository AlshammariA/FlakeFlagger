@Test public void should_pass_when_some_other_field_is_null_but_not_actual(){
  Jedi actual=new Jedi("Yoda","Green");
  Jedi other=new Jedi("Yoda",null);
  objects.assertIsLenientEqualsToIgnoringNullFields(someInfo(),actual,other);
}
