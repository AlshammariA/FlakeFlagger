@Test public void should_pass_when_selected_field_is_private_and_private_field_use_is_allowed(){
  Jedi actual=new Jedi("Yoda","Green");
  Jedi other=new Jedi("Yoda","Blue");
  objects.assertIsEqualToComparingOnlyGivenFields(someInfo(),actual,other,"strangeNotReadablePrivateField");
}
