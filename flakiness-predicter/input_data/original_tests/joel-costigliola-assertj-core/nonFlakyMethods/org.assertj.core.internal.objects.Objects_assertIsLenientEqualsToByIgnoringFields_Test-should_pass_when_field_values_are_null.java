@Test public void should_pass_when_field_values_are_null(){
  Jedi actual=new Jedi("Yoda",null);
  Jedi other=new Jedi("Yoda",null);
  objects.assertIsEqualToIgnoringGivenFields(someInfo(),actual,other,"name");
}
